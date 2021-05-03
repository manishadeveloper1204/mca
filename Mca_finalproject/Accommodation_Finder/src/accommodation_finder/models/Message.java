package accommodation_finder.models;

import java.sql.Date;

public class Message 
{
private  String senderid,receiverid,subject,messagetext,rstatus,sstatus;
	
	private Date date;
     int msgid;
	public Message(String senderid, String receiverid, String subject, String messagetext, String rstatus,
			String sstatus, Date date) {
		super();
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.subject = subject;
		this.messagetext = messagetext;
		this.rstatus = rstatus;
		this.sstatus = sstatus;
		this.date = date;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int msgid, String senderid, String receiverid, String subject, String messagetext, String rstatus,
			String sstatus, Date date) {
		super();
		this.msgid = msgid;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.subject = subject;
		this.messagetext = messagetext;
		this.rstatus = rstatus;
		this.sstatus = sstatus;
		this.date = date;
	}

	public int getMsgid() {
		return msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
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

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public String getSstatus() {
		return sstatus;
	}

	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
