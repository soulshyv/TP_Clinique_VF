package clinique.ihm.ecranClient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

	public JPanelTabButton PanelParent;
	
	public JScrollPane ScrollPane;
	
	public JTable listScroller;
	
	
	public JPanelTabButton getPanelParent() {
		return PanelParent;
	}

	public JPanelTableau(JPanelTabButton JPanelTabButton){
		PanelParent = JPanelTabButton;
		this.setLayout(new BorderLayout());
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
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
			JOptionPane.showMessageDialog(JPanelTabButton, e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
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
		ClientManager cliManager;
		try {
			animalManager = AnimalManager.getInstance(); 
			cliManager = ClientManager.getInstance();
			List<Client> c = cliManager.rechercherClientParNom(PanelParent.panelParentMenu.panelInsert.TextInputNom.getText());
			int nbClient = c.get(0).getCode();
			List<Animal> animal = (List<Animal>) arg1;

			updateTable(animal);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(PanelParent.getPanelParentMenu().getPanelParentMenu().getFrameParent(), e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
