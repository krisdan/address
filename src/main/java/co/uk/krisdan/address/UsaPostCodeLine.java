/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.PostCodeAPI;
import co.uk.krisdan.postcode.PostCodeAPIInterface;
import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.UsaPostCodeValidator;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class UsaPostCodeLine extends PostcodeLine {

	/**
	 * Receives a PostCode Object and initialises a CanadaPostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws UsaNumericPostCodeException
	 * @throws UsaForbidenCharactersPostCodeException
	 * @throws UsaTooLongPostCodeException
	 * @throws UsaTooShortPostCodeException
	 * @throws UsaUnusedPostCodeException
	 * @throws UsaTooHighPostCodeException
	 * @throws UsaTooLowPostCodeException
	 */
	public UsaPostCodeLine(PostCode postcode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * Receives a String and initialises a CanadaPostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws UsaNumericPostCodeException
	 * @throws UsaForbidenCharactersPostCodeException
	 * @throws UsaTooLongPostCodeException
	 * @throws UsaTooShortPostCodeException
	 * @throws UsaUnusedPostCodeException
	 * @throws UsaTooHighPostCodeException
	 * @throws UsaTooLowPostCodeException
	 */
	public UsaPostCodeLine(String postcode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * Receives a String and, if it conforms to the USA Postcode format, sets it as the value of the Object property postcode. Returns true if successful false otherwise.
	 * 
	 * @param postcode
	 * 
	 * @return boolean
	 * 
	 * @throws UsaNumericPostCodeException
	 * @throws UsaForbidenCharactersPostCodeException
	 * @throws UsaTooLongPostCodeException
	 * @throws UsaTooShortPostCodeException
	 * @throws UsaUnusedPostCodeException
	 * @throws UsaTooHighPostCodeException
	 * @throws UsaTooLowPostCodeException
	 */
	private boolean setProperty(String postcode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		boolean success = false;
		
		PostCode postCodeObj = null;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			postCodeObj = this.createUsaPostcode(postcode);
			
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
	 * @throws UsaNumericPostCodeException
	 * @throws UsaForbidenCharactersPostCodeException
	 * @throws UsaTooLongPostCodeException
	 * @throws UsaTooShortPostCodeException
	 * @throws UsaUnusedPostCodeException
	 * @throws UsaTooHighPostCodeException
	 * @throws UsaTooLowPostCodeException
	 */
	private boolean setProperty(PostCode postcode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		boolean success = false;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			this.postcode = postcode;
			
			success = (this.getPostcode().equals(postcode));
		}
		
		return success;		
	}
	
	/**
	 * Receives a String and if it is a valid USA Post code returns a PostCode Object otherwise it returns null. 
	 * 
	 * @param code
	 * 
	 * @return PostCode / null
	 * 
	 * @throws UsaNumericPostCodeException
	 * @throws UsaForbidenCharactersPostCodeException
	 * @throws UsaTooLongPostCodeException
	 * @throws UsaTooShortPostCodeException
	 * @throws UsaUnusedPostCodeException
	 * @throws UsaTooHighPostCodeException
	 * @throws UsaTooLowPostCodeException
	 */
	private PostCode createUsaPostcode(String code) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		PostCode postcode = null;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		postcode = api.getUsaPostCodeObject(code);
		
		return postcode;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {
		
		return "United States Of America";
	}
	
	/**
	 * Receives a String and returns true if it is a valid USA Post code. False if it is not valid.
	 * 
	 * @param line
	 * 
	 * @return boolean
	 * 
	 * @throws UsaNumericPostCodeException
	 * @throws UsaForbidenCharactersPostCodeException
	 * @throws UsaTooLongPostCodeException
	 * @throws UsaTooShortPostCodeException
	 * @throws UsaUnusedPostCodeException
	 * @throws UsaTooHighPostCodeException
	 * @throws UsaTooLowPostCodeException
	 */
	public boolean validate(String line) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		return UsaPostCodeValidator.validate(line);
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object line) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		PostCode postCode = (PostCode) line;
		
		return this.validate(postCode.getAsString());
	}

}
