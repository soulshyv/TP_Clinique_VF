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
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public String getTatouage() {
		return tatouage;
	}
	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}
	public String getAntecedent() {
		return antecedent;
	}
	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	
	public Animal(String nom, String race, int code, String sexe,
			String couleur, String espece, String tatouage, String antecedent,
			boolean archive) {
		this.nom = nom;
		this.race = race;
		this.code = code;
		this.sexe = sexe;
		this.couleur = couleur;
		this.espece = espece;
		this.tatouage = tatouage;
		this.antecedent = antecedent;
		this.archive = archive;
	}
	public Animal(String nom, String race, int code, String sexe,
			String couleur, String espece, String tatouage, String antecedent,
			boolean archive, Client maitre) {
		this.nom = nom;
		this.race = race;
		this.code = code;
		this.sexe = sexe;
		this.couleur = couleur;
		this.espece = espece;
		this.tatouage = tatouage;
		this.antecedent = antecedent;
		this.archive = archive;
		this.maitre = maitre;
	}
	
}
