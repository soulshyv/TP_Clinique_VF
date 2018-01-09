package clinique.dal;

import java.util.List;

import clinique.models.Personnel;

public interface PersonnelDAO {

	public abstract List<Personnel> selectAll();

	public abstract List<Personnel> selectByNom(String nom);

	public abstract void delete(int code);

	public abstract void insert(Personnel perso);

	public abstract void updatePwd(String CodePers, String pwd);

}