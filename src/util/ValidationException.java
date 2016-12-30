package util;

interface Validatable {
	public void validate(Object target) throws Exception;
}

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -4388154345745407235L;
	
	public ValidationException(String message) {
		super(message);
		System.err.println("A validation exception is created");
		System.err.println(message);
	}

}