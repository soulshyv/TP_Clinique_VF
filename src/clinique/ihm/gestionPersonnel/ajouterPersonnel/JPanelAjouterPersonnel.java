package clinique.ihm.gestionPersonnel.ajouterPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinique.models.Personnel;
import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelAjouterPersonnel extends JPanel {
	private JDialog Parent;

	private JTextField TextInputNom;
	
	private JPasswordField TextInputMdp;
	
	private JComboBox<String> ComboBoxInputRole;

	private JButton btnValider;

	public JPanelAjouterPersonnel(JDialog parent) throws BLLException {
		Parent = parent;

		initializeComponents();
		
		initializeListeners();
	}

	private void initializeComponents() throws BLLException {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		this.setLayout(new GridBagLayout());
		
		JLabel textLabelNom = new JLabel("Nom");
		TextInputNom = new JTextField(15);
		
		JLabel textLabelMdp = new JLabel("Mot de passe");
		TextInputMdp = new JPasswordField(15);

		JLabel textLabelRole = new JLabel("Rôle");
		String[] couleurStrings = { "Secrétaire", "Vétérinaire", "Administrateur" };
		ComboBoxInputRole = new JComboBox<String>(couleurStrings);
		
		btnValider = new JButton("Enregistrer");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(textLabelNom, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(TextInputNom,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(textLabelMdp, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(TextInputMdp, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(textLabelRole, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(ComboBoxInputRole, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(btnValider, gbc);

	}

	private void initializeListeners() {
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String role = "";
					
					//On récupère le rôle
					switch((String)ComboBoxInputRole.getItemAt(ComboBoxInputRole.getSelectedIndex()))
					{
						case "Secrétaire":
							role = "sec";
							break;
							
						case "Vétérinaire":
							role = "vet";
							break;
							
						case "Administrateur":
							role = "adm";
							break;
					}
					Personnel pers = new Personnel(TextInputNom.getText(), String.valueOf(TextInputMdp.getPassword()), role, false);
					PersonnelManager PersMng = PersonnelManager.getInstance();
					
					PersMng.ajouterEmploye(pers);
					JOptionPane.showMessageDialog(Parent, "Enregistrement réussi", "Succès", JOptionPane.INFORMATION_MESSAGE);
					Parent.dispose();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(Parent, ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
