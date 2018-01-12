package clinique.ihm.ecranClient;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;

import clinique.models.Animal;
import clinique.models.Client;
import clinique.services.AnimalManager;
import clinique.services.BLLException;
import clinique.services.ClientManager;


@SuppressWarnings("serial")
public class JPanelTableau extends JPanel implements Observer{

	public JPanelTabInsert PanelParent;
	
	public JScrollPane ScrollPane;
	
	public JTable listScroller;
	
	
	public JPanelTabInsert getPanelParent() {
		return PanelParent;
	}

	public JPanelTableau(JPanelTabInsert parent){
		PanelParent = parent;
		this.setLayout(new BorderLayout());
		ClientManager clientManager;
		AnimalManager animalManager;
		try {
			clientManager = ClientManager.getInstance();
			animalManager = AnimalManager.getInstance(); 
			List<Animal> animal = animalManager.getAnimaux();
			
			listScroller = new JTable();
			listScroller.getTableHeader().setReorderingAllowed(false);
			ScrollPane = new JScrollPane(listScroller);
			ScrollPane.setPreferredSize(new Dimension(480,240));
			this.add(ScrollPane);
			
			updateTable(animal);
			
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(parent, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void updateTable(List<Animal> animal) {
		String[] columnNames = {"Code postal",
				"Numero ",
                "Nom",
                "Sexe",
                "Couleur",
                "Espece",
                "Tatouage"};
		DefaultTableModel model = new DefaultTableModel(columnNames,0);
		
		
		for (Animal a : animal)
		{
			model.addRow(new Object[] {a.getMaitre().getCp(), 
					a.getCode(),
					a.getNom(),
					a.getSexe(),
					a.getCouleur(),
					a.getEspece(),
					a.getTatouage()});
			
		}
		listScroller.setModel(model);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setLayout(new GridBagLayout());
		AnimalManager animalManager;
		try {
			animalManager = AnimalManager.getInstance(); 
			List<Animal> animal = animalManager.getAnimaux();

			updateTable(animal);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(PanelParent.getPanelParentMenu().getFrameParent(), e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
