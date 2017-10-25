package au.com.xp.calculator.exception;

public class InvalidOperandException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidOperandException(String message) {
		super(message);
	}

	public InvalidOperandException(String message, Exception e) {
		super(message, e);
	}

}
