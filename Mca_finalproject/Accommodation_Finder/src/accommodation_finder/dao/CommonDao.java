package accommodation_finder.dao;
import java.sql.*;
import java.util.ArrayList;

import accommodation_finder.dbList.DbListener;
import accommodation_finder.models.CommonDetails;
import accommodation_finder.models.Users;
import accommodation_finder.models.admin;
public class CommonDao implements DbListener
{
	private Connection con;
	public Users login(String id,String pass)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		Users user=null;
		
		
		
		//String status="invalid";
		con=DbListener.openConnection();
		
		try {
			
			
			String strsql="Select * from users where id=? and password=?"; //? is known as placeholder
			ps = con.prepareStatement(
					strsql); /*->passes to RDMS->parser the query and compile the query->store into buffer->ref is assigned to ps*/
			ps.setString(1, id);
			ps.setString(2, pass);
			System.out.println(ps);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				String city=rs.getString("city");
				
				String usertype=rs.getString("usertype");
				String picname=rs.getString("picname");
				java.sql.Date date=rs.getDate("date");
				user=new Users();
				
				user.setCity(city);
				user.setName(name);
				user.setDate(date);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPicname(picname);
				user.setUsertype(usertype);
				user.setId(id);
				user.setPass(pass);
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		finally {
			
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return user;
	}
	
	ArrayList<CommonDetails>commonlist=new ArrayList<CommonDetails>();
	
	public ArrayList<CommonDetails> searchDetails(String usertype)
	{
		
	//ownerid, propertyid, propertytype, price, location, address, latitude, longitude, description
	//id, password, name, email, phone, city, usertype, date, picname, status	
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		//String status="invalid";
		con=DbListener.openConnection();
		
	try {
		//you need to write only this
		String strsql="select u.id,h.name,h.address,h.phone,h.email,h.landmark,u.picname,"
		+ "h.accommodationfor,h.accommodationtype,h.accommodationid from users u, "
		+ "hostel_pgdetails h where u.id=h.ownerid and u.usertype=?";
		//String strsql=null;
		
		ps=con.prepareStatement(strsql);
		ps.setString(1, usertype);
		rs=ps.executeQuery();

		while(rs.next())//check whether data exists or not
		{
			
				String id=rs.getString("id");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				String landmark=rs.getString("landmark");
				String picname=rs.getString("picname");
				String accommodationfor=rs.getString("accommodationfor");
				String accommodationtype=rs.getString("accommodationtype");
				int accommodationid=rs.getInt("accommodationid");
				
 
				
		CommonDetails cd=new CommonDetails(id,name,address,phone, email,landmark, 
				accommodationfor,accommodationtype, picname, accommodationid);
				commonlist.add(cd);


		
		}
	}
		
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		




	finally {
		
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		DbListener.closeConnection(con);
	}

	return commonlist;
		
		}

		

	public ArrayList<CommonDetails>nearbylist=new ArrayList<CommonDetails>();
   public ArrayList<CommonDetails> nearBySearch(float currentlatitude,float currentlongitude,String usertype)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;

		if(!nearbylist.isEmpty())
			nearbylist.clear();
		//String status="invalid";
		con=DbListener.openConnection();
	try {
		String strsql=null;
		  if(usertype!=null) {
		  
		  strsql="select u.id,h.name,h.address,h.phone,h.email,h.landmark,u.picname,h.accommodationfor,h.accommodationtype,"
		  +
		  "h.accommodationid,11111.111*DEGREES(ACOS(LEAST(1.0, COS(RADIANS(?))* COS(RADIANS(Latitude))* "
		  +
		  "COS(RADIANS(?- longitude))+SIN(RADIANS(?))* SIN(RADIANS(Latitude))))) AS distance_in_km from users u, "
		  +
		  "hostel_pgdetails h where u.id=h.ownerid and u.usertype=?  HAVING distance_in_km <5.0  ORDER BY "
		  + "distance_in_km DESC";
		  
		  System.out.println(usertype); }
		 
		 
		ps=con.prepareStatement(strsql);
		
		  ps.setFloat(1, currentlatitude); ps.setFloat(2, currentlongitude);
		  ps.setFloat(3,currentlatitude);
		 
		ps.setString(4, usertype);
		System.out.println(strsql);
		rs=ps.executeQuery();
        
		while(rs.next())//check whether data exist or not
		{
			    
				String id=rs.getString("id");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				String landmark=rs.getString("landmark");
				String picname=rs.getString("picname");
				String accommodationfor=rs.getString("accommodationfor");
				String accommodationtype=rs.getString("accommodationtype");
				int accommodationid=rs.getInt("accommodationid");
			
 
		CommonDetails cd=new CommonDetails(id,name,address,phone, email,landmark, 
				accommodationfor,accommodationtype, picname, accommodationid);
				nearbylist.add(cd);


		
		}
	}
		
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		




	finally {
		
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		DbListener.closeConnection(con);
	}

	return nearbylist;
		
		}

	
}
