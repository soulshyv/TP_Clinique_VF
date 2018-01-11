package clinique.ihm.gestionPersonnel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import clinique.ihm.gestionPersonnel.ajouterPersonnel.EcranAjouterPersonnel;
import clinique.models.Personnel;
import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelBoutons extends JPanel {
	private JPanelGestionPersonnel PanelParent;
	
	private JButton btnAjouter,
		btnSupprimer,
		btnReset;
	
	public JPanelGestionPersonnel getPanelParent() {
		return PanelParent;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JPanelBoutons(JPanelGestionPersonnel parent) 
	{
		PanelParent = parent;
		
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
		// Bouton enregistrer
		this.btnAjouter.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					EcranAjouterPersonnel ecrAjoutPers = new EcranAjouterPersonnel();
					ecrAjoutPers.setVisible(true);
				} catch (BLLException ex) {
					JOptionPane.showMessageDialog(PanelParent, ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Bouton supprimer
		this.btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JTable listeEmployes = PanelParent.getListeEmployesPanel().getListeEmployes();
					if(listeEmployes.getSelectionModel().isSelectionEmpty() || listeEmployes.getSelectedRows().length != 1)
						throw new Exception("Veuillez sélectionner une ligne");
					
					String name = (String) listeEmployes.getValueAt(listeEmployes.getSelectedRow(), 0);
					PersonnelManager PersMng = PersonnelManager.getInstance();
					List<Personnel> pers = PersMng.rechercherParNom(name);
					if(pers.size() != 1)
						throw new Exception("Erreur d'accès au données de l'employés");
					
					int res = JOptionPane.showConfirmDialog (PanelParent, "Confirmez-vous la suppression de cet employé ?", "Attention", JOptionPane.YES_NO_CANCEL_OPTION);
					if(res == JOptionPane.YES_OPTION)
					{
						PersMng.supprimerEmploye(pers.get(0).getCodeEmp());
						JOptionPane.showMessageDialog(PanelParent, "Suppression réussi", "Succès", JOptionPane.INFORMATION_MESSAGE);
					}
						
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(PanelParent.getFrameParent(), ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Bouton Réinitialiser
		this.btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JTable listeEmployes = PanelParent.getListeEmployesPanel().getListeEmployes();
					if(listeEmployes.getSelectionModel().isSelectionEmpty() || listeEmployes.getSelectedRows().length != 1)
						throw new Exception("Veuillez sélectionner une ligne");
					
					String mdp = (String) listeEmployes.getValueAt(listeEmployes.getSelectedRow(), 2);
					if(mdp.equals("password"))
						throw new Exception("Mot de passe déjà réinitialisé");
					
					String name = (String) listeEmployes.getValueAt(listeEmployes.getSelectedRow(), 0);
					PersonnelManager PersMng = PersonnelManager.getInstance();
					List<Personnel> pers = PersMng.rechercherParNom(name);
					if(pers.size() != 1)
						throw new Exception("Erreur d'accès au données de l'employés");
					
					int res = JOptionPane.showConfirmDialog (null, "Confirmez-vous la réinitialisation du mot de passe ?", "Attention", JOptionPane.YES_NO_OPTION);
					if(res == JOptionPane.YES_OPTION)
					{
						PersMng.ChangerMotDePasse(pers.get(0).getCodeEmp(), "password");
						JOptionPane.showMessageDialog(PanelParent, "Mot de passe réinitialisé", "Succès", JOptionPane.INFORMATION_MESSAGE);
					}
						
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(PanelParent.getFrameParent(), ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
