package clinique.dal;

import java.sql.Date;

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
}
