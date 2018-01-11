package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clinique.dal.ClientDAO;
import clinique.dal.DALException;
import clinique.models.Client;

public class ClientDAOJdbcImpl implements ClientDAO {

	private final String sqlInsert = "{CALL ajout_client(?,?,?,?,?,?,?,?,?,?)}";
	private final String sqlDelete = "DELETE FROM clients WHERE CodeClient=?";
	private final String sqlSelectByCode = "SELECT * FROM clients WHERE CodeClient=?";
	private final String sqlSelectByNom = "SELECT * FROM clients WHERE NomClient=?";
	private final String sqlSelectAll = "SELECT * FROM clients WHERE Archive = 0";
	private final String sqlArchive = "{CALL archive_client_animaux (?)}";

	@Override
	public void insert(Client client) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			CallableStatement rqt = conn.prepareCall(sqlInsert);
			rqt.setString(1, client.getNom());
			rqt.setString(2, client.getPrenom());
			rqt.setString(3, client.getAdresse1());
			rqt.setString(4, client.getAdresse2());
			rqt.setString(5, client.getCp());
			rqt.setString(6, client.getVille());
			rqt.setString(7, client.getNumTel());
			rqt.setString(8, client.getAssurance());
			rqt.setString(9, client.getRemarque());
			rqt.setBoolean(10, client.isArchive());

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Client] insert failed");
			} else {
				conn.commit();
			}
		} catch (Exception e) {
			throw new DALException("[Client] insert failed - " + e.getMessage());
		}
	}

	@Override
	public void deleteByCode(int code) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement rqt = conn.prepareStatement(sqlDelete);
			rqt.setInt(1, code);

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Client] delete by code failed");
			} else {
				conn.commit();
			}
		} catch (Exception e) {
			throw new DALException("[Client] delete by code failed - " + e.getMessage());
		}
	}

	@Override
	public Client selectByCode(int code) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {

			PreparedStatement rqt = conn.prepareStatement(sqlSelectByCode);
			rqt.setInt(1, code);

			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				return new Client(rs.getInt("CodeClient"),
						rs.getString("NomClient"),
						rs.getString("PrenomClient"), 
						rs.getString("Adresse1"),
						rs.getString("Adresse2"), 
						rs.getString("CodePostal"),
						rs.getString("Ville"), 
						rs.getString("NumTel"),
						rs.getString("Assurance"), 
						rs.getString("Email"),
						rs.getString("Remarque"), 
						rs.getBoolean("Archive"));
			}
		} catch (Exception e) {
			throw new DALException("[Client] select by code failde - " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Client> selectByNom(String nom) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {

			PreparedStatement rqt = conn.prepareStatement(sqlSelectByNom);
			rqt.setString(1, nom);

			ResultSet rs = rqt.executeQuery();

			List<Client> clients = new ArrayList<Client>();
			while (rs.next()) {
					clients.add(new Client(rs.getInt("CodeClient"), 
							rs.getString("NomClient"), 
							rs.getString("PrenomClient"),
							rs.getString("Adresse1"), 
							rs.getString("Adresse2"), 
							rs.getString("CodePostal"),
							rs.getString("Ville"), 
							rs.getString("NumTel"), 
							rs.getString("Assurance"), 
							rs.getString("Email"),
							rs.getString("Remarque"), 
							rs.getBoolean("Archive")));
			}

			return clients;
		} catch (Exception e) {
			throw new DALException("[Client] select by nom failed - " + e.getMessage());
		}
	}

	@Override
	public List<Client> selectAll() throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {

			PreparedStatement rqt = conn.prepareStatement(sqlSelectAll);


			ResultSet rs = rqt.executeQuery();

			List<Client> clients = new ArrayList<Client>();
			while (rs.next()) {
					clients.add(new Client(rs.getInt("CodeClient"), 
							rs.getString("NomClient"), 
							rs.getString("PrenomClient"),
							rs.getString("Adresse1"), 
							rs.getString("Adresse2"), 
							rs.getString("CodePostal"),
							rs.getString("Ville"), 
							rs.getString("NumTel"), 
							rs.getString("Assurance"), 
							rs.getString("Email"),
							rs.getString("Remarque"), 
							rs.getBoolean("Archive")));
			}

			return clients;
		} catch (Exception e) {
			throw new DALException("[Client] select all failed - " + e.getMessage());
		}
	}
	@Override
	public void ArchiveByCode(int code) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			CallableStatement rqt = conn.prepareCall(sqlArchive);
			rqt.setInt(1, code);
			System.out.println(code);

			int nbRows = rqt.executeUpdate();
			if (nbRows < 0) {
				conn.rollback();
				throw new DALException("[Client] Archive by code failed");
			} else {
				conn.commit();
			}
		} catch (Exception e) {
			throw new DALException("[Client Archive] Archive by code failed - " + e.getMessage());
		}
	}

}
