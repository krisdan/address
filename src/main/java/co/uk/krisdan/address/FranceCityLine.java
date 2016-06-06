package co.uk.krisdan.address;

import co.uk.krisdan.address.exceptions.AddressLineInvalidException;

public class FranceCityLine extends CityLine {
	
	
	private static final int MAX_LENGTH = 150;

	public FranceCityLine()throws AddressLineInvalidException {
		
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
	
	@Override
	public String getCountry() {
		
		return "France";
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
