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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinique.services.BLLException;

@SuppressWarnings("serial")
public class JPanelAjouterPersonnel extends JPanel {
	public JDialog Parent;

	public JTextField TextInputNom;
	
	public JPasswordField TextInputMdp;
	
	public JComboBox<String> ComboBoxRole;

	public JButton btnValider;

	public JPanelAjouterPersonnel(JDialog parent) throws BLLException {
		Parent = parent;

		initializeComponents(parent);
		
		initializeListener(parent);
	}

	private void initializeComponents(JDialog parent) throws BLLException {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		this.setLayout(new GridBagLayout());
		
		JLabel textLabelNom = new JLabel("Nom");
		TextInputNom = new JTextField(15);
		
		JLabel textLabelMdp = new JLabel("Mot de passe");
		TextInputMdp = new JPasswordField(15);

		String[] couleurStrings = { "Secrétaire", "Vétérinaire", "Administrateur" };
		ComboBoxRole = new JComboBox<String>(couleurStrings);
		
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
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(btnValider, gbc);

	}

	private void initializeListener(JDialog parent) {
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Personnel cl = new Personnel(TextInputNom.getText(), String.valueOf(TextInputMdp.getPassword()));
			}
		});
	}

}
