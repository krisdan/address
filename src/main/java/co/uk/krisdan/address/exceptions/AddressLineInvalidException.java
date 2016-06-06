/**
 * 
 */
package co.uk.krisdan.address.exceptions;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class AddressLineInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4541971564960165427L;

	private String type;
	
	private String maxLength;

	/**
	 * @param message
	 */
	public AddressLineInvalidException(String message, String type, String maxLength) {
		super(message);
		
		this.setType(type);
		
		this.setMaxLength(maxLength);
	}

	/**
	 * @param cause
	 */
	public AddressLineInvalidException(Throwable cause, String type, String maxLength) {
		super(cause);
		
		this.setType(type);
		
		this.setMaxLength(maxLength);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AddressLineInvalidException(String message, Throwable cause, String type, String maxLength) {
		super(message, cause);
		
		this.setType(type);
		
		this.setMaxLength(maxLength);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AddressLineInvalidException(String message, String type, String maxLength, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
		this.setType(type);
		
		this.setMaxLength(maxLength);
	}
	
	private String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}
	
	private String getMaxLength() {
		return maxLength;
	}

	private void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}
	
	@Override
	public String getLocalizedMessage() {
		
		return this.tooLongMsg();
	}

	protected String tooLongMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "The " + this.getType() + " line is longer than " + this.getMaxLength() + " characters." + newLine;
		message += "Please ensure that it is no longer than " + this.getMaxLength() + " characters Long.";
		
		return message;
	}

}
