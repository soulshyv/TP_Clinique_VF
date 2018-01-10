package clinique.ihm.connexion;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clinique.dal.jdbc.JdbcTools;

public class FenetreConnexion extends JFrame {
	public FenetreConnexion() {
		JPanelConnexion connexionPanel = new JPanelConnexion(this);
		
		try {
			JdbcTools.getConnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erreur de connexion à la base de données", "Une erreur est survenue", JOptionPane.ERROR_MESSAGE);
		}
		
		this.add(connexionPanel);
		this.setSize(380, 220);
		this.setTitle("Connexion");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
