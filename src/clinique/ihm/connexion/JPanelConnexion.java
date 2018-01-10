package clinique.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelConnexion extends JPanel {
	
	public JTextField TextInputConnexion;
	
	public JPasswordField TextInputMotDePasse;
	
	public JButton JButtonValider;
	
	
	public JPanelConnexion(){
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.insets = new Insets(5, 5, 5, 5);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	
    	this.setLayout(new GridBagLayout());
    	
    	JLabel textLabelConnexion = new JLabel("Nom");
    	this.TextInputConnexion = new JTextField();
    	TextInputConnexion.setColumns(15);
    	
    	JLabel textLabelMotDePasse = new JLabel("Mot de passe");
    	this.TextInputMotDePasse = new JPasswordField(15);
    	TextInputMotDePasse.setColumns(15);
    	
    	this.JButtonValider = new JButton("Valider");
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	this.add(textLabelConnexion, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	this.add(TextInputConnexion, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	this.add(textLabelMotDePasse, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	this.add(TextInputMotDePasse, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 2;
    	this.add(JButtonValider, gbc);
    	
    	JButtonValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
    	
	}
}
