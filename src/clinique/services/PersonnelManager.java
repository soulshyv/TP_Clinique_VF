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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public List<Personnel> selectByNom(String nom) throws DALException
	{
		return daoPerso.selectByNom(nom);
	}
	
	public void updatePwd(String codeEmp, String pwd) throws DALException
	{
		daoPerso.updatePwd(codeEmp, pwd);
	}
	
	public void addEmp(Personnel perso) throws DALException {
		daoPerso.insert(perso);
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void deleteEmp(int code) throws DALException {
		daoPerso.delete(code);
		//this.setChanged();
		//this.notifyObservers();
	}
}
