package clinique.dal;

import java.sql.Date;
import java.util.List;

import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Personnel;
import clinique.models.Rdv;

public interface RdvDAO {
	public void insert(Client client, Animal animal, Personnel personnel,
			Date date) throws DALException;

	public void deleteByCodeVeto(int codeVeto) throws DALException;

	public void deleteByDate(Date date) throws DALException;

	public void deleteByCodeAnimal(int codeAnimal) throws DALException;

	public void delete(Rdv rdv) throws DALException;
	
	public List<Rdv> selectByCodeVeto(int code) throws DALException;
	
	public List<Rdv> selectByDate(Date date) throws DALException;
	
	public List<Rdv> selectByCodeAnimal(int code) throws DALException;
	
	public List<Rdv> selectAll() throws DALException;
}
