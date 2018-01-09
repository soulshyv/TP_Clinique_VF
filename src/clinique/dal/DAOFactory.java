package clinique.dal;

public class DAOFactory {
	
	public static ClientDAO getClientDAO()
	{
		ClientDAO clientDAO=null;
		try {
			clientDAO=(ClientDAO ) Class.forName("clinique.dal.jdbc.ClientDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clientDAO; 
	}
	
	public static RdvDAO getRdvDAO()
	{
		RdvDAO rdvDAO=null;
		try {
			rdvDAO=(RdvDAO ) Class.forName("clinique.dal.jdbc.RdvDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rdvDAO; 
	}
	
	public static AnimalDAO getAnimalDAO()
	{
		AnimalDAO animalDAO=null;
		try {
			animalDAO=(AnimalDAO ) Class.forName("clinique.dal.jdbc.AnimalDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return animalDAO;
	}
	
	public static PersonnelDAO getPersonnelDAO()
	{
		PersonnelDAO persoDAO  = null;
		try {
			persoDAO=(PersonnelDAO ) Class.forName("clinique.dal.jdbc.PersonnelDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return persoDAO;
	}
}
