package clinique.ihm.gestionPersonnel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.BLLException;
import clinique.services.PersonnelManager;

public class JPanelGestionPersonnel extends JPanel {
	public JPanelGestionPersonnel(JFrame parent) throws BLLException
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanelBoutons boutonsPanel = new JPanelBoutons();
		JPanelListeEmployes listeEmployesPanel = new JPanelListeEmployes(parent);
		PersonnelManager persMng = PersonnelManager.getInstance();
		this.add(boutonsPanel);
		this.add(listeEmployesPanel);
	}
	
}