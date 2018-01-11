package clinique.ihm.rdv;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelForm extends JPanel {
	private JPanelRdv PanelParent;
	
	private JPanelFormAnimalClient PanelFormAnimCli;
	private JPanelFormVeto PanelFormVeto;
	private JPanelFormRdv PanelFormRdv;
	
	public JPanelRdv getPanelParent() {
		return PanelParent;
	}

	public JPanelFormAnimalClient getPanelFormAnimCli() {
		return PanelFormAnimCli;
	}

	public JPanelFormVeto getPanelFormVeto() {
		return PanelFormVeto;
	}

	public JPanelFormRdv getPanelFormRdv() {
		return PanelFormRdv;
	}

	public JPanelForm(JPanelRdv parent)
	{
		PanelParent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() {
		PanelFormAnimCli = new JPanelFormAnimalClient(this);
		PanelFormVeto = new JPanelFormVeto(this);
		PanelFormRdv = new JPanelFormRdv(this);
	}
}
