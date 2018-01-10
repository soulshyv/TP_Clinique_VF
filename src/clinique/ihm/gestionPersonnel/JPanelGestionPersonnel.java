package clinique.ihm.gestionPersonnel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.BLLException;

@SuppressWarnings("serial")
public class JPanelGestionPersonnel extends JPanel {
	public JPanelGestionPersonnel(JFrame parent) throws BLLException
	{
		initializeComponents(parent);
	}

	private void initializeComponents(JFrame parent) throws BLLException {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanelBoutons boutonsPanel = new JPanelBoutons(parent);
		JPanelListeEmployes listeEmployesPanel = new JPanelListeEmployes(parent);
		this.add(boutonsPanel);
		this.add(listeEmployesPanel);
	}
	
}