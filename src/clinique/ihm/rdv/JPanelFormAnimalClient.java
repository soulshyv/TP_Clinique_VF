package clinique.ihm.rdv;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Personnel;
import clinique.services.AnimalManager;
import clinique.services.BLLException;
import clinique.services.ClientManager;
import clinique.services.PersonnelManager;

@SuppressWarnings("serial")
public class JPanelFormAnimalClient extends JPanel {
	private JPanelForm PanelParent;
	
	private JComboBox<String> ComboBoxInputEmp;
	private JButton btnAddEmp;
	
	private JComboBox<String> ComboBoxInputAnimal;
	private JButton btnAddAnimal;
	
	public JPanelFormAnimalClient(JPanelForm parent)
	{
		PanelParent = parent;
		
		initializeComponents();
		
		initializeListeners();
	}

	private void initializeComponents() {
		try {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);
			
			this.setLayout(new GridBagLayout());
			
			
			//Label client
			JLabel labelEmp = new JLabel("Client");
			//Combo box des clients
			List<String> clients = new ArrayList<String>();
			ClientManager CliMng = ClientManager.getInstance();
			for(Client c : CliMng.getClient())
			{
				clients.add(c.getNom() + " " + c.getPrenom());
			}
			ComboBoxInputEmp = new JComboBox<String>(clients.toArray(new String[0]));
			//Bouton ajouter client
			btnAddEmp = new JButton("+");
			
			
			//Label animal
			JLabel labelAni = new JLabel("Animal");
			//Combo box des animaux
			List<String> animaux = new ArrayList<String>();
			AnimalManager AniMng = AnimalManager.getInstance();
			for(Animal a : AniMng.rechercherAnimalParClient(CliMng.getClient().get(0).getCode()))
			{
				animaux.add(a.getNom());
			}
			ComboBoxInputAnimal = new JComboBox<String>();
			
			
			//Bouton ajouter animal
			btnAddAnimal = new JButton("+");
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.add(labelEmp);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.add(ComboBoxInputEmp);
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.add(btnAddEmp);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.add(labelAni);
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			this.add(ComboBoxInputAnimal);
			
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.add(btnAddAnimal);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(PanelParent.getPanelParent().getFrameParent(), e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
			PanelParent.getPanelParent().getFrameParent().dispose();
		}
	}

	private void initializeListeners() {
		ComboBoxInputEmp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<String> animaux = new ArrayList<String>();
					
					AnimalManager AniMng = AnimalManager.getInstance();
					ClientManager CliMng = ClientManager.getInstance();
					String name = (String)ComboBoxInputEmp.getItemAt(ComboBoxInputEmp.getSelectedIndex());
					List<Client> c = CliMng.rechercherClientParNom(name);
					if(c.size() == 1)
					{
						for(Animal a : AniMng.rechercherAnimalParClient(c.get(0).getCode()))
						{
							animaux.add(a.getNom());
						}
						DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(animaux.toArray(new String[0]));
						ComboBoxInputAnimal.setModel(model);
					}
				} catch (BLLException ex) {
					JOptionPane.showMessageDialog(PanelParent.getPanelParent().getFrameParent(), ex.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
					PanelParent.getPanelParent().getFrameParent().dispose();
				}
			}
		});
	}
}
