package clinique.ihm.gestionPersonnel;

import javax.swing.JFrame;

import clinique.services.BLLException;

@SuppressWarnings("serial")
public class EcranGestionPersonnel extends JFrame {

	public EcranGestionPersonnel() throws BLLException {
		initializeComponents();
	}

	private void initializeComponents() throws BLLException {
		JPanelGestionPersonnel mainPanel = new JPanelGestionPersonnel(this);
    	
		this.add(mainPanel);
		this.setSize(500, 350);
		this.setTitle("Employés");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
