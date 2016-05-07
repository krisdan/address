/**
 * 
 */
package co.uk.krisdan.address;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public abstract class CityLine implements AddressLine {
	
	protected String city;
	
	protected String getCity() {
		
		return city;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLine()
	 */
	@Override
	public String getLine() {
		
		return this.getCity();
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLineType()
	 */
	@Override
	public String getLineType() {
		
		return "City";
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLength()
	 */
	@Override
	public int length() {
		
		return this.getCity().length();
	}
}
