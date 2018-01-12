package clinique.ihm.rdv;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Rdv;
import clinique.services.AnimalManager;
import clinique.services.BLLException;
import clinique.services.ClientManager;
import clinique.services.RdvManager;

@SuppressWarnings("serial")
public class JPanelTabRdv extends JPanel {
	private JPanelRdv PanelParent;

	private JTable ListScroller;
	private JScrollPane ScrollPane;
	
	public JPanelTabRdv(JPanelRdv parent)
	{
		PanelParent = parent;
		
		initializeComponents();
	}
	
	private void initializeComponents() {
		this.setLayout(new GridBagLayout());
		try {
			RdvManager rdvMng = RdvManager.getInstance();
			ClientManager cliMng = ClientManager.getInstance();
			AnimalManager aniMng = AnimalManager.getInstance();
			
			List<Rdv> rdvs = rdvMng.getRdvListe();
			String[][] tabDonnees = new String[rdvs.size()][4];
			int i = 0;
			for(Rdv r : rdvs)
			{
				Client c = cliMng.rechercherClientParCode(r.getCodeVeto());
				Animal a = aniMng.rechercherAnimalParCode(r.getCodeAnimal());
				SimpleDateFormat sdf = new SimpleDateFormat("HHhmm");
				
				tabDonnees[i][0] = String.valueOf(sdf.format(r.getDateRdv()));
				tabDonnees[i][1] = String.valueOf(c.getNom() + " " + c.getPrenom());
				tabDonnees[i][2] = String.valueOf(a.getNom());
				tabDonnees[i][2] = String.valueOf(a.getRace());
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
}
