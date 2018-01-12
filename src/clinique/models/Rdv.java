package clinique.models;

import java.util.Date;

public class Rdv {
	private int codeVeto;
	private Date dateRdv;
	private int codeAnimal;

	public int getCodeVeto() {
		return codeVeto;
	}

	public void setCodeVeto(int codeVeto) throws Exception {
		if (codeVeto == 0)
		{
			throw new Exception("Nom invalide");
		}
		this.codeVeto = codeVeto;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) throws Exception {
		Date dateDuJour = new Date(System.currentTimeMillis());
		if (dateRdv.after(dateDuJour))
		{
			throw new Exception("Date invalide");
		}
		this.dateRdv = dateRdv;
	}

	public int getCodeAnimal() {
		return codeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) throws Exception {
		if (codeAnimal == 0)
		{
			throw new Exception("Code invalide");
		}
		this.codeAnimal = codeAnimal;
	}

	public Rdv(int codeVeto, Date dateRdv, int codeAnimal) throws Exception {
		setCodeVeto(codeVeto);
		setDateRdv(dateRdv);
		setCodeAnimal(codeAnimal);
	}
}