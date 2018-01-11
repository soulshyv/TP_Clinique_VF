package clinique.ihm.gestionPersonnel.ajouterPersonnel;

import javax.swing.JDialog;
import clinique.services.BLLException;

@SuppressWarnings("serial")
public class EcranAjouterPersonnel extends JDialog {
	public EcranAjouterPersonnel() throws BLLException {
		initializeComponents();
	}

	private void initializeComponents() throws BLLException {
		JPanelAjouterPersonnel mainPanel = new JPanelAjouterPersonnel(this);
    	
		this.add(mainPanel);
		this.setSize(420, 220);
		this.setTitle("Ajouter un employé");
		this.setLocationRelativeTo(null);
		this.setModal(true);
	}
}
