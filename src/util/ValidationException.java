package util;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -4388154345745407235L;
	
	public ValidationException(String message) {
		super(message);
		System.out.println("A validation exception is created");
		System.out.println(message);
	}

}