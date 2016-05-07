/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.postcode.PostCode;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public abstract class PostcodeLine implements AddressLine {
	
	protected PostCode postcode;

	protected PostCode getPostcode() {
		
		return this.postcode;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLine()
	 */
	@Override
	public String getLine() {
		
		return this.getPostcode().getAsString();
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLineType()
	 */
	@Override
	public String getLineType() {
		
		return "Post Code";
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#length()
	 */
	@Override
	public int length() {
		
		return this.getPostcode().getAsString().length();
	}

}
