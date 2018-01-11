package clinique.ihm.gestionPersonnel;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clinique.services.BLLException;

@SuppressWarnings("serial")
public class EcranGestionPersonnel extends JFrame {
	private JFrame FrameParent;
	private JPanelGestionPersonnel MainPanel;
	
	public JFrame getFrameParent() {
		return FrameParent;
	}
	public JPanelGestionPersonnel getMainPanel() {
		return MainPanel;
	}
	
	public EcranGestionPersonnel(JFrame parent) throws BLLException {
		FrameParent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() throws BLLException {
		MainPanel = new JPanelGestionPersonnel(this);
    	
		this.add(MainPanel);
		this.setSize(500, 350);
		this.setTitle("Employés");
		this.setLocationRelativeTo(null);
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
