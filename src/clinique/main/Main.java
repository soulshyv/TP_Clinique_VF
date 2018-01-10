package clinique.main;

import javax.swing.SwingUtilities;

import clinique.ihm.connexion.FenetreConnexion;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FenetreConnexion ecranPrincipal = new FenetreConnexion();
			}
		});
	}

}