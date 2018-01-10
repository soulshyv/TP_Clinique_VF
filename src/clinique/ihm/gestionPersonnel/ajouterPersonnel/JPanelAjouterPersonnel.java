package clinique.ihm.gestionPersonnel.ajouterPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clinique.services.BLLException;

@SuppressWarnings("serial")
public class JPanelAjouterPersonnel extends JPanel {
	public JDialog Parent;

	public JTextField TextInputNom, MotDePasse;

	public JButton btnValider;

	public JPanelAjouterPersonnel(JDialog parent) throws BLLException {
		Parent = parent;

		initializeComponents(parent);
	}

	private void initializeComponents(JDialog parent2) throws BLLException {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;

	}

}
