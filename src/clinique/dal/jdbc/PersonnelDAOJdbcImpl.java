package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clinique.dal.DALException;
import clinique.dal.PersonnelDAO;
import clinique.models.Personnel;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {
	private final String sqlInsert = "{call ajout_personnel (?,?,?,?)}";
	private final String sqlDelete = "DELETE FROM Personnels WHERE CodePers = ?"; 
	private final String sqlSelectAll = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels";
	private final String sqlSelectByNom = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels WHERE Nom = ?";
	private final String sqlUpdatePwd = "UPDATE Personnels SET MotPasse = ? WHERE CodePers = ?;";
	
	/* (non-Javadoc)
	 * @see clinique.dal.jdbc.PersonnelDAO#selectAll()
	 */
	@Override
	public List<Personnel> selectAll() throws DALException {
		List<Personnel> liste = new ArrayList<Personnel>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectAll);){
			
			ResultSet rs = rqt.executeQuery();
			
			Personnel perso = null;

			while (rs.next()) {

				perso = new Personnel(rs.getInt("CodePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive"));
				
				liste.add(perso);
			}
		} catch (Exception e) {
			throw new DALException("[Personnel] selectAll failed - " + e.getMessage());
		} 
		return liste;
	}
	
	
	@Override
	public List<Personnel> selectByNom(String nom) throws DALException {
		List<Personnel> liste = new ArrayList<Personnel>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByNom);){
			
			Personnel perso = null;
			rqt.setString(1, nom);
			
			ResultSet rs = rqt.executeQuery();

			while (rs.next()) {

				perso = new Personnel(rs.getInt("CodePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive"));
				
				liste.add(perso);
			}
		} catch (Exception e) {
			throw new DALException("[Personnel] select by nom failed - " + e.getMessage());
		} 
		return liste;
	}
	
	@Override
	public void delete(int code) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlDelete);){
			
			cnx.setAutoCommit(false);
			rqt.setInt(1, code);
			
			int nbRows = rqt.executeUpdate();
			
			if (nbRows != 1)
			{
				cnx.rollback();
				throw new DALException("[Personnel] delete failed");
			} else {
				cnx.commit();
			}
			
		} catch (Exception e) {
			throw new DALException("[Personnel] delete failed - " + e.getMessage());
		}
	}
	
	
	@Override
	public void insert(Personnel perso) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlInsert);){
			
			cnx.setAutoCommit(false);
			rqt.setString(1, perso.getNom());
			rqt.setString(2, perso.getMdp());
			rqt.setBoolean(3, perso.isArchive());
			rqt.setString(4, perso.getRole());
			
			int nbRows = rqt.executeUpdate();
			
			if (nbRows != 1)
			{
				cnx.rollback();
				throw new DALException("[Personnel] insert failed");
			} else {
				cnx.commit();
			}

		} catch (Exception e){
			throw new DALException("[Personnel] insert failed - " + e.getMessage());
		}

	}
	
	
	@Override
	public void updatePwd (int CodePers, String pwd) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlUpdatePwd);){
			
			cnx.setAutoCommit(false);
			rqt.setString(1, pwd);
			rqt.setInt(2, CodePers);
			
			int nbRows = rqt.executeUpdate();
			
			if (nbRows != 1)
			{
				cnx.rollback();
				throw new DALException("[Personnel] update password failed");
			} else {
				cnx.commit();
			}

		} catch (Exception e){
			throw new DALException("[Personnel] update password failed - " + e.getMessage());
		}
	}
}
