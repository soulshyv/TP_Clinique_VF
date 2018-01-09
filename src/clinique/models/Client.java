package clinique.models;

public class Client {
	private int code;
	private String nom;
	private String prenom;
	private String adresse1;
	private String adresse2;
	private String cp;
	private String ville;
	private String numTel;
	private String assurance;
	private String email;
	private String remarque;
	private boolean archive;

	public int getCode() {
		return code;
	}

	public void setCode(int code) throws Exception {
		if (code == 0)
		{
			throw new Exception("Code invalide");
		}
		this.code = code;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws Exception {
		if (prenom.equals("") || prenom.equals(null))
		{
			throw new Exception("prenom invalide");
		}
		this.prenom = prenom;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) throws Exception {
		if (adresse1.equals("") || adresse1.equals(null))
		{
			throw new Exception("Adresse invalide");
		}
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) throws Exception {
		if (adresse2.equals("") || adresse2.equals(null))
		{
			throw new Exception("Adresse invalide");
		}
		this.adresse2 = adresse2;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) throws Exception {
		if (cp.equals("") || cp.equals(null))
		{
			throw new Exception("Code postal invalide");
		}
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) throws Exception {
		if (ville.equals("") || ville.equals(null))
		{
			throw new Exception("Ville invalide");
		}
		this.ville = ville;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) throws Exception {
		if (numTel.equals("") || numTel.equals(null))
		{
			throw new Exception("Numero téléphone invalide");
		}
		this.numTel = numTel;
	}

	public String getAssurance() {
		return assurance;
	}

	public void setAssurance(String assurance) throws Exception{
		if (assurance.equals("") || assurance.equals(null))
		{
			throw new Exception("Assurance invalide");
		}
		this.assurance = assurance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if (email.equals("") || email.equals(null))
		{
			throw new Exception("Email invalide");
		}
		this.email = email;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) throws Exception {
		if (remarque.equals("") || remarque.equals(null))
		{
			throw new Exception("Nom invalide");
		}
		this.remarque = remarque;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public Client(int code, String nom, String prenom, String adresse1,
			String adresse2, String cp, String ville, String numTel,
			String assurance, String email, String remarque, boolean archive) throws Exception {
		setCode(code);
		setNom(nom);
		setPrenom(prenom);
		setAdresse1(adresse1);
		setAdresse2(adresse2);
		setCp(cp);
		setVille(ville);
		setNumTel(numTel);
		setAssurance(assurance);
		setEmail(email);
		setRemarque(remarque);
		setArchive(archive);
	}
}
