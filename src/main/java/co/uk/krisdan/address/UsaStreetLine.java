/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineInvalidException;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class UsaStreetLine extends StreetLine {
	
	private static final int MAX_LENGTH = 250;

	/**
	 * 
	 */
	public UsaStreetLine(String street) throws AddressLineInvalidException {
		
		this.setProperty(street);
	}
	
	private void setProperty(String street) throws AddressLineInvalidException {
		
		boolean valid = this.validate(street);
		
		if(valid) {
			this.street = street;
		} else {
			throw new AddressLineInvalidException("StreetLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
		}
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {
		
		return "United States of America";
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object line) {
		
		boolean isValid = false;
		
		if(line.toString().length() <= MAX_LENGTH && line.toString().length() > 0 ) {
			isValid = true;
		}
		
		return isValid;
	}

}
