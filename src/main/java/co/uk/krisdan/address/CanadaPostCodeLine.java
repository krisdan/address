/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineTooLongException;
import co.uk.krisdan.postcode.PostCode;
import co.uk.krisdan.postcode.PostCodeAPI;
import co.uk.krisdan.postcode.PostCodeAPIInterface;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class CanadaPostCodeLine extends PostcodeLine {

	/**
	 * 
	 */
	public CanadaPostcodeLine(PostCode postcode) throws AddressLineTooLongException {
		
		this.setProperty(postcode);
	}
	
	/**
	 * 
	 */
	public CanadaPostcodeLine(String postcode) throws AddressLineTooLongException {
		
		this.setProperty(this.createCandianPostcode(postcode));
	}
	
	private void setProperty(PostCode postcode) throws AddressLineTooLongException {
		
		boolean valid = this.validate(postcode);
		
		if(valid) {
			this.postcode = postcode;
		} else {
			throw new AddressLineTooLongException("StreetLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
		}
	}
	
	private PostCode createCandianPostcode(String code) {
		
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
