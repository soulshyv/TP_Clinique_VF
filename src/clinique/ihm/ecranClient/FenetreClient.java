package clinique.ihm.ecranClient;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import clinique.ihm.connexion.EcranConnexion;
import clinique.services.BLLException;

@SuppressWarnings("serial")
public class FenetreClient extends JFrame {
	private EcranConnexion FrameParent;
	
	public JPanelMenu panelMenu;
	
	public FenetreClient(EcranConnexion parent) throws BLLException{
		FrameParent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() throws BLLException {
		panelMenu = new JPanelMenu(this);
		this.add(panelMenu);
		this.setSize(800, 600);
		this.setTitle("Clients");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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
