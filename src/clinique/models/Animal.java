package clinique.models;

public class Animal {
	private String nom;
	private String race;
	private int code;
	private String sexe;
	private String couleur;
	private String espece;
	private String tatouage;
	private String antecedent;
	private boolean archive;
	private Client maitre;
	
	public Client getMaitre() {
		return maitre;
	}
	public void setMaitre(Client maitre) {
		this.maitre = maitre;
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
	public String getRace() {
		return race;
	}
	public void setRace(String race) throws Exception {
		if (race.equals("") || race.equals(null))
		{
			throw new Exception("Nom invalide");
		}
		this.race = race;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) throws Exception {
		if (code == 0 )
		{
			throw new Exception("Nom invalide");
		}
		this.code = code;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) throws Exception {
		if (sexe.equals("") || sexe.equals(null))
		{
			throw new Exception("sexe invalide");
		}
		this.sexe = sexe;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) throws Exception {
		if (couleur.equals("") || couleur.equals(null))
		{
			throw new Exception("couleur invalide");
		}
		this.couleur = couleur;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) throws Exception {
		if (sexe.equals("") || sexe.equals(null))
		{
			throw new Exception("sexe invalide");
		}
		this.espece = espece;
	}
	public String getTatouage() {
		return tatouage;
	}
	public void setTatouage(String tatouage) throws Exception {
		if (tatouage.equals("") || tatouage.equals(null))
		{
			throw new Exception("tatouage invalide");
		}
		this.tatouage = tatouage;
	}
	public String getAntecedent() {
		return antecedent;
	}
	public void setAntecedent(String antecedent) throws Exception {
		if (antecedent.equals("") || antecedent.equals(null))
		{
			throw new Exception("sexe invalide");
		}
		this.antecedent = antecedent;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) throws Exception {
		this.archive = archive;
	}
	
	public Animal(String nom, String race, int code, String sexe,
			String couleur, String espece, String tatouage, String antecedent,
			boolean archive) throws Exception {
		setNom(nom);
		setRace(race);
		setCode(code);
		setSexe(sexe);
		setCouleur(couleur);
		setEspece(espece);
		setTatouage(tatouage);
		setAntecedent(antecedent);
		setArchive(archive);
	}
	public Animal(String nom, String race, int code, String sexe,
			String couleur, String espece, String tatouage, String antecedent,
			boolean archive, Client maitre) throws Exception {
		setNom(nom);
		setRace(race);
		setCode(code);
		setSexe(sexe);
		setCouleur(couleur);
		setEspece(espece);
		setTatouage(tatouage);
		setAntecedent(antecedent);
		setArchive(archive);
		this.maitre = maitre;
	}
	
}
