/**
 * 
 */
package co.uk.krisdan.address;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public abstract class StreetLine implements AddressLine {
	
	protected String street;

	protected String getStreet() {
		
		return street;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLine()
	 */
	@Override
	public String getLine() {
		
		return this.getStreet();
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLineType()
	 */
	@Override
	public String getLineType() {
		
		return "Street";
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLength()
	 */
	@Override
	public int length() {
		
		return this.getStreet().length();
	}

}
