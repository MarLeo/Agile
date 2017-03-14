package exceptions;

public class BadAgumentsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadAgumentsException() {}
	
	public BadAgumentsException(final String message) {
		super(message);
	}
	
	public BadAgumentsException(final Throwable cause) {
		super(cause);
	}
	
	public  BadAgumentsException(final String message, final Throwable cause) {
		super(message, cause);
	}
	

}
