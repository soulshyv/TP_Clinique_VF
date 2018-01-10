package clinique.services;

@SuppressWarnings("serial")
public class BLLException extends Exception {

	public BLLException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		
		return "BLL - " + super.getMessage();
	}
}
