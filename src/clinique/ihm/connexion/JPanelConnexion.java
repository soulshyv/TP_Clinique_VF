package clinique.ihm.connexion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinique.ihm.ecranClient.FenetreClient;
import clinique.ihm.gestionPersonnel.EcranGestionPersonnel;
import clinique.ihm.rdv.EcranRdv;
import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelConnexion extends JPanel {
	private EcranConnexion FrameParent;
	
	private JTextField TextInputConnexion;
	
	private JPasswordField TextInputMotDePasse;
	
	private JButton JButtonValider;
	
	
	public JPanelConnexion(EcranConnexion parent){
		FrameParent = parent;
		
		initializeComponents();
    	
    	initializeListener();
	}

	private void initializeComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	
    	this.setLayout(new GridBagLayout());
    	
    	//Champ nom
    	JLabel textLabelConnexion = new JLabel("Nom");
    	this.TextInputConnexion = new JTextField(15);
    	
    	//Champ mot de passe
    	JLabel textLabelMotDePasse = new JLabel("Mot de passe");
    	this.TextInputMotDePasse = new JPasswordField(15);
    	
    	//Bouton de validation
    	this.JButtonValider = new JButton("Valider");
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	this.add(textLabelConnexion, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	this.add(TextInputConnexion, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	this.add(textLabelMotDePasse, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	this.add(TextInputMotDePasse, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 2;
    	this.add(JButtonValider, gbc);
	}

	private void initializeListener() {
		//Click bouton valider
		JButtonValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//On v�rifie que les champs sont remplis
					if(TextInputConnexion.getText().trim() == "" || String.valueOf(TextInputMotDePasse.getPassword()).trim() == "")
						throw new Exception("Veuillez renseigner tous les champs");
						
					//On v�rifie les logs donn�s
					PersonnelManager PersMng = PersonnelManager.getInstance();
					String role = PersMng.ConnexionEmploye(TextInputConnexion.getText(), String.valueOf(TextInputMotDePasse.getPassword()));
					if(role == null || role.trim() == "")
						throw new Exception("Identifiants de connexion erron�s");
					
					//On lance la fen�tre correspondant au r�le
					JFrame ecr = null;
					switch(role)
					{
						case "sec":
							ecr = new FenetreClient(FrameParent);
							ecr.setVisible(true);
							break;
							
						case "vet":
							ecr = new EcranRdv(FrameParent);
							break;
							
						case "adm":
							ecr = new EcranGestionPersonnel(FrameParent);
							ecr.setVisible(true);
							break;
							
						default:
							throw new BLLException("Vous n'avez pas les permissions requises");
					}
					
					//On rend invisible la fen�tre de connexion et on vide les champs
					FrameParent.setVisible(false);
					TextInputConnexion.setText("");
					TextInputMotDePasse.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(FrameParent, ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
