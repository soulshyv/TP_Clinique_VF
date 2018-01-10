package clinique.ihm.ecranClient;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.AnimalManager;
import clinique.services.BLLException;

public class JPanelTabButton extends JPanel {
	
	public JFrame Parent;
	
	public JPanelTabButton(JFrame parent) throws BLLException{
		Parent = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanelInsert monPanel1 = new JPanelInsert(parent);
		JPanelTableau monPanel2 = new JPanelTableau(parent);
		AnimalManager animalManager = AnimalManager.getInstance();
		animalManager.addObserver(monPanel2);
		this.add(monPanel1);
		this.add(monPanel2);
	}
}
