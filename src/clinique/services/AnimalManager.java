package clinique.services;

import java.util.List;

import clinique.dal.AnimalDAO;
import clinique.dal.DALException;
import clinique.dal.DAOFactory;
import clinique.models.Animal;

public class AnimalManager {
	
	private List<Animal> animalListe;
	
	private static AnimalManager instance = null;
	
	private AnimalDAO daoAnimal;
	
	private AnimalManager() throws BLLException 
	{
		daoAnimal = DAOFactory.getAnimalDAO();
		
		animalListe = daoAnimal.selectAll();
	}
	
	public static synchronized AnimalManager getInstance() throws BLLException{	
		if (instance == null){
			instance = new AnimalManager();	
		}
		return instance;
	}
	
	public List<Animal> getAnimal()
	{
		return animalListe;
	}
	
	public void addAnimal(Animal newAnimal) throws DALException {
		daoAnimal.insert(newAnimal);
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void removeAnimal(int index) throws DALException {
		daoAnimal.delete(index);
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public List<Animal> selctebyCode(String code) throws DALException
	{
		return daoAnimal.selectByCode(code);
	}
	
	public List<Animal> selctebyRace(String race) throws DALException
	{
		return daoAnimal.selectByRace(race);
	}
	
	public List<Animal> selctebyClient(String codeClient) throws DALException
	{
		return daoAnimal.selectByClient(codeClient);
	}
	
	public List<Animal> selectByEspece(String espece) throws DALException
	{
		return daoAnimal.selectByClient(espece);
	}
}
