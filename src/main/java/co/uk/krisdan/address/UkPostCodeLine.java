/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.PostCodeAPI;
import co.uk.krisdan.postcode.PostCodeAPIInterface;
import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.UkPostCodeValidator;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class UkPostCodeLine extends PostcodeLine {

	/**
	 * Receives a PostCode Object and initialises a UkPostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws UkAlphaNumericPostCodeException
	 * @throws UkUnusedPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UkTooShortPostCodeException
	 */
	public UkPostCodeLine(PostCode postcode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		this.setProperty(postcode);
	}
	
	
	/**
	 * Receives a String and initialises a UkPostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws UkAlphaNumericPostCodeException
	 * @throws UkUnusedPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UkTooShortPostCodeException
	 */
	public UkPostCodeLine(String postcode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * Receives a String and, if it conforms to the UK Postcode format, sets it as the value of the Object property postcode. Returns true if successful false otherwise.
	 * 
	 * @param postcode
	 * 
	 * @return boolean
	 * 
	 * @throws UkAlphaNumericPostCodeException
	 * @throws UkUnusedPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UkTooShortPostCodeException
	 */
	private boolean setProperty(String postcode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean success = false;
		
		PostCode postCodeObj = null;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			postCodeObj = this.createUkPostcode(postcode);
			
			success = this.setProperty(postCodeObj);
		}
		
		return success;
	}
	
	/**
	 * Receives a PostCode Object and sets it as the value of the Object property postcode. Returns true if successful false otherwise.
	 * 
	 * @param postcode
	 * 
	 * @return boolean
	 * 
	 * @throws UkAlphaNumericPostCodeException
	 * @throws UkUnusedPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UkTooShortPostCodeException
	 */
	private boolean setProperty(PostCode postcode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean success = false;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			this.postcode = postcode;
			
			success = (this.getPostcode().equals(postcode));
		}
		
		return success;		
	}
	
	/**
	 * Receives a String and if it is a valid UK Post code returns a PostCode Object otherwise it returns null. 
	 * 
	 * @param code
	 * 
	 * @return PostCode / null
	 * 
	 * @throws UkAlphaNumericPostCodeException
	 * @throws UkUnusedPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UkTooShortPostCodeException
	 */
	private PostCode createUkPostcode(String code) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		PostCode postcode = null;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		postcode = api.getUkPostCodeObject(code);
		
		return postcode;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {
		
		return "United Kingdom";
	}
	
	/**
	 * Receives a String and returns true if it is a valid UK Post code. False if it is not valid.
	 * 
	 * @param line
	 * 
	 * @return boolean
	 * 
	 * @throws UkAlphaNumericPostCodeException
	 * @throws UkUnusedPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UkTooShortPostCodeException
	 */
	public boolean validate(String line) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		return UkPostCodeValidator.validate(line);
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object line) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		PostCode postCode = (PostCode) line;
		
		return this.validate(postCode.getAsString());
	}

}
