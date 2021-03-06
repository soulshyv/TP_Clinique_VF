package clinique.dal;

public class DAOFactory {
	
	//Retourne une instance de ClientDAO
	public static ClientDAO getClientDAO() throws DALException
	{
		ClientDAO clientDAO=null;
		try {
			clientDAO=(ClientDAO ) Class.forName("clinique.dal.jdbc.ClientDAOJdbcImpl").newInstance();
		} catch (Exception e) {
			throw new DALException("DAL - " + e);
		}
		return clientDAO; 
	}

	//Retourne une instance de RdvDAO
	public static RdvDAO getRdvDAO() throws DALException
	{
		RdvDAO rdvDAO=null;
		try {
			rdvDAO=(RdvDAO ) Class.forName("clinique.dal.jdbc.RdvDAOJdbcImpl").newInstance();
		} catch (Exception e) {
			throw new DALException("DAL - " + e);
		}
		return rdvDAO; 
	}

	//Retourne une instance de AnimalDAO
	public static AnimalDAO getAnimalDAO() throws DALException
	{
		AnimalDAO animalDAO=null;
		try {
			animalDAO=(AnimalDAO ) Class.forName("clinique.dal.jdbc.AnimalDAOJdbcImpl").newInstance();
		} catch (Exception e) {
			throw new DALException("DAL - " + e);
		}
		return animalDAO;
	}

	//Retourne une instance de PersonnelDAO
	public static PersonnelDAO getPersonnelDAO() throws DALException
	{
		PersonnelDAO persoDAO  = null;
		try {
			persoDAO=(PersonnelDAO ) Class.forName("clinique.dal.jdbc.PersonnelDAOJdbcImpl").newInstance();
		} catch (Exception e) {
			throw new DALException("DAL - " + e);
		}
		return persoDAO;
	}
}
