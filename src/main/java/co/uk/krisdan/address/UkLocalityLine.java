package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineInvalidException;

public class UkLocalityLine extends LocalityLine {
	
	private static final int MAX_LENGTH = 150;

	public UkLocalityLine() throws AddressLineInvalidException {
		
		this.setLocality(locality);
	}
	
	private void setLocality(String locality) throws AddressLineInvalidException {
		
		boolean valid = this.validate(locality);
		
		if(valid) {
			this.locality = locality;
		} else {
			throw new AddressLineInvalidException("LocalityLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
		}
	}

	@Override
	public String getCountry() {
		
		return "United Kingdom";
	}

	@Override
	public boolean validate(Object line) {
		
		boolean isValid = false;
		
		if(line.toString().length() <= MAX_LENGTH && line.toString().length() > 0 ) {
			isValid = true;
		}
		
		return isValid;
	}

}
