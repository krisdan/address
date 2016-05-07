/**
 * 
 */
package co.uk.krisdan.address;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 *
 */
public abstract class PropertyLine implements AddressLine {
	
	protected String property;

	protected String getProperty() {
		
		return property;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLine()
	 */
	@Override
	public String getLine() {
		
		return this.getProperty();
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLineType()
	 */
	@Override
	public String getLineType() {
		
		return "Property";
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLength()
	 */
	@Override
	public int length() {
		
		return this.getProperty().length();
	}

}
