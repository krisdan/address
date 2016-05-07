/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineTooLongException;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class UkPropertyLine extends PropertyLine {
	
	private static final int MAX_LENGTH = 100;

	/**
	 * 
	 */
	public UkPropertyLine(String property) throws AddressLineTooLongException {
		
		this.setProperty(property);
	}
	
	private void setProperty(String property) throws AddressLineTooLongException {
		
		boolean valid = this.validate(property);
		
		if(valid) {
			this.property = property;
		} else {
			throw new AddressLineTooLongException("PropertyLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
		}
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getCountry()
	 */
	@Override
	public String getCountry() {
		
		return "UNited Kingdom";
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
