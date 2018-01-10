package clinique.ihm.ecranClient;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clinique.models.Animal;
import clinique.models.Client;
import clinique.services.AnimalManager;
import clinique.services.BLLException;
import clinique.services.ClientManager;


public class JPanelTableau extends JPanel implements Observer{

	public JFrame Parent;
	
	public JScrollPane ScrollPane;
	
	public JPanelTableau(JFrame parent){
		Parent = parent;
		this.setLayout(new GridBagLayout());
		ClientManager clientManager;
		AnimalManager animalManager;
		try {
			clientManager = ClientManager.getInstance();
			animalManager = AnimalManager.getInstance(); 
			List<Animal> animal = animalManager.getAnimaux();
			String[][] tabDonnee = new String[animal.size()][6];
			
			int i = 0;
			for (Animal a : animal)
			{
				tabDonnee[i][0] = String.valueOf(a.getMaitre().getCp());
				tabDonnee[i][1] = String.valueOf(a.getNom());
				tabDonnee[i][2] = String.valueOf(a.getSexe());
				tabDonnee[i][3] = String.valueOf(a.getCouleur());
				tabDonnee[i][4] = String.valueOf(a.getEspece());
				tabDonnee[i][5] = String.valueOf(a.getTatouage());
				i++;
			}
			String[] columnNames = {"Code postal",
					"Numero ",
	                "Nom",
	                "Sexe",
	                "Couleur",
	                "Espece",
	                "Tatouage"};
			JTable listScroller = new JTable(tabDonnee, columnNames);
			listScroller.getTableHeader().setReorderingAllowed(false);
			ScrollPane = new JScrollPane(listScroller);
			ScrollPane.setPreferredSize(new Dimension(700,480));
			this.add(ScrollPane);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(parent, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setLayout(new GridBagLayout());
		ClientManager clientManager;
		AnimalManager animalManager;
		this.remove(ScrollPane);
		try {
			clientManager = ClientManager.getInstance();
			animalManager = AnimalManager.getInstance(); 
			List<Animal> animal = animalManager.getAnimaux();
			String[][] tabDonnee = new String[animal.size()][6];
			
			int i = 0;
			for (Animal a : animal)
			{
				tabDonnee[i][0] = String.valueOf(a.getMaitre().getCp());
				tabDonnee[i][1] = String.valueOf(a.getNom());
				tabDonnee[i][2] = String.valueOf(a.getSexe());
				tabDonnee[i][3] = String.valueOf(a.getCouleur());
				tabDonnee[i][4] = String.valueOf(a.getEspece());
				tabDonnee[i][5] = String.valueOf(a.getTatouage());
				i++;
			}
			String[] columnNames = {"Code postal",
					"Numero ",
	                "Nom",
	                "Sexe",
	                "Couleur",
	                "Espece",
	                "Tatouage"};
			JTable listScroller = new JTable(tabDonnee, columnNames);
			listScroller.getTableHeader().setReorderingAllowed(false);
			ScrollPane = new JScrollPane(listScroller);
			ScrollPane.setPreferredSize(new Dimension(700,480));
			this.add(ScrollPane);
			this.revalidate();
			this.repaint();
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(Parent, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
