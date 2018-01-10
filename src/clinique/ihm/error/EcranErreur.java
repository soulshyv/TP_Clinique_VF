package clinique.ihm.error;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class EcranErreur extends JDialog {
	
	public EcranErreur(Exception e)
	{
		JLabel errorLabel = new JLabel(e.getMessage());
		JButton btnClose = new JButton("OK");
		
		this.add(errorLabel);
		this.add(btnClose);
		
		this.setTitle("Une erreur est survenue");
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}
	
}
