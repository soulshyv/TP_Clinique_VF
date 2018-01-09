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
		
		try {
			animalListe = daoAnimal.selectAll();
		} catch (DALException e) {
			throw new BLLException("[Animal manager] instanciating failed - ", e);
		}
	}
	
	public static synchronized AnimalManager getInstance() throws BLLException{	
		if (instance == null){
			instance = new AnimalManager();	
		}
		return instance;
	}
	
	public List<Animal> getAnimaux()
	{
		return animalListe;
	}
	
	public void ajouterAnimal(Animal newAnimal) throws BLLException {
		try {
			daoAnimal.insert(newAnimal);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void supprimerAnimal(int index) throws BLLException {
		try {
			daoAnimal.delete(index);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public List<Animal> rechercherAnimalParCode(int code) throws BLLException
	{
		try {
			return daoAnimal.selectByCode(code);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Animal> rechercherAnimalParRace(String race) throws BLLException
	{
		try {
			return daoAnimal.selectByRace(race);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Animal> rechercherAnimalParClient(int codeClient) throws BLLException
	{
		try {
			return daoAnimal.selectByClient(codeClient);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Animal> rechercherParEspece(String espece) throws BLLException
	{
		try {
			return daoAnimal.selectByEspece(espece);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
