package clinique.ihm.client.ajouterAnimal;

import javax.swing.JDialog;
import clinique.services.BLLException;

@SuppressWarnings("serial")
public class EcranAjouterAnimaux extends JDialog {
	
	public EcranAjouterAnimaux() throws BLLException {
		initializeComponents();
	}

	private void initializeComponents() throws BLLException {
		JPanelAjouterAnimaux mainPanel = new JPanelAjouterAnimaux(this);
    	
		this.add(mainPanel);
		this.setSize(420, 220);
		this.setTitle("Ajouter un animal");
		this.setLocationRelativeTo(null);
		this.setModal(true);
	}
}