package clinique.ihm.connexion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelConnexion extends JPanel {
	public JFrame Parent;
	
	public JTextField TextInputConnexion;
	
	public JPasswordField TextInputMotDePasse;
	
	public JButton JButtonValider;
	
	
	public JPanelConnexion(JFrame parent){
		Parent = parent;
		
		initializeComponents();
    	
    	initializeListener(parent);
	}

	private void initializeComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	
    	this.setLayout(new GridBagLayout());
    	
    	JLabel textLabelConnexion = new JLabel("Nom");
    	this.TextInputConnexion = new JTextField();
    	TextInputConnexion.setColumns(15);
    	
    	JLabel textLabelMotDePasse = new JLabel("Mot de passe");
    	this.TextInputMotDePasse = new JPasswordField(15);
    	TextInputMotDePasse.setColumns(15);
    	
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

	private void initializeListener(JFrame parent) {
		JButtonValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(TextInputConnexion.getText().trim() == "" || String.valueOf(TextInputMotDePasse.getPassword()).trim() == "")
						throw new Exception("Veuillez renseigner tous les champs");
						
					PersonnelManager PersMng = PersonnelManager.getInstance();
					JFrame ecr = PersMng.ConnexionEmploye(TextInputConnexion.getText(), String.valueOf(TextInputMotDePasse.getPassword()));
					if(ecr == null)
						throw new Exception("Identifiants de connexion erronés");
					
					parent.dispose();
					ecr.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(parent, ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
