package co.uk.krisdan.address;

import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;

public interface AddressLine {
	
	public String getLine();
	
	public String getLineType();
	
	/**
	 * Returns a String representation of the name of the country.
	 * 
	 * @return String
	 */
	public String getCountry();
	
	public int length();
	
	/**
	 * Receives an Object and returns true if it is a valid Canadian Post code. False if it is not valid.
	 * 
	 * @param line
	 * 
	 * @return boolean
	 * 
	 * @throws CaAlphaNumericPostCodeException
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 * @throws FrTooLowPostCodeException 
	 * @throws FrTooHighPostCodeException 
	 * @throws FrUnusedPostCodeException 
	 * @throws FrTooShortPostCodeException 
	 * @throws FrTooLongPostCodeException 
	 * @throws FrNumericPostCodeException 
	 */
	public boolean validate(Object line) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException;

}
