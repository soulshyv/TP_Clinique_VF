package clinique.ihm.gestionPersonnel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelGestionPersonnel extends JPanel {
	private EcranGestionPersonnel FrameParent;
	private JPanelBoutons BoutonsPanel;
	private JPaneTabEmployes ListeEmployesPanel;
	
	public EcranGestionPersonnel getFrameParent() {
		return FrameParent;
	}

	public JPanelBoutons getBoutonsPanel() {
		return BoutonsPanel;
	}

	public JPaneTabEmployes getListeEmployesPanel() {
		return ListeEmployesPanel;
	}

	public JPanelGestionPersonnel(EcranGestionPersonnel parent) throws BLLException
	{
		FrameParent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() throws BLLException {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		BoutonsPanel = new JPanelBoutons(this);
		ListeEmployesPanel = new JPaneTabEmployes(this);
		PersonnelManager persMng = PersonnelManager.getInstance();
		persMng.addObserver(ListeEmployesPanel);
		this.add(BoutonsPanel);
		this.add(ListeEmployesPanel);
	}
	
}