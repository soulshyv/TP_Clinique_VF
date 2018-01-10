package clinique.models;

public class Personnel {
	private int codeEmp;
	private String nom;
	private String mdp;
	private String role;
	private boolean archive;

	public int getCodeEmp() {
		return codeEmp;
	}

	public void setCodeEmp(int codeEmp) throws Exception {
		if (codeEmp == 0)
		{
			throw new Exception("Code invalide");
		}
		this.codeEmp = codeEmp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws Exception {
		if (nom.equals("") || nom.equals(null))
		{
			throw new Exception("Nom invalide");
		}
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) throws Exception {
		if (mdp.equals("") || mdp.equals(null))
		{
			throw new Exception("Mot de passe invalide");
		}
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) throws Exception {
		if (role.equals("") || role.equals(null))
		{
			throw new Exception("Role invalide");
		}
		this.role = role;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public Personnel(int codeEmp, String nom, String mdp, String role,
			boolean archive) throws Exception {
		setCodeEmp(codeEmp);
		setNom(nom);
		setMdp(mdp);
		setRole(role);
		setArchive(archive);
	}

	public Personnel(String nom, String mdp, String role,
			boolean archive) throws Exception {
		setNom(nom);
		setMdp(mdp);
		setRole(role);
		setArchive(archive);
	}
}
