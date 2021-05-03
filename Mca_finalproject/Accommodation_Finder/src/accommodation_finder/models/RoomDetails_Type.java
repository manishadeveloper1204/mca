package accommodation_finder.models;

public class RoomDetails_Type {
	String name ,  email,phone,charges,facilities,type;
	
	  int noofrooms;

	  
	  
	public RoomDetails_Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDetails_Type(String name, String email, String phone, String charges, String facilities, String type,
			int noofrooms) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.charges = charges;
		this.facilities = facilities;
		this.type = type;
		this.noofrooms = noofrooms;
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

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}
	  
	  
	

}
