package clinique.services;

import java.util.List;

import clinique.dal.ClientDAO;
import clinique.dal.DALException;
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
			throw new BLLException("[Client manager] instanciating failed - ", e);
		}
	}
	
	public List<Client> getClient()
	{
		return clients;
	}
	
	public static ClientManager getInstance() throws BLLException
	{
		if(instance == null)
			instance = new ClientManager();
		
		return instance;
	}
	
	public void ajouterClient(Client client) throws BLLException
	{
		if(client == null)
			throw new BLLException("[Client Manager] ajouter client failed - no client received");
		
		try {
			daoClient.insert(client);
		} catch (DALException e) {
			throw new BLLException("[ClientManager] ajouter client failed - ", e);
		}
	}
	
	public void supprimerClientParCode(int code) throws BLLException
	{
		if(code <= 0)
			throw new BLLException("[Client Manager] supprimer client par code failed - code incorrect");
		
		try {
			daoClient.deleteByCode(code);
		} catch (DALException e) {
			throw new BLLException("[ClientManager] supprimer client par code failed - ", e);
		}
	}

	public Client rechercherClientParCode(int code) throws BLLException
	{
		if(code <= 0)
			throw new BLLException("[Client Manager] rechercher client par code failed - code incorrect");
		
		try {
			return daoClient.selectByCode(code);
		} catch (DALException e) {
			throw new BLLException("[ClientManager] rechercher client par code failed - ", e);
		}
	}
	
	public List<Client> rechercherClientParNom(String nom) throws BLLException
	{
		if(nom.trim() == "")
			throw new BLLException("[Client Manager] rechercher client par nom failed - name incorrect");
		
		try {
			return daoClient.selectByNom(nom);
		} catch (DALException e) {
			throw new BLLException("[ClientManager] rechercher client par nom failed - ", e);
		}
	}
	
	public List<Client> RechercherTousClients() throws BLLException
	{
		try {
			return daoClient.selectAll();
		} catch (DALException e) {
			throw new BLLException("[ClientManager] rechercher tous les clients failed - ", e);
		}
	}
}
