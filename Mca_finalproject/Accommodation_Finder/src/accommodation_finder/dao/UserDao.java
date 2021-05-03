package accommodation_finder.dao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import accommodation_finder.dbList.DbListener;
import accommodation_finder.models.AccommodationDetails;
import accommodation_finder.models.Accommodation_Service;
import accommodation_finder.models.FeedBack;
import accommodation_finder.models.Message;
import accommodation_finder.models.Query;
import accommodation_finder.models.RoomDetails_Type;
import accommodation_finder.models.Services;
import accommodation_finder.models.Ucontactus;
import accommodation_finder.models.Users;
import accommodation_finder.users.Contactus;

public class UserDao implements DbListener
{
	Connection con;
	Users user=null;
	Message message;
	ArrayList<Message>usermessage=new ArrayList<Message>();
	Accommodation_Service ad_service;


	public Users getUser() {
		return user;
	}




	public void setUser(Users user) {
		this.user = user;
	}










	public Message getMessage() {
		return message;
	}










	public void setMessage(Message message) {
		this.message = message;
	}










	public ArrayList<Message> getUsermessage() {
		return usermessage;
	}










	public void setUsermessage(ArrayList<Message> usermessage) {
		this.usermessage = usermessage;
	}










	public Accommodation_Service getAd_service() {
		return ad_service;
	}










	public void setAd_service(Accommodation_Service ad_service) {
		this.ad_service = ad_service;
	}










	public Query getQuery() {
		return query;
	}










	public void setQuery(Query query) {
		this.query = query;
	}










	public AccommodationDetails getAd() {
		return ad;
	}










	public void setAd(AccommodationDetails ad) {
		this.ad = ad;
	}










	public RoomDetails_Type getRdt() {
		return rdt;
	}










	public void setRdt(RoomDetails_Type rdt) {
		this.rdt = rdt;
	}










	public Message viewMessage(String messageid)//Query postAnswer(String queryid)
	{
		con=DbListener.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {

			String strsql="select * from message where msgid=?";
			int msg_id=Integer.parseInt(messageid);
			ps=con.prepareStatement(strsql);
			ps.setInt(1, msg_id);
			System.out.println(ps);

			rs=ps.executeQuery();
			if(rs.next())
			{

				String senderid=rs.getString("senderid");
				String Receiverid=rs.getString("receiverid");
				String rstatus=rs.getString("rstatus");
				String sstatus=rs.getString("sstatus");
				String subject=rs.getString("subject");
				Date date=rs.getDate("date");

				//user=new Users(senderid,subject,date)
				message=new Message();
				message.setDate(date);
				message.setSubject(subject);
				message.setSenderid(senderid);
				message.setReceiverid(Receiverid);

				message.setMsgid(rs.getInt("msgid"));
				message.setMessagetext(rs.getString("messagetext"));


			}


		}
		catch(SQLException se)
		{
			se.printStackTrace();


		}

		finally 
		{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			DbListener.closeConnection(con);
		}


		return message;


	}










	public ArrayList<Message> viewInbox(String receiverid)
	{
		con=DbListener.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(!usermessage.isEmpty())
			usermessage.clear();
		try {
			String strsql="select * from message where receiverid=? & rstatus=true";
			ps=con.prepareStatement(strsql);
			ps.setString(1, receiverid);
			System.out.println(ps);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String senderid=rs.getString("senderid");
				String Receiverid=rs.getString("receiverid");
				String rstatus =rs.getString("rstatus");
				String sstatus =rs.getString("sstatus");
				String subject=rs.getString("subject");
				Date date=rs.getDate("date");



				message=new Message();
				message.setDate(date);
				message.setSubject(subject);
				message.setSenderid(senderid);
				message.setReceiverid(receiverid);

				message.setMsgid(rs.getInt("msgid"));
				message.setMessagetext(rs.getString("messagetext"));
				usermessage.add(message);
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

		return usermessage;
	}

	public int registration(Users user)
	{
		int status =0;
		PreparedStatement ps=null;

		con=DbListener.openConnection();
		try {

			String strsql="insert into users(id, password, name, email, phone, city, usertype, date, status)values(?,?,?,?,?,?,?,?,?)";

			ps=con.prepareStatement(strsql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPass());
			ps.setString(3,user.getName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getUsertype());
			ps.setDate(8, user.getDate());
			ps.setString(9, user.getStatus());
			System.out.println(ps);
			status=	ps.executeUpdate(); 

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		finally
		{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbListener.closeConnection(con);
		}


		return status;
	}

	public int editProfile( String email, String phone, String city, String userid) 
	{
		int status=0;
		PreparedStatement ps=null;
		String strupdate="update users set email=?,phone=?,city=? where id=?";
		con=DbListener.openConnection();
		try 
		{
			ps=con.prepareStatement(strupdate);
			ps.setString(1, email);
			ps.setString(2, phone);
			ps.setString(3, city);
			ps.setString(4, userid);
			System.out.println(ps);
			ps.executeUpdate();
			status=ps.executeUpdate();



		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}


		finally
		{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbListener.closeConnection(con);
		}


		return status;
	}




	public int postFeedBack(FeedBack f)
	{
		int status =0;
		PreparedStatement ps=null;

		con=DbListener.openConnection();
		try {

			String strsql="insert into user_feedback(senderid, receiverid, subject, feedbacktext, rating, date)values(?,?,?,?,?,?)";

			ps=con.prepareStatement(strsql);
			ps.setString(1,f.getSenderid());
			ps.setString(2, f.getReceiverid());
			ps.setString(3,f.getSubject());
			ps.setString(4, f.getFeedbacktext());
			ps.setInt(5, f.getRating());
			ps.setDate(6, f.getDate());

			System.out.println(ps);
			status=	ps.executeUpdate(); 

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		return status;
	}


	public int compose(Message m)
	{
		int status =0;
		PreparedStatement ps=null;

		con=DbListener.openConnection();
		try {

			String strsql="insert into message(senderid, receiverid, subject, messagetext, rstatus,sstatus, date)values(?,?,?,?,?,?,?)";

			ps=con.prepareStatement(strsql);
			ps.setString(1,m.getSenderid());
			ps.setString(2, m.getReceiverid());
			ps.setString(3,m.getSubject());
			ps.setString(4, m.getMessagetext());
			ps.setString(5, m.getRstatus());
			ps.setString(6,m.getSstatus());
			ps.setDate(7, m.getDate());

			System.out.println(ps);
			status=	ps.executeUpdate(); 

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return status;

	}



	public int askquery(Query q)
	{
		int status =0;
		PreparedStatement ps=null;

		con=DbListener.openConnection();
		try {

			String strsql="insert into query(senderid, receiverid, question,status,questiondate,answerdate)values(?,?,?,?,?,?)";

			ps=con.prepareStatement(strsql);
			ps.setString(1,q.getSenderid());
			ps.setString(2, q.getReceiverid());
			ps.setString(3,q.getQuestion());
			ps.setString(4,q.getStatus());
			ps.setDate(5, q.getQuestiondate());
			ps.setDate(6, q.getAnswerdate());
			System.out.println(ps);
			status=	ps.executeUpdate(); 

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return status;

	}



	public boolean uploadDocs(InputStream is, File f, String filename) 
	{

		try {
			int size=is.available();//total number of bytes
			byte[]data=new byte[size];

			is.read(data);
			System.out.println(data.length);
			//scott@123/doromon.png
			//FileOutputStream fos=new FileOutputStream(f+"//"+filename);
			//		swasti@123\abc.jpg
			FileOutputStream fos=new FileOutputStream(f+File.separator+filename);

			fos.write(data);//image is geeting  written in the file with this code
			fos.close();
			System.out.println("pic uploaded ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;


	}

	public int updateProfilePic(String filename, String userid) 
	{
		int status=0;
		PreparedStatement ps=null;
		String strupdate="update users set picname=? where id=?";
		try {

			con=DbListener.openConnection();

			ps=con.prepareStatement(strupdate);
			ps.setString(1, filename);
			ps.setString(2, userid);
			int rowupdate=	ps.executeUpdate();
			if(rowupdate>0)

				status=1;
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			DbListener.closeConnection(con);
		}
		return status;

	}


	Query query;		

	ArrayList<Query>answerlist=new ArrayList<Query>();


	public ArrayList<Query>viewAnswer(String receiverid)
	{			
		PreparedStatement ps=null;
		ResultSet rs=null;

		if(!answerlist.isEmpty())

		{

			answerlist.clear();
		}

		con=DbListener.openConnection();
		try {

			String strsql="select * from query where senderid=? and answer is not null and status='true'";
			ps=con.prepareStatement(strsql);
			ps.setString(1, receiverid);
			rs=ps.executeQuery();
			while(rs.next())

			{
				int id=rs.getInt("queryid");
				String senderid=rs.getString("senderid");
				//String receiverid=rs.getString("receiverid");
				Date questiondate=rs.getDate("questiondate");
				Date answerdate=rs.getDate("answerdate");
				String question=rs.getString("question");
				String answer=rs.getString("answer");
				String status=rs.getString("status");

				Query q=new	Query(senderid,  receiverid, question, answer, status, questiondate,
						answerdate, id);
				answerlist.add(q);


			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		DbListener.closeConnection(con);
		return answerlist;
	}










	public boolean checkUserId(String userid) 
	{
		boolean status=false;
		
		con=DbListener.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			
			String strsql="select * from users where id=?";
		
			ps=con.prepareStatement(strsql);
			ps.setString(1, userid);
			System.out.println(ps);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
		//userid exists in the table

			status=true;
		

			}

		
		
}
catch(SQLException se)
{
	se.printStackTrace();
	
	
}

finally 
{
	if(ps!=null)
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	if(rs!=null)
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	DbListener.closeConnection(con);
	
}



		return status;
}










	public boolean checkReceiverId(String userid) 
	
	{
			boolean status=true;
			
			con=DbListener.openConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try {
				
				String strsql="select * from users where id=?";
			
				ps=con.prepareStatement(strsql);
				ps.setString(1, userid);
				System.out.println(ps);
				
				rs=ps.executeQuery();
				if(rs.next())
				{
		
				}
				else {
					status=false;
					
				}
	
			
			
	}
	catch(SQLException se)
	{
		se.printStackTrace();
		
		
	}
	
	finally 
	{
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		DbListener.closeConnection(con);
		
	}
	
	
	
			return status;
	}










	public int Ucontactus(Ucontactus u) 
	{
		
		int status =0;
		PreparedStatement ps=null;

		con=DbListener.openConnection();
		try {

			String strsql="insert into contactus(name, email, phone, yourquery,date)values(?,?,?,?,?)";

			ps=con.prepareStatement(strsql);
			ps.setString(1,u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3,u.getPhone());
			ps.setString(4, u.getYourquery());
	
			ps.setDate(5, u.getDate());

			System.out.println(ps);
			status=	ps.executeUpdate(); 

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		return status;
		}


//New methods 
	//1 to view services by user



	ArrayList<Accommodation_Service>servicelist=new ArrayList<>();
	
	public ArrayList<Accommodation_Service>viewAllServices()
	{			
		PreparedStatement ps=null;
		ResultSet rs=null;

		if(!servicelist.isEmpty())

		{

			servicelist.clear();
		}

		con=DbListener.openConnection();
		try {

			String strsql="select s.servicename,s.accommodationid,hp.name,hp.address,hp.email,hp.phone,hp.accommodationtype,hp.accommodationfor from services s,hostel_pgdetails hp where s.accommodationid=hp.accommodationid";
			ps=con.prepareStatement(strsql);
			
			rs=ps.executeQuery();
			while(rs.next())

			{
				int id=rs.getInt("accommodationid");
				String name=rs.getString("name");
				String servicename=rs.getString("servicename");
				
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				String accommodationtype=rs.getString("accommodationtype");
				String accommodationfor=rs.getString("accommodationfor");
					ad_service=new Accommodation_Service(servicename, name, address, email, phone, accommodationtype, accommodationfor, id);
				
					servicelist.add(ad_service);

			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		DbListener.closeConnection(con);
		return servicelist;
	}


AccommodationDetails ad;
ArrayList<AccommodationDetails>detaillist=new ArrayList<AccommodationDetails>();



//second method view all accomodations
	
	public ArrayList<AccommodationDetails> viewAccommodation()

	{
		
		con = DbListener.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String strsql = "select * from hostel_pgdetails";


			ps = con.prepareStatement(strsql);
		
		
			rs = ps.executeQuery();
		while (rs.next()) {
				int acid = rs.getInt("accommodationid");
				String name = rs.getString("name");
				ad=new AccommodationDetails();
				ad.setAccommodationid(acid);
				ad.setName(name);
				detaillist.add(ad);
				

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbListener.closeConnection(con);
		}

	return detaillist;
	}


//view all Room Details according to accomodationid
	ArrayList<RoomDetails_Type>roomlist=new ArrayList<RoomDetails_Type>();
	
	RoomDetails_Type rdt;
	  public ArrayList<RoomDetails_Type>viewAllRooms(int acid)
	  
	  {
	  
		  if(!roomlist.isEmpty())

			{

				roomlist.clear();
			}

	  con = DbListener.openConnection(); 
	  PreparedStatement ps = null;
	  ResultSet rs	  = null; 
	  try { 
		  String strsql = "SELECT hp.name,hp.email,hp.phone, rd.noofrooms,rd.facilities,rd.charges,rt.typename FROM hostel_pgdetails hp,room_details rd ,room_type rt where hp.accommodationid=? and rd.accommodationid=?  and rd.typeid=rt.type_id";
		  ps = con.prepareStatement(strsql);
		  ps.setInt(1, acid);
		  ps.setInt(2, acid);
		  System.out.println(ps);
		 
		  
	  	  rs = ps.executeQuery(); 
	  while (rs.next()) 
	  
	  { //int acid =	  rs.getInt("accommodationid"); 
	  String name = rs.getString("name"); 
	  String email=rs.getString("email");
	  String phone=rs.getString("phone");
	  int noofrooms=rs.getInt("noofrooms");
	  String charges=rs.getString("charges");
	  String facilities=rs.getString("facilities");
	  String type=rs.getString("typename");
	  System.out.println(name+phone+noofrooms+charges+type+facilities);
	  rdt=new RoomDetails_Type(name, email, phone, charges, facilities, type, noofrooms);
	  roomlist.add(rdt);
	 System.out.println(name);
	  }
	  }
	  catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbListener.closeConnection(con);
	  
	 
	  }  
	 
	  return roomlist;
	 
	  }
	 
			
	}

	 










