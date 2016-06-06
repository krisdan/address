/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineInvalidException;
import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class FrancePostCodeLine extends PostcodeLine {

	/**
	 * 
	 */
	public FrancePostCodeLine() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean setProperty(String postcode) {
		
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
	
	private boolean setProperty(PostCode postcode) {
		
		boolean success = false;
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			
			this.postcode = postcode;
		}
		
		return success;		
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object line) {
		// TODO Auto-generated method stub
		return false;
	}

}
