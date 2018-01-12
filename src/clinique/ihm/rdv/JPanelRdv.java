package clinique.ihm.rdv;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelRdv extends JPanel {
	private EcranRdv FrameParent;
	
	private JPanelForm PanelForm;
	private JPanelTabRdv PanelTabRdv;
	private JPanelBoutons PanelBoutons;
	
	public EcranRdv getFrameParent() {
		return FrameParent;
	}

	public JPanelForm getPanelForm() {
		return PanelForm;
	}

	public JPanelTabRdv getPanelTabRdv() {
		return PanelTabRdv;
	}

	public JPanelBoutons getPanelBoutons() {
		return PanelBoutons;
	}

	public JPanelRdv(EcranRdv parent)
	{
		FrameParent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		PanelForm = new JPanelForm(this);
		PanelTabRdv = new JPanelTabRdv(this);
		PanelBoutons = new JPanelBoutons(this);

		this.add(PanelForm);
		this.add(PanelTabRdv);
		this.add(PanelBoutons);
	}
}
