package clinique.services;

import java.util.List;

import clinique.dal.ClientDAO;
import clinique.dal.DAOFactory;
import clinique.models.Client;

public class ClientManager {
	private List<Client> clients;
	
	private static ClientManager instance = null;
	
	private ClientDAO daoClient;
	
	private ClientManager() throws BLLException
	{
		daoClient = DAOFactory.getClientDAO();
		
		try {
			clients = daoClient.selectAll();
		} catch (Exception e) {
			throw new BLLException("Echec du chargement des clients - ", e);
		}
	}
}
