package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clinique.dal.AnimalDAO;
import clinique.dal.DALException;
import clinique.models.Animal;
import clinique.services.ClientManager;

public class AnimalDAOJdbcImpl implements AnimalDAO {

	private final String sqlInsert = "{call ajout_animal (?,?,?,?,?,?,?,?)}";
	private final String sqlDelete = "DELETE FROM Animaux WHERE CodeAnimal = ?";
	private final String sqlSelectAll = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux";
	private final String sqlSelectByRace = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE Race = ?";
	private final String sqlSelectByEspece = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE Espece = ?";
	private final String sqlSelectByCode = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient = ?";
	private final String sqlSelectByCodeAnimal = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeAnimal = ?";
	private final String sqlUpdate = "UPDATE Animal SET NomAnimal=?, Sexe=?, Couleur=?, Race=?, Espece=?, CodeClient=?, Tatouage=?, Antecedents=?, Archive=? WHERE CodeAnimal=?";

	@Override
	public void insert(Animal animal) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlInsert);) {

			cnx.setAutoCommit(false);
			rqt.setString(1, animal.getMaitre().getNom());
			rqt.setString(2, animal.getMaitre().getPrenom());
			rqt.setString(3, animal.getNom());
			rqt.setString(4, animal.getSexe());
			rqt.setString(5, animal.getCouleur());
			rqt.setString(6, animal.getEspece());
			rqt.setString(7, animal.getRace());
			rqt.setBoolean(8, animal.isArchive());

			int nbRows = rqt.executeUpdate();

			if (nbRows != 1) {
				cnx.rollback();
				throw new DALException("[Animal] insert failed");
			} else {
				cnx.commit();
			}

		} catch (Exception e) {
			throw new DALException("[Animal] insert failed - " + e.getMessage());
		}

	}

	@Override
	public void delete(int code) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlDelete);) {

			cnx.setAutoCommit(false);
			rqt.setInt(1, code);

			int nbRows = rqt.executeUpdate();

			if (nbRows != 1) {
				cnx.rollback();
				throw new DALException("[Animal] delete failed");
			} else {
				cnx.commit();
			}

		} catch (Exception e) {
			throw new DALException("[Animal] delete failed - " + e.getMessage());
		}
	}

	@Override
	public List<Animal> selectAll() throws DALException {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectAll);) {

			ResultSet rs = rqt.executeQuery();
			Animal animal = null;

			ClientManager clMngr = ClientManager.getInstance();
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"), rs.getString("Race"),
						rs.getString("Sexe"), rs.getString("Couleur"),
						rs.getString("Espece"), rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("archive"),
						clMngr.rechercherClientParCode(rs
								.getInt("CodeClient")));

				liste.add(animal);
			}
		} catch (Exception e) {
			throw new DALException("[Animal] select all failed - " + e.getMessage());
		}
		
		return liste;
	}

	@Override
	public void update(Animal animal) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlUpdate);) {

			cnx.setAutoCommit(false);
			rqt.setString(1, animal.getNom());
			rqt.setString(2, animal.getSexe());
			rqt.setString(3, animal.getCouleur());
			rqt.setString(4, animal.getRace());
			rqt.setString(5, animal.getEspece());
			rqt.setInt(6, animal.getMaitre().getCode());
			rqt.setString(7, animal.getTatouage());
			rqt.setString(8, animal.getAntecedent());
			rqt.setBoolean(9, animal.isArchive());
			rqt.setInt(1, animal.getCode());

			int nbRows = rqt.executeUpdate();

			if (nbRows != 1) {
				cnx.rollback();
				throw new DALException("[Animal] update failed");
			} else {
				cnx.commit();
			}

		} catch (Exception e) {
			throw new DALException("[Animal] update failed - " + e.getMessage());
		}
	}

	@Override
	public List<Animal> selectByRace(String race) throws DALException {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByRace);) {

			rqt.setString(1, race);
			ResultSet rs = rqt.executeQuery(sqlSelectByRace);
			Animal animal = null;

			ClientManager clMngr = ClientManager.getInstance();
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"), rs.getString("Race"),
						rs.getString("Sexe"), rs.getString("Couleur"),
						rs.getString("Espece"), rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("archive"),
						clMngr.rechercherClientParCode(rs
								.getInt("CodeClient")));

				liste.add(animal);
			}
		} catch (Exception e) {
			throw new DALException("[Animal] select by race failed - " + e.getMessage());
		}
		return liste;
	}

	@Override
	public List<Animal> selectByClient(int codeClient) throws DALException {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByCode);) {

			rqt.setInt(1, codeClient);
			ResultSet rs = rqt.executeQuery(sqlSelectByCode);
			Animal animal = null;

			ClientManager clMngr = ClientManager.getInstance();
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"), rs.getString("Race"),
						rs.getString("Sexe"), rs.getString("Couleur"),
						rs.getString("Espece"), rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("archive"),
						clMngr.rechercherClientParCode(rs
								.getInt("CodeClient")));

				liste.add(animal);
			}
		} catch (Exception e) {
			throw new DALException("[Animal] select by client failed - " + e.getMessage());
		}
		
		return liste;
	}

	public List<Animal> selectByEspece(String espece) throws DALException {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx
						.prepareStatement(sqlSelectByEspece);) {

			rqt.setString(1, espece);
			ResultSet rs = rqt.executeQuery(sqlSelectByEspece);
			Animal animal = null;
			
			ClientManager clMngr = ClientManager.getInstance();
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"), rs.getString("Race"),
						rs.getString("Sexe"), rs.getString("Couleur"),
						rs.getString("Espece"), rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("archive"),
						clMngr.rechercherClientParCode(rs
								.getInt("CodeClient")));

				liste.add(animal);
			}
		} catch (Exception e) {
			throw new DALException("[Animal] select by espece failed - " + e.getMessage());
		}
		
		return liste;
	}

	@Override
	public List<Animal> selectByCode(int codeAnimal) throws DALException {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx
						.prepareStatement(sqlSelectByCodeAnimal);) {

			rqt.setInt(1, codeAnimal);
			ResultSet rs = rqt.executeQuery(sqlSelectByCodeAnimal);
			Animal animal = null;

			ClientManager clMngr = ClientManager.getInstance();
			while (rs.next()) {
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"), rs.getString("Race"),
						rs.getString("Sexe"), rs.getString("Couleur"),
						rs.getString("Espece"), rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("archive"),
						clMngr.rechercherClientParCode(rs
								.getInt("CodeClient")));

				liste.add(animal);
			}
		} catch (Exception e) {
			throw new DALException("[Animal] select by code failed - " + e.getMessage());
		}
		
		return liste;
	}

}
