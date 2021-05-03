package accommodation_finder.models;

import java.sql.Date;

public class Query 
{
private String senderid,receiverid,question,answer,status;
	
	private Date questiondate,answerdate;
    int id, queryId;
	
    public Query() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Query(String senderid, String receiverid, String question, String answer, String status, Date questiondate,
			Date answerdate, int id) {
		super();
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.question = question;
		this.answer = answer;
		this.status = status;
		this.questiondate = questiondate;
		this.answerdate = answerdate;
		this.id = id;
	}
	
	



	public Query(String senderid, String receiverid, String question, String status, Date questiondate) {
		super();
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.question = question;
		this.status = status;
		this.questiondate = questiondate;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getQuestiondate() {
		return questiondate;
	}

	public void setQuestiondate(Date questiondate) {
		this.questiondate = questiondate;
	}

	public Date getAnswerdate() {
		return answerdate;
	}

	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

   
    public int getQuesid() {
    	return this.queryId;
    }
	
	  public void setQuesid(int queryid) { // TODO Auto-generated method stub
	  this.queryId = queryid;
	  }
	  
	 
	/*public int getUserid() {
		return 1;
	}*/
    
}
