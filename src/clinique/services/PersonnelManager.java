package clinique.services;

import java.util.List;

import javax.swing.JFrame;

import clinique.dal.DAOFactory;
import clinique.dal.PersonnelDAO;
import clinique.ihm.ecranClient.FenetreClient;
import clinique.ihm.gestionPersonnel.EcranGestionPersonnel;
import clinique.models.Personnel;

public class PersonnelManager {
	
	private List<Personnel> persoListe;
	
	private static PersonnelManager instance = null;
	
	private PersonnelDAO daoPerso;
	
	private PersonnelManager() throws BLLException
	{
		daoPerso = DAOFactory.getPersonnelDAO();
		
		try {
			persoListe = daoPerso.selectAll();
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] instanciating failed - " + e.getMessage());
		}
	}
	
	public static synchronized PersonnelManager getInstance() throws BLLException
	{
		if (instance == null)
		{
			instance = new PersonnelManager();
		}
		return instance;
	}
	
	public List<Personnel> getPersonnel()
	{
		return persoListe;
	}
	
	public List<Personnel> rechercherParNom(String nom) throws BLLException
	{
		try {
			return daoPerso.selectByNom(nom);
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] rechercher par nom failed - " + e.getMessage());
		}
	}
	
	public List<Personnel> rechercherTousLesEmployes() throws BLLException
	{
		try {
			return daoPerso.selectAll();
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] rechercher tous les employes failed - " + e.getMessage());
		}
	}
	
	public void ChangerMotDePasse(int codeEmp, String pwd) throws BLLException
	{
		try {
			daoPerso.updatePwd(codeEmp, pwd);
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] changer mot de passe failed - " + e.getMessage());
		}
	}
	
	public void ajouterEmploye(Personnel perso) throws BLLException {
		try {
			daoPerso.insert(perso);
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] ajouter employe failed - " + e.getMessage());
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void supprimerEmploye(int code) throws BLLException {
		try {
			daoPerso.delete(code);
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] supprimer employe failed - " + e.getMessage());
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public JFrame ConnexionEmploye(String nom, String mdp) throws BLLException {
		List<Personnel> pers = rechercherParNom(nom);
		if(pers.size() < 1)
			throw new BLLException("Nom invalide");
		
		for(Personnel p : pers)
		{
			if(p.getMdp().trim().equals(mdp.trim()))
			{
				switch(p.getRole())
				{
					case "sec":
						return new FenetreClient();
						
					case "vet":
						break;
						
					case "adm":
						return new EcranGestionPersonnel();
						
					default:
						throw new BLLException("Vous n'avez pas les permissions requises");
				}
			}
		}
		
		return null;
	}
}
