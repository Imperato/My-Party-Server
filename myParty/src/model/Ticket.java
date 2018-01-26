package model;

public class Ticket {

	private int id;
	private String value;
	private String partyId;
	private String userId;
	
	public Ticket() {
	
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value=value;
	}
	
	public String getPartyId() {
		return partyId;
	}
	
	public void setPartyId(String partyId) {
		this.partyId=partyId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId=userId;
	}
	
}
