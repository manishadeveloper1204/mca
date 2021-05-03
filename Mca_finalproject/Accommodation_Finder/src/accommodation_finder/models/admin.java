package accommodation_finder.models;

public class admin 
{
private  String adminId,adminpass,name,address,email,phone;

public String getAdminId() {
	return adminId;
}

public void setAdminId(String adminId) {
	this.adminId = adminId;
}

public String getAdminpass() {
	return adminpass;
}

public void setAdminpass(String adminpass) {
	this.adminpass = adminpass;
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

public admin() {
	super();
	// TODO Auto-generated constructor stub
}

public admin(String adminId, String adminpass) {
	super();
	this.adminId = adminId;
	this.adminpass = adminpass;
}

public admin(String adminId, String name, String address, String email, String phone) {
	super();
	this.adminId = adminId;
	this.name = name;
	this.address = address;
	this.email = email;
	this.phone = phone;
}





}
