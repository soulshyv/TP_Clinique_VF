package clinique.services;

import java.util.List;

import clinique.dal.DALException;
import clinique.dal.DAOFactory;
import clinique.dal.PersonnelDAO;
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
		} catch (DALException e) {
			throw new BLLException("[Personnel manager] instanciating failed - ", e);
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
	
	public List<Personnel> getPerso()
	{
		return persoListe;
	}
	
	public List<Personnel> rechercherParNom(String nom) throws BLLException
	{
		try {
			return daoPerso.selectByNom(nom);
		} catch (DALException e) {
			throw new BLLException("[Personnel manager] instanciating failed - ", e);
		}
	}
	
	public List<Personnel> rechercherTousLesEmployes() throws BLLException
	{
		try {
			return daoPerso.selectAll();
		} catch (DALException e) {
			throw new BLLException("[Personnel manager] rechercher tous les employes failed - ", e);
		}
	}
	
	public void ChangerMotDePasse(int codeEmp, String pwd) throws BLLException
	{
		try {
			daoPerso.updatePwd(codeEmp, pwd);
		} catch (DALException e) {
			throw new BLLException("[Personnel manager] changer mot de passe failed - ", e);
		}
	}
	
	public void ajouterEmploye(Personnel perso) throws BLLException {
		try {
			daoPerso.insert(perso);
		} catch (DALException e) {
			throw new BLLException("[Personnel manager] ajouter employe failed - ", e);
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void supprimerEmploye(int code) throws BLLException {
		try {
			daoPerso.delete(code);
		} catch (DALException e) {
			throw new BLLException("[Personnel manager] supprimer employe failed - ", e);
		}
		//this.setChanged();
		//this.notifyObservers();
	}
}
