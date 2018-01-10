package clinique.ihm.gestionPersonnel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clinique.models.Personnel;
import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelListeEmployes extends JPanel {
	JFrame Parent;
	public JScrollPane ScrollPane;
	
	public JPanelListeEmployes(JFrame parent) {
		Parent = parent;
		
		initializeComponents();
	}

	private void initializeComponents() {
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
				tabDonnees[i][2] = String.valueOf("********");
				i++;
			}
			String[] columnNames = {"Nom ",
	                "Role",
	                "Mot de passe"};
			
			JTable listScroller = new JTable(tabDonnees, columnNames);
			listScroller.getTableHeader().setReorderingAllowed(false);
			ScrollPane = new JScrollPane(listScroller);
			ScrollPane.setPreferredSize(new Dimension(400, 200));
			this.add(ScrollPane);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(Parent, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
	}
}
