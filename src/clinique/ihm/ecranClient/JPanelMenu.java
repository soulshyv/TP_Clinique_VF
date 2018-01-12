package clinique.ihm.ecranClient;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.BLLException;

@SuppressWarnings("serial")
public class JPanelMenu extends JPanel {
	
	public JFrame FrameParent;
	public JPanelTabInsert monPanelTabInsert;
	public JPanelButton panelButton;
	
	
	
	public JFrame getFrameParent() {
		return FrameParent;
	}



	public JPanelMenu(JFrame parent) throws BLLException{
		FrameParent = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
    	gbc.insets = new Insets(5, 5, 5, 5);
    	panelButton = new JPanelButton(this);
		monPanelTabInsert = new JPanelTabInsert(this);
		this.add(panelButton);
		this.add(monPanelTabInsert);
		
	}
}
