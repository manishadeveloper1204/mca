package accommodation_finder.models;

public class Accommodation_Service {

	private String servicename,name,address,email,phone,accommodationtype,accommodationfor;
	private int accommodationid;
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccommodationtype() {
		return accommodationtype;
	}
	public void setAccommodationtype(String accommodationtype) {
		this.accommodationtype = accommodationtype;
	}
	public String getAccommodationfor() {
		return accommodationfor;
	}
	public void setAccommodationfor(String accommodationfor) {
		this.accommodationfor = accommodationfor;
	}
	public int getAccommodationid() {
		return accommodationid;
	}
	public void setAccommodationid(int accommodationid) {
		this.accommodationid = accommodationid;
	}
	public Accommodation_Service(String servicename, String name, String address, String email, String phone,
			String accommodationtype, String accommodationfor, int accommodationid) {
		super();
		this.servicename = servicename;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.accommodationtype = accommodationtype;
		this.accommodationfor = accommodationfor;
		this.accommodationid = accommodationid;
	}
	public Accommodation_Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
