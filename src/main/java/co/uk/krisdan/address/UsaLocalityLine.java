/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineTooLongException;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class UsaLocalityLine extends LocalityLine {
	
	private static final int MAX_LENGTH = 200;

	/**
	 * 
	 */
	public UsaLocalityLine() throws AddressLineTooLongException {
		
		this.setCity(locality);
	}
	
	private void setCity(String locality) throws AddressLineTooLongException {
		
		boolean valid = this.validate(locality);
		
		if(valid) {
			this.locality = locality;
		} else {
			throw new AddressLineTooLongException("LocalityLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
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
		
		if( line.toString().length() <= MAX_LENGTH && line.toString().length() > 0 ) {
			isValid = true;
		}
		
		return isValid;
	}

}
