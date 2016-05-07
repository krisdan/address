package co.uk.krisdan.address;

public abstract class LocalityLine implements AddressLine {
	
	protected String locality;

	protected String getLocality() {
		
		return locality;
	}

	/* (non-Javadoc)
	 * @see co.uk.krisdan.address.AddressLine#getLine()
	 */
	@Override
	public String getLine() {
		
		return this.getLocality();
	}

	@Override
	public String getLineType() {
		
		return "Locality";
	}

	@Override
	public int length() {
		
		return this.getLocality().length();
	}

}
