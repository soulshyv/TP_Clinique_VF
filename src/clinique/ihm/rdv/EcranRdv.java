package clinique.ihm.rdv;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import clinique.ihm.connexion.EcranConnexion;

@SuppressWarnings("serial")
public class EcranRdv extends JFrame{
	private EcranConnexion FrameParent;
	
	private JPanelRdv MainPanel;
	
	public JPanelRdv getMainPanel() {
		return MainPanel;
	}

	public EcranRdv(EcranConnexion parent) {
		FrameParent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() {
		JPanelRdv connexionPanel = new JPanelRdv(this);
		
		this.add(connexionPanel);
		this.setSize(800, 600);
		this.setTitle("Connexion");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        FrameParent.setVisible(true);
		        dispose();
		    }
		});
	}
}
