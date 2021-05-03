package accommodation_finder.models;

public class Room_Details {
private String ownerid, typeid,  facilities;
	
	private int detailsid,accommodationid,noofrooms;
	private String charges;

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	public Room_Details(String ownerid, String typeid, String facilities, int detailsid, int accommodationid,
			int noofrooms,String charges) {
		super();
		this.ownerid = ownerid;
		this.typeid = typeid;
		this.facilities = facilities;
		this.detailsid = detailsid;
		this.accommodationid = accommodationid;
		this.noofrooms = noofrooms;
		this.charges=charges;
				
	}

	public Room_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public int getDetailsid() {
		return detailsid;
	}

	public void setDetailsid(int detailsid) {
		this.detailsid = detailsid;
	}

	public int getAccommodationid() {
		return accommodationid;
	}

	public void setAccommodationid(int accommodationid) {
		this.accommodationid = accommodationid;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}
	
	
	
	
	
}
