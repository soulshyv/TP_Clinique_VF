package clinique.ihm.gestionPersonnel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clinique.models.Personnel;
import clinique.services.BLLException;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPaneTabEmployes extends JPanel implements Observer {
	private JPanelGestionPersonnel PanelParent;
	private JTable ListScroller;
	private JScrollPane ScrollPane;
	
	public JPanelGestionPersonnel getParent() {
		return PanelParent;
	}

	public JTable getListeEmployes() {
		return ListScroller;
	}

	public JPaneTabEmployes(JPanelGestionPersonnel parent) {
		PanelParent = parent;
		
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
			
			ListScroller = new JTable(tabDonnees, columnNames);
			ListScroller.getTableHeader().setReorderingAllowed(false);
			ScrollPane = new JScrollPane(ListScroller);
			ScrollPane.setPreferredSize(new Dimension(400, 200));
			this.add(ScrollPane);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(PanelParent, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void updateTable(List<Personnel> pers)
	{
		String[] columnNames = {"Nom ",
                "Role",
                "Mot de passe"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		for(Personnel p : pers)
		{
			model.addRow(new Object[] {
					p.getNom(),
					p.getRole(),
					"********"
			});
		}
		ListScroller.setModel(model);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setLayout(new GridBagLayout());
		try {
			PersonnelManager persMng = PersonnelManager.getInstance();
			List<Personnel> pers = persMng.getPersonnel();
			
			updateTable(pers);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(PanelParent, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
	}
}
