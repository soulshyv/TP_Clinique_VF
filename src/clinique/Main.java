package clinique;

import javax.swing.SwingUtilities;

import clinique.ihm.connexion.EcranConnexion;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				EcranConnexion ecranPrincipal = new EcranConnexion();
			}
		});
	}

}