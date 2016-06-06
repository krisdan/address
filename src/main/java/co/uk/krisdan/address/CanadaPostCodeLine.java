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
public class CanadaPostCodeLine extends PostcodeLine {

	/**
	 * @throws CaTooShortPostCodeException 
	 * @throws CaTooLongPostCodeException 
	 * @throws CaUnusedPostCodeException 
	 * @throws CaAlphaNumericPostCodeException 
	 * 
	 */
	public CanadaPostCodeLine(PostCode postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * @throws CaTooShortPostCodeException 
	 * @throws CaTooLongPostCodeException 
	 * @throws CaUnusedPostCodeException 
	 * @throws CaAlphaNumericPostCodeException 
	 * 
	 */
	public CanadaPostCodeLine(String postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		this.setProperty(postcode);
	}
	
	private boolean setProperty(String postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean success = false;
		
		PostCode postCodeObj = null;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			postCodeObj = this.createCandianPostcode(postcode);
			
			this.postcode = postCodeObj;
			
			success = (this.getPostcode().equals(postCodeObj));
		}
		
		return success;
	}
	
	private boolean setProperty(PostCode postcode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean success = false;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			this.postcode = postcode;
		}
		
		return success;		
	}
	
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
