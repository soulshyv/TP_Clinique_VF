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
			for(Personnel p : persoListe)
				if(p.getCodeEmp() == codeEmp)
				{
					p.setMdp(pwd);
					break;
				}
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] changer mot de passe failed - " + e.getMessage());
		}
	}
	
	public void ajouterEmploye(Personnel perso) throws BLLException {
		try {
			daoPerso.insert(perso);
			persoListe.add(perso);
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] ajouter employe failed - " + e.getMessage());
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void supprimerEmploye(int code) throws BLLException {
		try {
			daoPerso.delete(code);
			int i = 0;
			for(Personnel p : persoListe)
			{
				if(p.getCodeEmp() == code)
				{
					persoListe.remove(i);
					break;
				}
				i++;
			}
		} catch (Exception e) {
			throw new BLLException("[Personnel manager] supprimer employe failed - " + e.getMessage());
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public String ConnexionEmploye(String nom, String mdp) throws BLLException {
		List<Personnel> pers = rechercherParNom(nom);
		if(pers.size() < 1)
			throw new BLLException("Nom invalide");
		
		for(Personnel p : pers)
		{
			if(p.getMdp().trim().equals(mdp.trim()))
			{
				return p.getRole();
			}
		}
		
		return null;
	}
}
