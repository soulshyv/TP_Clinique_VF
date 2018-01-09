package clinique.models;

import java.util.Date;

public class Rdv {
	private long codeVeto;
	private Date dateRdv;
	private long codeAnimal;

	public long getCodeVeto() {
		return codeVeto;
	}

	public void setCodeVeto(long codeVeto) {
		this.codeVeto = codeVeto;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public long getCodeAnimal() {
		return codeAnimal;
	}

	public void setCodeAnimal(long codeAnimal) {
		this.codeAnimal = codeAnimal;
	}

	public Rdv(long codeVeto, Date dateRdv, long codeAnimal) {
		this.codeVeto = codeVeto;
		this.dateRdv = dateRdv;
		this.codeAnimal = codeAnimal;
	}
}