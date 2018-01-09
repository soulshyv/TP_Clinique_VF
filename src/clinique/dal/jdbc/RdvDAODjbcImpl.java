package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				throw new DALException();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException();
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
				throw new DALException();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException();
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
				throw new DALException();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException();
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
				throw new DALException();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException();
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
				throw new DALException();
			} else {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new DALException();
		}
	}

}