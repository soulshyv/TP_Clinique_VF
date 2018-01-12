package clinique.dal;

import java.util.List;

import clinique.models.Animal;;

public interface AnimalDAO {
	
	public void insert (Animal animal) throws DALException;
	
	public void delete (int code) throws DALException;
	
	public void update(Animal animal) throws DALException;
	
	public List<Animal> selectAll() throws DALException;
	
	public List<Animal> selectByRace(String race) throws DALException;
	
	public List<Animal> selectByClient(int codeClient) throws DALException;
	
	public List<Animal> selectByEspece(String espece) throws DALException;
	
	public Animal selectByCode(int codeAnimal) throws DALException;
}
