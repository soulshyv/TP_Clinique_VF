package clinique.ihm.gestionPersonnel;

import javax.swing.JFrame;

import clinique.services.BLLException;

public class EcranGestionPersonnel extends JFrame {

	public EcranGestionPersonnel() throws BLLException {
		JPanelGestionPersonnel mainPanel = new JPanelGestionPersonnel(this);
    	
		this.add(mainPanel);
		this.setSize(1000, 1000);
		this.setTitle("Employés");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
