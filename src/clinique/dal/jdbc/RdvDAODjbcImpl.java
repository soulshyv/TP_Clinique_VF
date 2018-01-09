package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clinique.dal.DALException;
import clinique.dal.RdvDAO;
import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Personnel;
import clinique.models.Rdv;

public class RdvDAODjbcImpl implements RdvDAO {

	private final String sqlInsert = "{CALL ajout_agenda(?,?,?,?,?)}";
	private final String sqlDeleteByCodeVeto = "DELETE FROM Agendas WHERE CodeClient=?";
	private final String sqlDeleteByDate = "DELETE FROM Agendas WHERE DateRdv=?";
	private final String sqlDeleteByCodeAnimal = "DATE FROM Agendas WHERE CodeAnimal=?";
	private final String sqlDelete = "DELETE FROM Agendas WHERE CodeVeto=? AND CodeAnimal=? AND DateRdv=?";
	private final String sqlSelectByCodeVeto = "SELECT * FROM Agendas WHERE CodeVeto=?";
	private final String sqlSelectByDateRdv = "SELECT * FROM DateRdv=?";
	private final String sqlSelectByCodeAnimal = "SELECT * FROM Agendas WHERE CodeAnimal=?";
	private final String sqlSelectAll = "SELECT * FROM Agendas";

	@Override
	public void insert(Client client, Animal animal, Personnel personnel,
			Date date) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			CallableStatement rqt = conn.prepareCall(sqlInsert);
			rqt.setString(1, client.getNom());
			rqt.setString(2, client.getPrenom());
			rqt.setString(3, animal.getNom());
			rqt.setString(4, personnel.getNom());
			rqt.setDate(5, date);

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Rdv] insert failed");
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException("[Rdv] insert failed - ", e);
		}
	}

	@Override
	public void deleteByCodeVeto(int codeVeto) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement rqt = conn.prepareStatement(sqlDeleteByCodeVeto);
			rqt.setInt(1, codeVeto);

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Rdv] delete by code veto failed");
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException("[Rdv] delete by code veto failed - ", e);
		}
	}

	@Override
	public void deleteByDate(Date date) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement rqt = conn.prepareStatement(sqlDeleteByDate);
			rqt.setDate(1, date);

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Rdv] delete by date failed");
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException("[Rdv] delete by date failed - ", e);
		}
	}

	@Override
	public void deleteByCodeAnimal(int codeAnimal) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement rqt = conn
					.prepareStatement(sqlDeleteByCodeAnimal);
			rqt.setInt(1, codeAnimal);

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Rdv] delete by code animal failed");
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException("[Rdv] delete by code animal failed - ", e);
		}
	}

	@Override
	public void delete(Rdv rdv) throws DALException {
		if (rdv == null)
			throw new DALException();

		try (Connection conn = JdbcTools.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement rqt = conn.prepareStatement(sqlDelete);
			rqt.setLong(1, rdv.getCodeVeto());
			rqt.setLong(2, rdv.getCodeAnimal());
			rqt.setDate(3, (Date) rdv.getDateRdv());

			int nbRows = rqt.executeUpdate();
			if (nbRows != 1) {
				conn.rollback();
				throw new DALException("[Rdv] delete failed");
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException("[Rdv] delete failed");
		}
	}

	@Override
	public List<Rdv> selectByCodeVeto(int code) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			List<Rdv> rdvs = new ArrayList<Rdv>();
			PreparedStatement rqt = conn.prepareStatement(sqlSelectByCodeVeto);
			rqt.setInt(1, code);

			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				rdvs.add(new Rdv(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal")));
			}
			return rdvs;
		} catch (Exception e) {
			throw new DALException("[Rdv] select by code veto failed - ", e);
		}
	}

	@Override
	public List<Rdv> selectByDate(Date date) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			List<Rdv> rdvs = new ArrayList<Rdv>();
			PreparedStatement rqt = conn.prepareStatement(sqlSelectByCodeVeto);
			rqt.setDate(1, date);

			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				rdvs.add(new Rdv(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal")));
			}
			return rdvs;
		} catch (Exception e) {
			throw new DALException("[Rdv] select by date failed - ", e);
		}
	}

	@Override
	public List<Rdv> selectByCodeAnimal(int code) throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			List<Rdv> rdvs = new ArrayList<Rdv>();
			PreparedStatement rqt = conn.prepareStatement(sqlSelectByCodeVeto);
			rqt.setInt(1, code);

			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				rdvs.add(new Rdv(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal")));
			}
			return rdvs;
		} catch (Exception e) {
			throw new DALException("[Rdv] select by code animal failed - ", e);
		}
	}

	@Override
	public List<Rdv> selectAll() throws DALException {
		try (Connection conn = JdbcTools.getConnection()) {
			List<Rdv> rdvs = new ArrayList<Rdv>();
			PreparedStatement rqt = conn.prepareStatement(sqlSelectByCodeVeto);

			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				rdvs.add(new Rdv(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal")));
			}
			return rdvs;
		} catch (Exception e) {
			throw new DALException("[Rdv] select all failed - ", e);
		}
	}

}