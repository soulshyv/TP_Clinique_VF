package clinique.dal;

@SuppressWarnings("serial")
public class DALException extends Exception {
	public DALException() {
		super();
	}
	
	public DALException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "DAL Error - " + super.getMessage();
	}
}
