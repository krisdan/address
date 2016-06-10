/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.PostCodeAPI;
import co.uk.krisdan.postcode.PostCodeAPIInterface;
import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.CanadianPostCodeValidator;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class CanadaPostCodeLine extends PostcodeLine {


	/**
	 * Receives a PostCode Object and initialises a CanadaPostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 */
	public CanadaPostCodeLine(PostCode postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		this.setProperty(postcode);
	}
	

	/**
	 * Receives a String and initialises a CanadaPostCodeLine Object.
	 * 
	 * @param postcode
	 * 
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 */
	public CanadaPostCodeLine(String postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * Receives a String and, if it conforms to the Canadian Postcode format, sets it as the value of the Object property postcode. Returns true if successful false otherwise.
	 * 
	 * @param postcode
	 * 
	 * @return boolean
	 * 
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 */
	private boolean setProperty(String postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean success = false;
		
		PostCode postCodeObj = null;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			postCodeObj = this.createCandianPostcode(postcode);
			
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
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 */
	private boolean setProperty(PostCode postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean success = false;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			this.postcode = postcode;
			
			success = (this.getPostcode().equals(postcode));
		}
		
		return success;		
	}
	
	
	/**
	 * Receives a String and if it is a valid Canadian Post code returns a PostCode Object otherwise it returns null. 
	 * 
	 * @param code
	 * 
	 * @return PostCode / null
	 * 
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 */
	private PostCode createCandianPostcode(String code) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		PostCode postcode = null;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		postcode = api.getCanadianPostCodeObject(code);
		
		return postcode;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {
		
		return "Canada";
	}

	/**
	 * Receives a String and returns true if it is a valid Canadian Post code. False if it is not valid.
	 * 
	 * @param line
	 * 
	 * @return boolean
	 * 
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 */
	public boolean validate(String line) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		return CanadianPostCodeValidator.validate(line);
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object line) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		PostCode postCode = (PostCode) line;
		
		return this.validate(postCode.getAsString());
	}

}
