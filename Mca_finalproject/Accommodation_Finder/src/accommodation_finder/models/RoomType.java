package accommodation_finder.models;

public class RoomType {

	private String typeid,typename;

	
	
	
	public RoomType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomType(String typeid, String typename) {
		super();
		this.typeid = typeid;
		this.typename = typename;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
