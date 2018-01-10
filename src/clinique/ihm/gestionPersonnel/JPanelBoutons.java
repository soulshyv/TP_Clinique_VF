package clinique.ihm.gestionPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBoutons extends JPanel {
	public JButton btnAjouter,
		btnSupprimer,
		btnReset;
	
	public JPanelBoutons() 
	{
		this.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	gbc.gridy = 0;
    	
    	this.btnAjouter = new JButton("Ajouter");
    	this.btnSupprimer = new JButton("Supprimer");
    	this.btnReset = new JButton("Réinitialiser");
    	
    	gbc.gridx = 0;
    	this.add(btnAjouter, gbc);
    	gbc.gridx = 1;
    	this.add(btnSupprimer, gbc);
    	gbc.gridx = 2;
    	this.add(btnReset, gbc);
	}
}
