package clinique.ihm.ecranClient;

import java.awt.Color;
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
	
	public JPanelTabInsert PanelParent;
	
	public JTextField TextInputTelNum, 
		TextInputNom, 
		TextInputPrenom, 
		TextInputAdresse1, 
		TextInputAdresse2, 
		TextInputCodePostal, 
		TextInputVille,
		TextInputAssurance,
		TextInputEmail,
		TextInputRemarque;
	
	public JButton JButtonValider, 
		JButtonSupprimer, 
		JButtonEditer;
	
	
	
	public JPanelTabInsert getPanelParent() {
		return PanelParent;
	}



	public JPanelInsert(JPanelTabInsert parent){
		PanelParent = parent;
		
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    
    	this.setLayout(new GridBagLayout());
    	
    	JLabel textLabelNumTel = new JLabel("Numero de Tel");
    	this.TextInputTelNum = new JTextField(15);
    	
    	JLabel textLabelNom = new JLabel("Nom");
    	this.TextInputNom = new JTextField(15);
    	
    	JLabel textLabelPrenom = new JLabel("Prenom");
    	this.TextInputPrenom = new JTextField(15);
    	
    	JLabel textLabelAdresse = new JLabel("Adresse");
    	this.TextInputAdresse1 = new JTextField(15);
    	
    	this.TextInputAdresse2 = new JTextField(15);
    	
    	JLabel textLabelCodePostal = new JLabel("Code postal");
    	this.TextInputCodePostal = new JTextField(15);
    	
    	JLabel textLabelVille = new JLabel("Ville");
    	this.TextInputVille = new JTextField(15);
    	
    	JLabel textLabelAssurance = new JLabel("Assurance");
    	this.TextInputAssurance = new JTextField(15);
    	
    	JLabel textLabelEmail = new JLabel("Email");
    	this.TextInputEmail = new JTextField(15);
    	
    	JLabel textLabelRemarque = new JLabel("Remarque");
    	this.TextInputRemarque = new JTextField(15);
    	
    	this.JButtonValider = new JButton("Valider");
    	this.JButtonSupprimer = new JButton("Supprimer");
    	this.JButtonEditer = new JButton("Editer");
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.weightx=0;
    	this.add(textLabelNom, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	gbc.weightx=1;
    	this.add(TextInputNom, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	gbc.weightx=0;
    	this.add(textLabelPrenom, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	gbc.weightx=1;
    	this.add(TextInputPrenom, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 2;
    	gbc.weightx=0;
    	this.add(textLabelAdresse, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 2;
    	gbc.weightx=1;
    	this.add(TextInputAdresse1, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 3;
    	gbc.weightx=1;
    	this.add(TextInputAdresse2, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 4;
    	gbc.weightx=0;
    	this.add(textLabelCodePostal, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 4;
    	gbc.weightx=1;
    	this.add(TextInputCodePostal, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 5;
    	gbc.weightx=0;
    	this.add(textLabelVille, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 5;
    	gbc.weightx=1;
    	this.add(TextInputVille, gbc);
    	

    	gbc.gridx = 0;
    	gbc.gridy = 6;
    	gbc.weightx = 0;
    	this.add(textLabelNumTel, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 6;
    	gbc.weightx=1;
    	this.add(TextInputTelNum, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 7;
    	gbc.weightx = 0;
    	this.add(textLabelAssurance, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 7;
    	gbc.weightx=1;
    	this.add(TextInputAssurance, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 8;
    	gbc.weightx = 0;
    	this.add(textLabelEmail, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 8;
    	gbc.weightx=1;
    	this.add(TextInputEmail, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 9;
    	gbc.weightx = 0;
    	this.add(textLabelRemarque, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 9;
    	gbc.weightx=1;
    	this.add(TextInputRemarque, gbc);
    	
	}
}
