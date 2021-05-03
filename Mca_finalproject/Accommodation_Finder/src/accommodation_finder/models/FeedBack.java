package accommodation_finder.models;

import java.sql.Date;

public class FeedBack 
{
	private String senderid,receiverid,subject,feedbacktext;
	
	private Date date;
   int id,rating;
	public FeedBack(String senderid, String receiverid, String subject, String feedbacktext, int rating,Date date) {
		super();
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.subject = subject;
		this.feedbacktext = feedbacktext;
		this.rating = rating;
		this.date = date;
	}

	public FeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedBack(int id, String senderid, String receiverid, String subject, String feedbacktext, int rating,
			Date date) {
		super();
		this.id = id;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.subject = subject;
		this.feedbacktext = feedbacktext;
		this.rating = rating;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public String getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFeedbacktext() {
		return feedbacktext;
	}

	public void setFeedbacktext(String feedbacktext) {
		this.feedbacktext = feedbacktext;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
