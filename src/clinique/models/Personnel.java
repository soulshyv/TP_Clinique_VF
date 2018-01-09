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

	public void setCodeEmp(int codeEmp) {
		this.codeEmp = codeEmp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public Personnel(int codeEmp, String nom, String mdp, String role,
			boolean archive) {
		this.codeEmp = codeEmp;
		this.nom = nom;
		this.mdp = mdp;
		this.role = role;
		this.archive = archive;
	}
}
