package clinique.ihm.connexion;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clinique.dal.jdbc.JdbcTools;

@SuppressWarnings("serial")
public class EcranConnexion  extends JFrame {
	public EcranConnexion() {
		initializeComponents();
	}

	private void initializeComponents() {
		JPanelConnexion connexionPanel = new JPanelConnexion(this);
		
		//On v�rifie la connexion � la base de donn�es
		try {
			JdbcTools.getConnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erreur de connexion � la base de donn�es", "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
		
		this.add(connexionPanel);
		this.setSize(380, 220);
		this.setTitle("Connexion");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
