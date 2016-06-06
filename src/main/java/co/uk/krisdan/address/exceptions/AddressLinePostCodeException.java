/**
 * 
 */
package co.uk.krisdan.address.exceptions;

import co.uk.krisdan.postcode.PostCodeFormat;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class AddressLinePostCodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3665815535760001967L;
	
	String country;

	/**
	 * @param message
	 */
	public AddressLinePostCodeException(String message, String country) {
		super(message);
		
		this.setCountry(country);
	}

	/**
	 * @param cause
	 */
	public AddressLinePostCodeException(Throwable cause, String message, String country) {
		super(message, cause);
		
		this.setCountry(country);		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AddressLinePostCodeException(String message, Throwable cause, String country) {
		super(message, cause);
		
		this.setCountry(country);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AddressLinePostCodeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, String country) {
		super(message, cause, enableSuppression, writableStackTrace);
		
		this.setCountry(country);
	}
	
	private void setCountry(String country) {
		
		this.country = country;
	}
	
	private String getCountry() {
		
		return this.country;
	}
	
	@Override
	public String getLocalizedMessage() {
		
		return this.invalidPostCodeMsg();
	}
	
	protected String invalidPostCodeMsg() {
		
		String newLine = System.lineSeparator();
		
		String message;
		
		message = "This Post Code line is invalid for " + this.getCountry() + newLine;
		
		message += this.getMessage() + newLine + newLine;
		
		message += "Please ensure that the post code you submit is apropriate for " + this.getCountry() + newLine;
		
		message += "by following the format given below:" + newLine + newLine;
		
		message += PostCodeFormat.getCountryFormatMsg(this.getCountry());
		
		return message;
		
	}

}
