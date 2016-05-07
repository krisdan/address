package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineTooLongException;

public class CanadaLocalityLine extends LocalityLine {
		
	private static final int MAX_LENGTH = 200;

	public CanadaLocalityLine(String locality) throws AddressLineTooLongException {
		
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

	@Override
	public String getCountry() {
		
		return "Canada";
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#validate(java.lang.String)
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
