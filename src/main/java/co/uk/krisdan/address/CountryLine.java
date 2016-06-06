package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineInvalidException;

public class CountryLine implements AddressLine {
	
	private static final int MAX_LENGTH = 200;
	
	String country;

	public CountryLine(String country) throws AddressLineInvalidException {
		
		this.setCountry(country);
	}
	

	@Override
	public String getCountry() {
		return country;
	}


	private void setCountry(String country) throws AddressLineInvalidException {
		
		boolean valid = this.validate(country);
		
		if(valid) {
			this.country = country;
		} else {
			throw new AddressLineInvalidException("CountryLine Too Long Error: ", this.getLineType(), "" + MAX_LENGTH);
		}
	}


	@Override
	public String getLine() {
		
		return this.getCountry();
	}

	@Override
	public String getLineType() {
		
		return "Country";
	}

	@Override
	public int length() {
		
		return this.getCountry().length();
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
