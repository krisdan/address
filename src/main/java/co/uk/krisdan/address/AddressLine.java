package co.uk.krisdan.address;

public interface AddressLine {
	
	public String getLine();
	
	public String getLineType();
	
	public String getCountry();
	
	public int length();
	
	public boolean validate(Object line);

}
