package clinique.dal;

import java.util.List;

import clinique.models.Client;

public interface ClientDAO {
	public void insert(Client client) throws DALException;

	public void deleteByCode(int code) throws DALException;

	public Client selectByCode(int code) throws DALException;

	public List<Client> selectByNom(String nom) throws DALException;

	public List<Client> selectAll() throws DALException;

	public void ArchiveByCode(int code) throws DALException;
}
