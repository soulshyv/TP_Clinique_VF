package clinique.ihm.gestionPersonnel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import clinique.ihm.error.EcranErreur;
import clinique.models.Personnel;
import clinique.services.BLLException;
import clinique.services.PersonnelManager;

public class JPanelListeEmployes extends JPanel {
	public JScrollPane ScrollPane;
	
	public JPanelListeEmployes() {
		this.setLayout(new GridBagLayout());
		try {
			PersonnelManager persMng = PersonnelManager.getInstance();
			List<Personnel> personnel = persMng.getPersonnel();
			String[][] tabDonnees = new String[personnel.size()][3];
			
			int i = 0;
			for(Personnel pers : personnel)
			{
				tabDonnees[i][0] = String.valueOf(pers.getNom());
				tabDonnees[i][1] = String.valueOf(pers.getRole());
				tabDonnees[i][1] = String.valueOf(pers.getMdp());
			}
			String[] columnNames = {"Nom ",
	                "Role",
	                "Mot de passe"};
			
			JTable listScroller = new JTable(tabDonnees, columnNames);
			ScrollPane = new JScrollPane(listScroller);
			ScrollPane.setPreferredSize(new Dimension(700, 480));
			this.add(ScrollPane);
		} catch (BLLException e) {
			EcranErreur ecrErr = new EcranErreur(e);
		}
	}
}
