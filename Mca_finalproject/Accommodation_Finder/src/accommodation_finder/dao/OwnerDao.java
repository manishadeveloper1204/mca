package accommodation_finder.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;*/
import java.util.ArrayList;

import accommodation_finder.dbList.DbListener;
import accommodation_finder.models.AccommodationDetails;
import accommodation_finder.models.FeedBack;
import accommodation_finder.models.Query;
import accommodation_finder.models.RoomType;
import accommodation_finder.models.Room_Details;
import accommodation_finder.models.Services;
import accommodation_finder.models.Users;
import accommodation_finder.models.admin;

public class OwnerDao implements DbListener
{
	
	Connection con;
	admin admin;
	Query qd;
	Users user=null;
	FeedBack feedback;
	AccommodationDetails ad;
	RoomType roomtype;
	ArrayList<FeedBack>userfeedback=new ArrayList<FeedBack>();
	ArrayList<Query> querylist =new ArrayList<Query>();
	ArrayList<AccommodationDetails>detaillist=new ArrayList();
	
	public ArrayList<FeedBack> viewfeedback(String receiverid)
	{
		con=DbListener.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(!userfeedback.isEmpty())
		userfeedback.clear();
		try {
			String strsql="select * from user_feedback where receiverid=?";
			ps=con.prepareStatement(strsql);
			ps.setString(1, receiverid);
			System.out.println(ps);
			rs=ps.executeQuery();
			while(rs.next())
			{
			String senderid=rs.getString("senderid");
			String Receiverid=rs.getString("receiverid");
				
			String subject=rs.getString("subject");
			 Date date=rs.getDate("date");
			 int rating =rs.getInt("rating");
				
				
				feedback=new FeedBack();
				feedback.setDate(date);
				feedback.setSubject(subject);
				feedback.setSenderid(senderid);
				feedback.setReceiverid(receiverid);
				feedback.setRating(rating);
				feedback.setId(rs.getInt("id"));
			    feedback.setFeedbacktext(rs.getString("feedbacktext"));
				userfeedback.add(feedback);
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
	
		return userfeedback;
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
		}
		
		
		return status;
	}




	public int deleteFeedBack(String[] feedbackids) 
	{
		
		int status=1;
		con=DbListener.openConnection();
		
		PreparedStatement ps=null;
		
		try {
			
			//con.setAutoCommit(false);//from java connection your table will not be updated
			String strdelete="delete from user_feedback where id=?";
			
		ps=con.prepareStatement(strdelete);
		for(int i=0;i<feedbackids.length;i++)
		{
			
			//ps.setInt(1, Integer.parseInt(feedbackids[i]));
			//ps.executeUpdate();//fire insert/update/delete query
			
			ps.setInt(1, Integer.parseInt(feedbackids[i]));
			ps.addBatch();//all the data will store in the buffer
		}
	//batch processing  is successfull when all records are deleted/updated/inserted
		
		int []arr=ps.executeBatch();//it will carry all the data to the RDBMS
		int flag=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<0)
			{
				flag=1;
				status=0;
				break;
			}
		}
		
		if(flag==0)
			//con.commit();//for permanent change
			return status;
		}
		catch(SQLException se)
		{
			try {
				con.rollback();//10 record -8 record->rollback->restore
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			se.printStackTrace();
		}
		
		
		
		finally {
			
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

public Query postAnswer(String queryid) {

	con = DbListener.openConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		String strsql = "select * from query where queryid=? and answer is null";
		int query_id = Integer.parseInt(queryid);
		ps = con.prepareStatement(strsql);
		ps.setInt(1, query_id);
		System.out.println(ps + "inside postAnswer");
		rs = ps.executeQuery();
		if (rs.next()) {
			int qid = rs.getInt("queryid");
			String senderid = rs.getString("senderid");
			String question = rs.getString("question");
			Date questiondate = rs.getDate("questiondate");
			String receiverid = rs.getString("receiverid");
			String answer = rs.getString("answer");
			String status = rs.getString("status");
			Date answerdate = rs.getDate("answerdate");
			qd = new Query();
			qd.setSenderid (senderid);
			qd.setQuestion(question);
			qd.setQuestiondate(questiondate);
			qd.setQuesid(query_id);
			qd.setReceiverid(receiverid);
			qd.setAnswer(answer);
			qd.setStatus(status);
			qd.setAnswerdate(answerdate);

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

	return qd;

}




public int updateAnswer(int queryid, String answer) {

	con = DbListener.openConnection();
	PreparedStatement ps = null;
	int status = 0;
	java.util.Date dt = new java.util.Date();
	java.sql.Date sqldate = new java.sql.Date(dt.getTime());
	try {
		String strupdate = "update query set answer=?,answerdate=?,status=? where queryid=?";
		ps = con.prepareStatement(strupdate);
		ps.setString(1, answer);
		ps.setDate(2, sqldate);
		ps.setString(3, "true");
		ps.setInt(4, queryid);
		status = ps.executeUpdate();

	}

	catch (SQLException se) {
		se.printStackTrace();
	}

	finally {
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	return status;

}

	
public ArrayList<Query> viewQuery(String receiverid) {
	con = DbListener.openConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (!querylist.isEmpty()) {
		querylist.clear();
	}
	try {
		String strsql = "select * from query where receiverid=? and answer is null";
		ps = con.prepareStatement(strsql);
		ps.setString(1, receiverid);
		System.out.println(ps);
		rs = ps.executeQuery();
		while (rs.next()) {
			int queryid = rs.getInt("queryid");
			String senderid = rs.getString("senderid");
			String question = rs.getString("question");
			Date questiondate = rs.getDate("questiondate");
			//String ownerid = rs.getString("ownerid");
			String answer = rs.getString("answer");
			String status = rs.getString("status");
			Date answerdate = rs.getDate("answerdate");
			qd = new Query();
			qd.setSenderid(senderid);
			qd.setQuestion(question);
			qd.setQuestiondate(questiondate);
			qd.setQuesid(queryid);
			qd.setReceiverid(receiverid);
			qd.setAnswer(answer);
			qd.setStatus(status);
			qd.setAnswerdate(answerdate);
			querylist.add(qd);
			System.out.println("manisha");
		}
	} catch (SQLException se) {
		se.printStackTrace();
	} finally {
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		DbListener.closeConnection(con);
	}
	return querylist;

}




public int addAccommodationDetails(AccommodationDetails ad) 
{
	int status=0;
	con=DbListener.openConnection();
	PreparedStatement ps=null;
	
	try {
		String strinsert="insert into hostel_pgdetails(ownerid, name, email, phone, address ,"
				+ "landmark, accommodationtype,accommodationfor,description,latitude,longitude)values(?,?,?,?,?,?,?,?,?,?,?)";
		ps=con.prepareStatement(strinsert);
		ps.setString(1, ad.getOwnerid());
		ps.setString(2, ad.getName());
		ps.setString(3, ad.getEmail());
		ps.setString(4, ad.getPhone());
		ps.setString(5, ad.getAddress());
		
		ps.setString(6, ad.getLandmark());
		ps.setString(7, ad.getAccommodationtype());
		ps.setString(8, ad.getAccommodationfor());
		ps.setString(9, ad.getDescription());
		ps.setDouble(10, ad.getLatitude());
		ps.setDouble(11, ad.getLongitude());
		
		
		System.out.println(ps);
		
		status=ps.executeUpdate();
		
		
	}
	catch(SQLException se)
	{
		
		se.printStackTrace();
	}
	//finally block
	
	return status;
}
	
	
//New Methods 
//first method to add service

public int addService(Services service)
{
PreparedStatement ps=null;




int status =0;


con=DbListener.openConnection();
try {
	
	String strsql="insert into services(ownerid, accommodationid, servicename)values(?,?,?)";
	
	ps=con.prepareStatement(strsql);
	ps.setString(1, service.getOwnerid());
	ps.setInt(2, service.getAccommodationid());
	ps.setString(3,service.getServicename());
	
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

//second method view all accommodation in comboBox to add services

public ArrayList<AccommodationDetails> viewAccommodation(String ownerid)

{
	
	con = DbListener.openConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		String strsql = "select * from hostel_pgdetails where ownerid=?";


		ps = con.prepareStatement(strsql);
		ps.setString(1, ownerid);
	
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


//Third method view RoomType


ArrayList<RoomType>roomtypelist=new ArrayList<>();
public ArrayList<RoomType> displayRoomType()

{
	
	con = DbListener.openConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		String strsql = "select * from room_type";


		ps = con.prepareStatement(strsql);
		
	
		rs = ps.executeQuery();
	while (rs.next()) {
			String type_id = rs.getString("type_id");
			String name = rs.getString("typename");
		roomtype=new RoomType(type_id,name);
			roomtypelist.add(roomtype);
			

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

return roomtypelist;
}


//fourth method add Room Details

public int addRoomDetails(Room_Details room_details) {

	PreparedStatement ps=null;




	int status =0;


	con=DbListener.openConnection();
	try {
		//detailsid, ownerid, accommodationid, typeid, noofrooms, facilities,charges
		String strsql="insert into room_details(ownerid, accommodationid, typeid,noofrooms,facilities,charges)values(?,?,?,?,?,?)";
		
		ps=con.prepareStatement(strsql);
		ps.setString(1, room_details.getOwnerid());
		ps.setInt(2, room_details.getAccommodationid());
		ps.setString(3,room_details.getTypeid());
		ps.setInt(4, room_details.getNoofrooms());
		ps.setString(5, room_details.getFacilities());
		ps.setString(6, room_details.getCharges());
		
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
}

	
	
	

