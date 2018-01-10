package clinique.ihm;

import javax.swing.JFrame;

public class FenetreConnexion  extends JFrame {
	public FenetreConnexion() {
		JPanelConnexion connexionPanel = new JPanelConnexion();
		this.add(connexionPanel);
		this.setSize(380, 220);
		this.setTitle("Connexion");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
