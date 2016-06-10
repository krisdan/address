/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.PostCodeAPI;
import co.uk.krisdan.postcode.PostCodeAPIInterface;
import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.FrenchPostCodeValidator;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class FrancePostCodeLine extends PostcodeLine {


	/**
	 * Receives a PostCode Object and initialises a FrancePostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws FrNumericPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws FrUnusedPostCodeException
	 * @throws FrTooHighPostCodeException
	 * @throws FrTooLowPostCodeException
	 */
	public FrancePostCodeLine(PostCode postcode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * Receives a String and initialises a FrancePostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws FrNumericPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws FrUnusedPostCodeException
	 * @throws FrTooHighPostCodeException
	 * @throws FrTooLowPostCodeException
	 */
	public FrancePostCodeLine(String postcode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * Receives a String and, if it conforms to the Canadian Postcode format, sets it as the value of the Object property postcode. Returns true if successful false otherwise.
	 * 
	 * @param postcode
	 * 
	 * @return boolean
	 * 
	 * @throws FrNumericPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws FrUnusedPostCodeException
	 * @throws FrTooHighPostCodeException
	 * @throws FrTooLowPostCodeException
	 */
	private boolean setProperty(String postcode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		boolean success = false;
		
		PostCode postCodeObj = null;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			postCodeObj = this.createFrenchPostcode(postcode);
			
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
	 * @throws FrNumericPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws FrUnusedPostCodeException
	 * @throws FrTooHighPostCodeException
	 * @throws FrTooLowPostCodeException
	 */
	private boolean setProperty(PostCode postcode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		boolean success = false;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			this.postcode = postcode;
			
			success = (this.getPostcode().equals(postcode));
		}
		
		return success;	
	}
	
	/**
	 * Receives a String and if it is a valid French Post code returns a PostCode Object otherwise it returns null. 
	 * 
	 * @param code
	 * 
	 * @return PostCode / null
	 * 
	 * @throws FrNumericPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws FrUnusedPostCodeException
	 * @throws FrTooHighPostCodeException
	 * @throws FrTooLowPostCodeException
	 */
	private PostCode createFrenchPostcode(String code) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		PostCode postcode = null;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		postcode = api.getFrenchPostCodeObject(code);
		
		return postcode;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {

		return "France";
	}
	
	/**
	 * Receives a String and returns true if it is a valid French Post code. False if it is not valid.
	 * 
	 * @param line
	 * 
	 * @return boolean
	 * 
	 * @throws FrNumericPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws FrUnusedPostCodeException
	 * @throws FrTooHighPostCodeException
	 * @throws FrTooLowPostCodeException
	 */
	public boolean validate(String line) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		return FrenchPostCodeValidator.validate(line);
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object line) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		PostCode postCode = (PostCode) line;
		
		return this.validate(postCode.getAsString());
	}

}
