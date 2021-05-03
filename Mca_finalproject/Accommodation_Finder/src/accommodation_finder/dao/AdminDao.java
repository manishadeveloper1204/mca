package accommodation_finder.dao;

import accommodation_finder.dbList.DbListener;
import accommodation_finder.models.Ucontactus;
import accommodation_finder.models.Users;
import accommodation_finder.models.admin;
import java.sql.*;
import java.util.ArrayList;
public class AdminDao implements DbListener
{
	private Connection con;
	admin admin;
	
	public admin getAdmin() {
		return admin;
	}


	public void setAdmin(admin admin) {
		this.admin = admin;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}

	Users user=null;
	ArrayList<Users>userlist=new ArrayList<Users>();
	
	
	public ArrayList<Users> viewAllUsers()
	{
		con=DbListener.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(!userlist.isEmpty())
		userlist.clear();
		
		
		try {
			String strsql="select * from users";
			ps=con.prepareStatement(strsql);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				String id=rs.getString("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String city=rs.getString("city");
				
				String usertype=rs.getString("usertype");
				user=new Users(id, name, email, city, usertype);
				user.setPhone(phone);
				userlist.add(user);
				
				
				
				
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
	return userlist;
	}
	
	
	public admin login(String id,String pass)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		//String status="invalid";
		con=DbListener.openConnection();
		
		try {
			
			
			String strsql="Select *from admin where adminId=? and adminpass=?"; //? is known as placeholder
			ps = con.prepareStatement(
					strsql); /*->passes to RDMS->parser the query and compile the query->store into buffer->ref is assigned to ps*/
			ps.setString(1, id);
			ps.setString(2, pass);
			System.out.println(ps);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				String adminname=rs.getString("name");
				String adminphone=rs.getString("phone");
				String email=rs.getString("email");
				String address=rs.getString("address");
				
				
				admin=new admin(id,adminname,address,email,adminphone);
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
		
		return admin;
	}
	
	ArrayList<Ucontactus>contactlist=new ArrayList<Ucontactus>();
	//ArrayList<Ucontactus> contactlist;
	 public ArrayList<Ucontactus> viewcontactus() 
	
	{
		con=DbListener.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		  if(!contactlist.isEmpty()) 
			  contactlist.clear();
		 		System.out.println("vishwakarma");
		
		try {
			String strsql="select * from contactus";
			ps=con.prepareStatement(strsql);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				String name=rs.getString("name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String yourquery=rs.getString("yourquery");
				Date date=rs.getDate("date");
				
				Ucontactus u= new  Ucontactus(name,email,phone, yourquery,date);
				
				contactlist.add(u);
				
				
				
				
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
	return contactlist;
	}
	

}
