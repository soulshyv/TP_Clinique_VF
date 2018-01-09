package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clinique.dal.PersonnelDAO;
import clinique.models.Animal;
import clinique.models.Personnel;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {
	private final String sqlInsert = "{call ajout_personnel (?,?,?,?,?,?,?,?)}";
	private final String sqlDelete = "DELETE FROM Personnels WHERE CodePers = ?"; 
	private final String sqlSelectAll = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels";
	private final String sqlSelectByNom = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels WHERE Nom = ?";
	private final String sqlUpdatePwd = "UPDATE Personnels SET MotPasse = ? WHERE CodePers = ?;";
	
	/* (non-Javadoc)
	 * @see clinique.dal.jdbc.PersonnelDAO#selectAll()
	 */
	@Override
	public List<Personnel> selectAll() {
		List<Personnel> liste = new ArrayList<Personnel>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectAll);
				ResultSet rs = rqt.executeQuery(sqlSelectAll);){
			
			Personnel perso = null;

			while (rs.next()) {

				perso = new Personnel(rs.getInt("CodePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive"));
				
				liste.add(perso);
			}
		} catch (SQLException e) {
			try {
				throw new Exception("selectAll failed - " , e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		return liste;
	}
	
	/* (non-Javadoc)
	 * @see clinique.dal.jdbc.PersonnelDAO#selectByNom(java.lang.String)
	 */
	@Override
	public List<Personnel> selectByNom(String nom){
		List<Personnel> liste = new ArrayList<Personnel>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByNom);
				ResultSet rs = rqt.executeQuery(sqlSelectByNom);){
			
			Personnel perso = null;
			rqt.setString(1, nom);

			while (rs.next()) {

				perso = new Personnel(rs.getInt("CodePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive"));
				
				liste.add(perso);
			}
		} catch (SQLException e) {
			try {
				throw new Exception("selectAll failed - " , e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		return liste;
	}
	
	/* (non-Javadoc)
	 * @see clinique.dal.jdbc.PersonnelDAO#delete(int)
	 */
	@Override
	public void delete(int code) {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlDelete);){
			
			cnx.setAutoCommit(false);
			rqt.setInt(1, code);
			
			int nbRows = rqt.executeUpdate();
			
			if (nbRows != 1)
			{
				cnx.rollback();
				throw new Exception("echec de la suppression");
			} else {
				cnx.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see clinique.dal.jdbc.PersonnelDAO#insert(clinique.models.Personnel)
	 */
	@Override
	public void insert(Personnel perso) {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlInsert);){
			
			cnx.setAutoCommit(false);
			rqt.setInt(1, perso.getCodeEmp());
			rqt.setString(2, perso.getNom());
			rqt.setString(3, perso.getMdp());
			rqt.setString(4, perso.getRole());
			rqt.setString(5, perso.getRole());
			
			int nbRows = rqt.executeUpdate();
			
			if (nbRows != 1)
			{
				cnx.rollback();
				throw new Exception("echec de l'insertion");
			} else {
				cnx.commit();
			}

		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	/* (non-Javadoc)
	 * @see clinique.dal.jdbc.PersonnelDAO#updatePwd(java.lang.String, java.lang.String)
	 */
	@Override
	public void updatePwd (String CodePers, String pwd){
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlUpdatePwd);){
			
			cnx.setAutoCommit(false);
			rqt.setString(1, pwd);
			rqt.setString(2, CodePers);
			
			int nbRows = rqt.executeUpdate();
			
			if (nbRows != 1)
			{
				cnx.rollback();
				throw new Exception("echec de l'insertion");
			} else {
				cnx.commit();
			}

		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
