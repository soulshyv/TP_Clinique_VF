package clinique.models;

import java.util.Date;

public class Rdv {
	private long codeVeto;
	private Date dateRdv;
	private long codeAnimal;

	public long getCodeVeto() {
		return codeVeto;
	}

	public void setCodeVeto(long codeVeto) throws Exception {
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

	public long getCodeAnimal() {
		return codeAnimal;
	}

	public void setCodeAnimal(long codeAnimal) throws Exception {
		if (codeAnimal == 0)
		{
			throw new Exception("Code invalide");
		}
		this.codeAnimal = codeAnimal;
	}

	public Rdv(long codeVeto, Date dateRdv, long codeAnimal) throws Exception {
		setCodeVeto(codeVeto);
		setDateRdv(dateRdv);
		setCodeAnimal(codeAnimal);
	}
}