package accommodation_finder.models;

public class Services {

	private int serviceid,accommodationid;
	private String ownerid,servicename;
	
	
	
	
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Services(int accommodationid, String ownerid, String servicename) {
		super();
		this.accommodationid = accommodationid;
		this.ownerid = ownerid;
		this.servicename = servicename;
	}
	public Services(int serviceid, int accommodationid, String ownerid, String servicename) {
		super();
		this.serviceid = serviceid;
		this.accommodationid = accommodationid;
		this.ownerid = ownerid;
		this.servicename = servicename;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public int getAccommodationid() {
		return accommodationid;
	}
	public void setAccommodationid(int accommodationid) {
		this.accommodationid = accommodationid;
	}
	public String getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
}
