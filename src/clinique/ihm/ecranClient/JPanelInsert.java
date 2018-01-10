package clinique.ihm.ecranClient;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelInsert extends JPanel {
	
	public JFrame Parent;
	
	public JTextField TextInputCode, 
		TextInputNom, 
		TextInputPrenom, 
		TextInputAdresse1, 
		TextInputAdresse2, 
		TextInputCodePostal, 
		TextInputVille;
	
	public JButton JButtonValider, 
		JButtonSupprimer, 
		JButtonEditer;
	
	public JPanelInsert(JFrame parent){
		Parent = parent;
		
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	
    	this.setLayout(new GridBagLayout());
    	
    	JLabel textLabelCode = new JLabel("Code");
    	this.TextInputCode = new JTextField();
    	TextInputCode.setColumns(15);
    	
    	JLabel textLabelNom = new JLabel("Nom");
    	this.TextInputNom = new JPasswordField(15);
    	TextInputNom.setColumns(15);
    	
    	JLabel textLabelPrenom = new JLabel("Prenom");
    	this.TextInputPrenom = new JPasswordField(15);
    	TextInputPrenom.setColumns(15);
    	
    	JLabel textLabelAdresse = new JLabel("Adresse");
    	this.TextInputAdresse1 = new JPasswordField(15);
    	TextInputAdresse1.setColumns(15);
    	
    	this.TextInputAdresse2 = new JPasswordField(15);
    	TextInputAdresse2.setColumns(15);
    	
    	JLabel textLabelCodePostal = new JLabel("Code postal");
    	this.TextInputCodePostal = new JPasswordField(15);
    	TextInputCodePostal.setColumns(15);
    	
    	JLabel textLabelVille = new JLabel("Ville");
    	this.TextInputVille = new JPasswordField(15);
    	TextInputVille.setColumns(15);
    	
    	this.JButtonValider = new JButton("Valider");
    	this.JButtonSupprimer = new JButton("Supprimer");
    	this.JButtonEditer = new JButton("Editer");
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	this.add(textLabelCode, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	this.add(TextInputCode, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	this.add(textLabelNom, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	this.add(TextInputNom, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 2;
    	this.add(textLabelPrenom, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 2;
    	this.add(TextInputPrenom, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 3;
    	this.add(textLabelAdresse, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 3;
    	this.add(TextInputAdresse1, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 4;
    	this.add(TextInputAdresse2, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 5;
    	this.add(textLabelCodePostal, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 5;
    	this.add(TextInputCodePostal, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 6;
    	this.add(textLabelVille, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 6;
    	this.add(TextInputVille, gbc);
	}
}
