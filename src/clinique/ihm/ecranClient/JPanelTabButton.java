package clinique.ihm.ecranClient;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.AnimalManager;
import clinique.services.BLLException;
import clinique.services.ClientManager;

public class JPanelTabButton extends JPanel {
	
	public JPanelTabInsert panelParentMenu;
	
	public JPanelTableau panelTab;
	
	public JPanelButtonAjouter panelAjouter;
	
	public JPanelTabInsert getPanelParentMenu() {
		return panelParentMenu;
	}



	public JPanelTabButton(JPanelTabInsert JPanelTabInsert) throws BLLException{
		panelParentMenu = JPanelTabInsert;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		ClientManager clientManager = ClientManager.getInstance();
		
    	gbc.insets = new Insets(5, 5, 5, 5);
    	
    	panelAjouter = new JPanelButtonAjouter(this);
    	panelTab = new JPanelTableau(this);
		AnimalManager animalManager = AnimalManager.getInstance();
		//clientManager.addObserver(panelTab);
		animalManager.addObserver(panelTab);
		
		gbc.gridx = 0;
    	gbc.gridy = 1;
    	this.add(panelAjouter, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	this.add(panelTab, gbc);
		//this.add(monPanel1);
		//this.add(monPanel2);
	}
}