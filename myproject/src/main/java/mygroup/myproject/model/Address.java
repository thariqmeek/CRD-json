package mygroup.myproject.model;

public class Address {
	String city;
	String zip;
	public Address() {}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Address(String city, String zip) {
		super();
		this.city = city;
		this.zip = zip;
	}

}
