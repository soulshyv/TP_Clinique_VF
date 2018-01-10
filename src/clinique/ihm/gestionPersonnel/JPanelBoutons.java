package clinique.ihm.gestionPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clinique.ihm.gestionPersonnel.ajouterPersonnel.EcranAjouterPersonnel;
import clinique.services.BLLException;

@SuppressWarnings("serial")
public class JPanelBoutons extends JPanel {
	public JFrame Parent;
	
	public JButton btnAjouter,
		btnSupprimer,
		btnReset;
	
	public JPanelBoutons(JFrame parent) 
	{
		Parent = parent;
		
		initializeComponents();
    	
    	initializeListener();
	}

	private void initializeComponents() {
		this.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	gbc.gridy = 0;
    	
    	this.btnAjouter = new JButton("Ajouter");
    	this.btnSupprimer = new JButton("Supprimer");
    	this.btnReset = new JButton("Réinitialiser");
    	
    	gbc.gridx = 0;
    	this.add(btnAjouter, gbc);
    	gbc.gridx = 1;
    	this.add(btnSupprimer, gbc);
    	gbc.gridx = 2;
    	this.add(btnReset, gbc);
	}

	private void initializeListener() {
		this.btnAjouter.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					EcranAjouterPersonnel ecrAjoutPers = new EcranAjouterPersonnel();
					ecrAjoutPers.setVisible(true);
				} catch (BLLException ex) {
					JOptionPane.showMessageDialog(Parent, ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
