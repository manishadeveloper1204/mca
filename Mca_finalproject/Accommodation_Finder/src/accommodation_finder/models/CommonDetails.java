package accommodation_finder.models;

public class CommonDetails 
{
private String  id,name,address,phone,email,landmark,accommodationfor,accommodationtype,picname;
	private int accommodationid;
	public CommonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommonDetails(String id, String name, String address, String phone, String email, String landmark,
			String accommodationfor, String accommodationtype, String picname, int accommodationid) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.landmark = landmark;
		this.accommodationfor = accommodationfor;
		this.accommodationtype = accommodationtype;
		this.picname = picname;
		this.accommodationid = accommodationid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getAccommodationfor() {
		return accommodationfor;
	}
	public void setAccommodationfor(String accommodationfor) {
		this.accommodationfor = accommodationfor;
	}
	public String getAccommodationtype() {
		return accommodationtype;
	}
	public void setAccommodationtype(String accommodationtype) {
		this.accommodationtype = accommodationtype;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public int getAccommodationid() {
		return accommodationid;
	}
	public void setAccommodationid(int accommodationid) {
		this.accommodationid = accommodationid;
	}
	
	
}
