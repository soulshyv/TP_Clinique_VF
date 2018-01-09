package clinique.dal;

import java.util.List;

import clinique.models.Animal;;

public interface AnimalDAO {
	
	public void insert (Animal animal);
	
	public void delete (int code);
	
	public List<Animal> selectAll();
	
	public void update();
	
	public List<Animal> selectByRace(String race);
	
	public List<Animal> selectByClient(String codeClient);
	
	public List<Animal> selectByCode(String codeAnimal);
}
