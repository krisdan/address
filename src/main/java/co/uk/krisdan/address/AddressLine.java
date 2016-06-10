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
import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;

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
	 * @throws UkTooShortPostCodeException 
	 * @throws UkTooLongPostCodeException 
	 * @throws UkUnusedPostCodeException 
	 * @throws UkAlphaNumericPostCodeException 
	 * @throws UsaTooLowPostCodeException 
	 * @throws UsaTooHighPostCodeException 
	 * @throws UsaUnusedPostCodeException 
	 * @throws UsaTooShortPostCodeException 
	 * @throws UsaTooLongPostCodeException 
	 * @throws UsaForbidenCharactersPostCodeException 
	 * @throws UsaNumericPostCodeException 
	 */
	public boolean validate(Object line) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException;

}
