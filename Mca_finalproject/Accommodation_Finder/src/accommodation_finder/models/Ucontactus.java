package accommodation_finder.models;

import java.sql.Date;

public class Ucontactus 
{

	private String name,email,phone,yourquery;
	private Date date;
	int contactid;
	public Ucontactus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ucontactus(String name, String email, String phone, String yourquery, Date date, int contactid) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.yourquery = yourquery;
		this.date = date;
		this.contactid = contactid;
	}
	public Ucontactus(String name, String email, String phone, String yourquery, Date date) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.yourquery = yourquery;
		this.date = date;
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
	public String getYourquery() {
		return yourquery;
	}
	public void setYourquery(String yourquery) {
		this.yourquery = yourquery;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	
	
	
}
