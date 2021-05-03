package accommodation_finder.models;

public class AccommodationDetails 
{
private  String ownerid,name,email,phone,address,landmark,accommodationtype,accommodationfor,description;
private int accommodationid;
private double latitude,longitude;
Services service;

public Services getService() {
	return service;
}

public void setService(Services service) {
	this.service = service;
}

public AccommodationDetails() {
	super();
	// TODO Auto-generated constructor stub
}

public AccommodationDetails(String ownerid, String name, String email, String phone, String address, String landmark,
		String accommodationtype, String accommodationfor,String description, double latitude, double longitude) {
	super();
	this.ownerid = ownerid;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.landmark = landmark;
	this.accommodationtype = accommodationtype;
	this.accommodationfor = accommodationfor;
	this.description=description;
	this.latitude = latitude;
	this.longitude = longitude;
}

public AccommodationDetails(String ownerid, String name, String email, String phone, String address, String landmark,
		String accommodationtype, String accommodationfor,String description, int accommodationid, double latitude, double longitude) {
	super();
	this.ownerid = ownerid;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.landmark = landmark;
	this.accommodationtype = accommodationtype;
	this.accommodationfor = accommodationfor;
	this.description=description;
	this.accommodationid = accommodationid;
	this.latitude = latitude;
	this.longitude = longitude;
}

public String getOwnerid() {
	return ownerid;
}

public void setOwnerid(String ownerid) {
	this.ownerid = ownerid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getLandmark() {
	return landmark;
}

public void setLandmark(String landmark) {
	this.landmark = landmark;
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
public void setDescription(String description) {
	this.description = description;
}

public String getDescription() {
	return description;
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

public double getLatitude() {
	return latitude;
}

public void setLatitude(double latitude) {
	this.latitude = latitude;
}

public double getLongitude() {
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}





}
