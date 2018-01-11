package clinique.ihm.rdv;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clinique.models.Client;
import clinique.services.BLLException;
import clinique.services.ClientManager;

@SuppressWarnings("serial")
public class JPanelFormAnimalClient extends JPanel {
	private JPanelForm PanelParent;
	
	private JComboBox<String> ComboBoxInputName;
	
	public JPanelFormAnimalClient(JPanelForm parent)
	{
		PanelParent = parent;
		
		try {
			List<String> clients = null;
			
			ClientManager CliMng = ClientManager.getInstance();
			for(Client c : CliMng.getClient())
			{
				clients.add(c.getNom() + " " + c.getPrenom());
			}
			
			ComboBoxInputName = new JComboBox<String>((String[])clients.toArray());
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(PanelParent.getPanelParent().getFrameParent(), e.getMessage(), "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
	}
}
