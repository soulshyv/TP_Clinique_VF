package clinique.ihm.ecranClient;

import javax.swing.JFrame;

import clinique.services.BLLException;

public class FenetreClient extends JFrame {
	
	public FenetreClient() throws BLLException{
		JPanelMenu panelMenu = new JPanelMenu(this);
		this.add(panelMenu);
		this.setSize(500, 500);
		this.setTitle("Clients");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
