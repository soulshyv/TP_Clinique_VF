package clinique.dal;

import java.util.List;

import clinique.models.Personnel;

public interface PersonnelDAO {

	public abstract List<Personnel> selectAll() throws DALException;

	public abstract List<Personnel> selectByNom(String nom) throws DALException;

	public abstract void delete(int code) throws DALException;

	public abstract void insert(Personnel perso) throws DALException;

	public abstract void updatePwd(String CodePers, String pwd) throws DALException;

}