package clinique.ihm.ecranClient;

import javax.swing.JFrame;

import clinique.services.BLLException;

public class FenetreClient extends JFrame {
	
	public JPanelMenu panelMenu;
	
	public FenetreClient() throws BLLException{
		panelMenu = new JPanelMenu(this);
		this.add(panelMenu);
		this.setSize(800, 600);
		this.setTitle("Clients");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
