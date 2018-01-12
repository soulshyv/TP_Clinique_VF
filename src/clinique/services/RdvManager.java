package clinique.services;

import java.sql.Date;
import java.util.List;

import clinique.dal.DALException;
import clinique.dal.DAOFactory;
import clinique.dal.RdvDAO;
import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Personnel;
import clinique.models.Rdv;

public class RdvManager {
	private List<Rdv> rdvListe;
	
	private static RdvManager instance = null;
	
	private RdvDAO daoRdv;
	
	public List<Rdv> getRdvListe() {
		return rdvListe;
	}

	private RdvManager() throws BLLException
	{
		try {
			daoRdv = DAOFactory.getRdvDAO();
			
			rdvListe = daoRdv.selectAll();
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] instanciating failed - " + e.getMessage());
		}
	}
	
	public static RdvManager getInstance() throws BLLException
	{
		if(instance == null)
			instance = new RdvManager();
		
		return instance;
	}
	
	public void ajouterRdv(Client client, Animal animal, Personnel veto, Date date) throws BLLException
	{
		if(client == null)
			throw new BLLException("[Rdv manager] ajouter rdv failed - no client received");
		if(animal == null)
			throw new BLLException("[Rdv manager] ajouter rdv failed - no animal received");
		if(veto == null)
			throw new BLLException("[Rdv manager] ajouter rdv failed - no veto received");
		if(date == null)
			throw new BLLException("[Rdv manager] ajouter rdv failed - no date received");
		
		try {
			daoRdv.insert(client, animal, veto, date);
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] ajouter rdv failed - " + e.getMessage());
		}
	}
	
	public void supprimerRdvParCodeVeto(int code) throws BLLException
	{
		if(code <= 0)
			throw new BLLException("[Rdv manager] supprimer rdv par code veto failed - code incorrect");
		
		try {
			daoRdv.deleteByCodeVeto(code);
			int i = 0;
			for(Rdv r : rdvListe)
			{
				if(r.getCodeVeto() == code)
				{
					rdvListe.remove(i);
					break;
				}
				i++;
			}
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] supprimer rdv par code veto failed - " + e.getMessage());
		}
	}
	
	public void supprimerRdvParDate(Date date) throws BLLException
	{
		if(date == null)
			throw new BLLException("[Rdv manager] supprimer rdv par code veto failed - date incorrect");
		
		try {
			daoRdv.deleteByDate(date);
			int i =0;
			for(Rdv r : rdvListe)
			{
				if(r.getDateRdv() == date)
				{
					rdvListe.remove(i);
					break;
				}
				i++;
			}
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] supprimer rdv par code veto failed - " + e.getMessage());
		}
	}
	
	public void supprimerRdvParCodeAnimal(int code) throws BLLException
	{
		if(code <= 0)
			throw new BLLException("[Rdv manager] supprimer rdv par code animal failed - code incorrect");
		
		try {
			daoRdv.deleteByCodeAnimal(code);
			int i =0;
			for(Rdv r : rdvListe)
			{
				if(r.getCodeAnimal() == code)
				{
					rdvListe.remove(i);
					break;
				}
				i++;
			}
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] supprimer rdv par code animal failed - " + e.getMessage());
		}
	}
	
	public List<Rdv> rechercherParCodeVeto(int code) throws BLLException
	{
		if(code <= 0)
			throw new BLLException("[Rdv manager] rechercher rdv par code veto failed - code incorrect");
		
		try {
			return daoRdv.selectByCodeVeto(code);
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] rechercher rdv par code veto failed - " + e.getMessage());
		}
	}
	
	public List<Rdv> rechercherParDate(Date date) throws BLLException
	{
		if(date == null)
			throw new BLLException("[Rdv manager] rechercher rdv par date failed - date incorrect");
		
		try {
			return daoRdv.selectByDate(date);
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] rechercher rdv par date failed - " + e.getMessage());
		}
	}
	
	public List<Rdv> rechercherParCodeAnimal(int code) throws BLLException
	{
		if(code <= 0)
			throw new BLLException("[Rdv manager] rechercher rdv par code animal failed - code incorrect");
		
		try {
			return daoRdv.selectByCodeAnimal(code);
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] rechercher rdv par code animal failed - " + e.getMessage());
		}
	}
	
	public List<Rdv> rechercherTousRdvs() throws BLLException
	{
		try {
			return daoRdv.selectAll();
		} catch (DALException e) {
			throw new BLLException("[Rdv manager] rechercher tous rdvs failed - " + e.getMessage());
		}
	}
}
