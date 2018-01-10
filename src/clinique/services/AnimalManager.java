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
			throw new BLLException("[Animal manager] instanciating failed - " + e.getMessage());
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
			throw new BLLException("[Animal manager] instanciating failed - " + e.getMessage());
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void supprimerAnimal(int index) throws BLLException {
		try {
			daoAnimal.delete(index);
		} catch (DALException e) {
			throw new BLLException("[Animal manager] supprimer animal failed - " + e.getMessage());
		}
		//this.setChanged();
		//this.notifyObservers();
	}
	
	public void changerInfosAnimal(Animal animal) throws BLLException {
		try {
			daoAnimal.update(animal);
		} catch (DALException e) {
			throw new BLLException("[Animal manager] changer infos animal failed - " + e.getMessage());
		}
	}
	
	public List<Animal> rechercherAnimalParCode(int code) throws BLLException
	{
		try {
			return daoAnimal.selectByCode(code);
		} catch (DALException e) {
			throw new BLLException("[Animal manager] rechercher animal par code failed - " + e.getMessage());
		}
	}
	
	public List<Animal> rechercherAnimalParRace(String race) throws BLLException
	{
		try {
			return daoAnimal.selectByRace(race);
		} catch (DALException e) {
			throw new BLLException("[Animal manager] rechercher animal par race failed - " + e.getMessage());
		}
	}
	
	public List<Animal> rechercherAnimalParClient(int codeClient) throws BLLException
	{
		try {
			return daoAnimal.selectByClient(codeClient);
		} catch (DALException e) {
			throw new BLLException("[Animal manager] rechercher animal par client failed - " + e.getMessage());
		}
	}
	
	public List<Animal> rechercherAnimalParEspece(String espece) throws BLLException
	{
		try {
			return daoAnimal.selectByEspece(espece);
		} catch (DALException e) {
			throw new BLLException("[Animal manager] rechercher animal par espece failed - " + e.getMessage());
		}
	}
	
	public List<Animal> rechercherTousLesAnimaux() throws BLLException
	{
		try {
			return daoAnimal.selectAll();
		} catch (DALException e) {
			throw new BLLException("[Animal manager] rechercher tous les animaux failed - " + e.getMessage());
		}
	}
}
