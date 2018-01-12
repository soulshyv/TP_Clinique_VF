package clinique.ihm.ecranClient;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.AnimalManager;
import clinique.services.BLLException;
import clinique.services.ClientManager;

@SuppressWarnings("serial")
public class JPanelTabInsert extends JPanel {
	
	public JPanelMenu panelParentMenu;
	
	public JPanelTableau panelTab;
	
	public JPanelInsert panelInsert;
	
	public JPanelMenu getPanelParentMenu() {
		return panelParentMenu;
	}



	public JPanelTabInsert(JPanelMenu parent) throws BLLException{
		panelParentMenu = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		GridBagConstraints gbc = new GridBagConstraints();
		ClientManager clientManager = ClientManager.getInstance();
		
    	gbc.insets = new Insets(5, 5, 5, 5);
    	
    	panelInsert = new JPanelInsert(this);
    	panelTab = new JPanelTableau(this);
		AnimalManager animalManager = AnimalManager.getInstance();
		clientManager.addObserver(panelTab);
		
		gbc.gridx = 0;
    	gbc.gridy = 0;
    	this.add(panelInsert);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	this.add(panelTab);
		//this.add(monPanel1);
		//this.add(monPanel2);
	}
}
