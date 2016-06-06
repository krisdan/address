/**
 * 
 */
package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineInvalidException;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public class UsaCityLine extends CityLine {
	
	private static final int MAX_LENGTH = 150;

	/**
	 * 
	 */
	public UsaCityLine() throws AddressLineInvalidException {
		
		this.setCity(city);
	}


	private void setCity(String city) throws AddressLineInvalidException {
		
		boolean valid = this.validate(city);
		
		if(valid) {
			this.city = city;
		} else {
			throw new AddressLineInvalidException("CityLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
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
	public boolean validate(Object line)  {
		
		boolean isValid = false;
		
		if(line.toString().length() <= MAX_LENGTH && line.toString().length() > 0 ) {
			isValid = true;
		}
		
		return isValid;
	}

}
