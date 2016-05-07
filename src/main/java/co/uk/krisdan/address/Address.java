package co.uk.krisdan.address;

import java.util.ArrayList;

import co.uk.krisdan.postcode.PostCode;

public interface Address {
	
	public ArrayList<AddressLine> getLines();
	
	public int getNumLines();
	
	public String getAddressType();
	
	public String getProperty();
	
	public String getStreet();
	
	public String getLocality();
	
	public String getCity();
	
	public String getPostCodeString();
	
	public PostCode getPostCode();
	
	public String getCountry();
	
	public boolean validate();

}
