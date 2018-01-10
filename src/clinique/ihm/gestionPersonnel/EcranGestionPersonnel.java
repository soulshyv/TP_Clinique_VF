package clinique.ihm.gestionPersonnel;

import javax.swing.JFrame;

import fr.eni.papeterie.bll.BLLException;

public class EcranGestionPersonnel extends JFrame {

	public EcranGestionPersonnel() {
		JPanelGestionPersonnel mainPanel = new JPanelGestionPersonnel();
    	
		this.add(mainPanel);
		this.setSize(1000, 1000);
		this.setTitle("Employés");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
