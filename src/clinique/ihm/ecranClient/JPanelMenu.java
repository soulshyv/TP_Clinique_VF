package clinique.ihm.ecranClient;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.BLLException;

public class JPanelMenu extends JPanel {
	
	public JFrame Parent;
	
	public JPanelMenu(JFrame parent) throws BLLException{
		Parent = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanelTabButton monPanel1 = new JPanelTabButton(parent);
		this.add(monPanel1);
		
	}
}
