package clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clinique.dal.AnimalDAO;
import clinique.models.Animal;

public class AnimalDAOJdbcImpl implements AnimalDAO {
	
	private final String sqlInsert = "{call ajout_animal (?,?,?,?,?,?,?,?)}";
	private final String sqlDelete = "DELETE FROM Animaux WHERE CodeAnimal = ?"; 
	private final String sqlSelectAll = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux";
	private final String sqlSelectByRace = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE Race = ?";
	private final String sqlSelectByCode = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient = ?";
	private final String sqlSelectByCodeAnimal = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeAnimal = ?";

	@Override
	public void insert(Animal animal) {
		try (Connection cnx = JdbcTools.getConnection();
				CallableStatement rqt = cnx.prepareCall(sqlInsert);){
			
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
				throw new Exception("echec de l'insertion");
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

	@Override
	public List<Animal> selectAll() {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectAll);){
			
			ResultSet rs = rqt.executeQuery(sqlSelectAll);
			Animal animal = null;

			while (rs.next()) {

				animal = new Animal(rs.getString("NomAnimal"),
						rs.getString("Race"),
						rs.getInt("CodeAnimal"),
						rs.getString("Sexe"),
						rs.getString("Couleur"),
						rs.getString("Espece"),
						rs.getString("Tatouage"),
						rs.getString("Antecedents"), false, null);
				
				liste.add(animal);
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

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Animal> selectByRace(String race) {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByRace);){
			
			rqt.setString(1, race);
			ResultSet rs = rqt.executeQuery(sqlSelectByRace);
			Animal animal = null;

			while (rs.next()) {

				animal = new Animal(rs.getString("idArticle"),
						rs.getString("marque"),
						rs.getInt("designation"),
						rs.getString("prixUnitaire"),
						rs.getString("qteStock"),
						rs.getString("couleur"),
						rs.getString(""),
						rs.getString(""), false, null);
				
				liste.add(animal);
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

	@Override
	public List<Animal> selectByClient(String codeClient) {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByCode);){
			
			rqt.setString(1, codeClient);
			ResultSet rs = rqt.executeQuery(sqlSelectByCode);
			Animal animal = null;

			while (rs.next()) {

				animal = new Animal(rs.getString("idArticle"),
						rs.getString("marque"),
						rs.getInt("designation"),
						rs.getString("prixUnitaire"),
						rs.getString("qteStock"),
						rs.getString("couleur"),
						rs.getString(""),
						rs.getString(""), false, null);
				
				liste.add(animal);
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

	@Override
	public List<Animal> selectByCode(String codeAnimal) {
		List<Animal> liste = new ArrayList<Animal>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByCodeAnimal);){
			
			rqt.setString(1, codeAnimal);
			ResultSet rs = rqt.executeQuery(sqlSelectByCodeAnimal);
			Animal animal = null;

			while (rs.next()) {

				animal = new Animal(rs.getString("idArticle"),
						rs.getString("marque"),
						rs.getInt("designation"),
						rs.getString("prixUnitaire"),
						rs.getString("qteStock"),
						rs.getString("couleur"),
						rs.getString(""),
						rs.getString(""), false, null);
				
				liste.add(animal);
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

}
