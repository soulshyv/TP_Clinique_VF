package clinique.ihm.ecranClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinique.models.Client;
import clinique.services.BLLException;
import clinique.services.ClientManager;

public class JPanelButton extends JPanel{
	
	public JPanelMenu PanelButton;
	
	public JButton JButtonSuivant,
		JButtonPremier,
		JButtonDernier,
		JButtonPrecedent,
		JButtonAjouter,
		JButtonSupprimer,
		JButtonRechercher;
	
	public JLabel JLabelSuivant,
		JLabelPremier,
		JLabelDernier,
		JLabelPrecedent,
		JLabelAjouter,
		JLabelSupprimer,
		JLabelRechercher,
		JLabelVide,
		JLabelVide2;
	
	public JTextField JRecherche;
	
	public JPanelButton(JPanelMenu parent){
		PanelButton = parent;
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	this.setLayout(new GridBagLayout());
    	
    	JLabelVide = new JLabel();
    	JLabelVide.setPreferredSize(new Dimension(40, 5));
    	JLabelVide2 = new JLabel();
    	JLabelVide2.setPreferredSize(new Dimension(40, 5));
    	
    	JLabelRechercher = new JLabel("Rechercher");
    	JRecherche = new JTextField(15);
    	
    	JLabelPremier = new JLabel("Premier");
    	this.JButtonPremier = new JButton("|<<");
    	
    	JLabelSuivant = new JLabel("Suivant");
    	this.JButtonSuivant = new JButton("<");
    	
    	JLabelPrecedent = new JLabel("Precedent");
    	this.JButtonPrecedent = new JButton(">");
    	
    	JLabelDernier = new JLabel("Dernier");
    	this.JButtonDernier = new JButton(">>|");

    	JLabelAjouter = new JLabel("Ajouter");
    	this.JButtonAjouter = new JButton("+");
    	
    	JLabelSupprimer = new JLabel("Supprimer");
    	this.JButtonSupprimer = new JButton("-");
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	this.add(JLabelPremier, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	this.add(JButtonPremier, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	this.add(JLabelSuivant, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	this.add(JButtonSuivant, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 0;
    	this.add(JLabelPrecedent, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 1;
    	this.add(JButtonPrecedent, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 0;
    	this.add(JLabelDernier, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 1;
    	this.add(JButtonDernier, gbc);
    	
    	gbc.gridx = 4;
    	gbc.gridy = 0;
    	this.add(JLabelVide, gbc);
    	
    	gbc.gridx = 6;
    	gbc.gridy = 0;
    	this.add(JLabelAjouter, gbc);
    	
    	gbc.gridx = 6;
    	gbc.gridy = 1;
    	this.add(JButtonAjouter, gbc);
    	
    	gbc.gridx = 7;
    	gbc.gridy = 0;
    	this.add(JLabelSupprimer, gbc);
    	
    	gbc.gridx = 7;
    	gbc.gridy = 1;
    	this.add(JButtonSupprimer, gbc);
    	
    	gbc.gridx = 8;
    	gbc.gridy = 0;
    	this.add(JLabelVide2, gbc);
    	
    	gbc.gridx = 9;
    	gbc.gridy = 0;
    	this.add(JLabelRechercher, gbc);
    	
    	gbc.gridx = 9;
    	gbc.gridy = 1;
    	this.add(JRecherche, gbc);
    	
    	JButtonAjouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClientManager clientManager = ClientManager.getInstance();
					JPanelTabInsert parent1 = PanelButton.monPanelTabInsert;
					JPanelInsert parent2 = parent1.panelInsert;
					JTextField text = parent2.TextInputNom;
					System.out.println(text.getText());
					clientManager.ajouterClient(new Client( 
							text.getText(), 
							parent2.TextInputPrenom.getText(),
							parent2.TextInputAdresse1.getText(),
							parent2.TextInputAdresse2.getText(),
							parent2.TextInputCodePostal.getText(),
							parent2.TextInputVille.getText(),
							parent2.TextInputTelNum.getText(),
							parent2.TextInputAssurance.getText(),
							parent2.TextInputEmail.getText(),
							parent2.TextInputRemarque.getText()));
					System.out.println(text.getText());
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    		
    	});
	}
}
