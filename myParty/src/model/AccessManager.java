package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Access;
import dao.Database;

/*
 * This class get the connection to database from Database class and passes it as parameter to Access class
 */
public class AccessManager {
	
	/*
	 * Get a list of all the parties
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getParties() throws Exception {
		ArrayList<Party> partyList = new ArrayList<Party>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		partyList = access.getParties(con);
		return partyList;
	}
	
	/*
	 * Get a list of parties created by a specific organizer
	 * Param: organizer's id
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getPartiesOrg(String organizer) throws Exception {
		ArrayList<Party> partyList = new ArrayList<Party>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		partyList = access.getPartiesOrg(con,organizer);
		return partyList;
	}
	
	/*
	 * Get a list of parties created by a specific organizer
	 * Param; organizer's name
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getPartiesOrgName(String organizer) throws Exception {
		ArrayList<Party> partyList = new ArrayList<Party>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		partyList = access.getPartiesOrgName(con,organizer);
		return partyList;
	}
	
	/*
	 * Get a list of parties of which a user has the ticket
	 * Param: user's id
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getPartiesTickets(String user) throws Exception {
		ArrayList<Party> partyList = new ArrayList<Party>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		partyList = access.getPartiesTickets(con,user);
		return partyList;
	}
	
	/*
	 * Get organizer's id from his name
	 * Param: organizer's name
	 * Return: organizer's id or "Bad" if occurs an error
	 */
	public String getOrgId(String organizer) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.getOrgId(con, organizer);
		return result;
	}
	
	/*
	 * Get organizer's city and address from his name
	 * Param: organizer's name
	 * Return: organizer's city and address
	 */
	public OrganizerLocation getOrgCityAddress(String organizer) throws Exception {
		OrganizerLocation ol = new OrganizerLocation();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		ol = access.getOrgCityAddress(con, organizer);
		return ol;
	}
	
	/*
	 * Get user's id from his name
	 * Pamas: user's name
	 * Return: user's id
	 */
	public String getUserId(String organizer) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.getUserId(con, organizer);
		return result;
	}
	
	/*
	 * Create new party
	 * Param; Party
	 * Return: "Ok" or "Bad"
	 */
	public String addParty(Party p) throws Exception {
		String party = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		party = access.addParty(con,p);
		return party;
	}
	
	/*
	 * Get data of a party
	 * Param; id of the party
	 * Return: Party
	 */
	public Party getParty(String id) throws Exception {
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		Party p = access.getParty(con,id);
		return p;
	}
	
	/*
	 * Create new user
	 * Param: User
	 * Return: "Ok" or "Name already in use" or "Bad" 
	 */
	public String addUser(User u) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.addUser(con, u);
		return result;
	}
	
	/*
	 * Create new organizer
	 * Param: Organizer
	 * Return: "Ok" or "Name already in use" or "Bad" 
	 */
	public String addOrganizer(Organizer o) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.addOrganizer(con, o);
		return result;
	}
	
	/*
	 * User's authentication
	 * Param: Credentials
	 * Return: 0 if something gone wrong 1 if credentials are invalid 2 if they are valid
	 */
	public String loginUser(Credentials c) throws Exception {
		int res;
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		res = access.loginUser(con, c);
		switch (res) {
		case 0:
			result = "Something gone wrong.";
			break;
		case 1:
			result = "Invalid credentials.";
			break;
		case 2:
			result = "Login done!";
			break;
		}
		return result;
	}

	/*
	 * Organizer's authentication
	 * Param: Credentials
	 * Return: 0 if something gone wrong 1 if credentials are invalid 2 if they are valid
	 */
	public String loginOrg(Credentials c) throws Exception {
		int res;
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		res = access.loginOrg(con, c);
		switch (res) {
		case 0:
			result = "Something gone wrong.";
			break;
		case 1:
			result = "Invalid credentials.";
			break;
		case 2:
			result = "Login done!";
			break;
		}
		return result;
	}
	
	/*
	 * Delete party
	 * Param: id of the party
	 * Return: "Ok" or "Bad"
	 */
	public String deleteParty(String id) throws Exception {
		String res = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		res = access.deleteParty(con, id);
		return res;
	}
	
	/*
	 * Delete user
	 * Param: user's id
	 * Return: "Ok" or "Bad"
	 */
	public String deleteUser(String id) throws Exception {
		String res = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		res = access.deleteUser(con, id);
		return res;
	}
	
	/*
	 * Delete organizer
	 * Param: organizer's id
	 * Return: "Ok" or "Bad"
	 */
	public String deleteOrganizer(String id) throws Exception {
		String res = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		res = access.deleteOrganizer(con, id);
		return res;
	}
	
	/*
	 * Delete organizer
	 * Param: organizer's name
	 * Return: "Ok" or "Bad"
	 */
	public String deleteOrganizerName(String name) throws Exception {
		String res = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		res = access.deleteOrganizerName(con, name);
		return res;
	}
	
	/*
	 * Get id of the party from its name
	 * Param: name of the party
	 * Return: id of the party
	 */
	public int getId(String name) throws Exception {
		int id = 0;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		id = access.getId(con, name);
		return id;
	}
	
	/*
	 * Edit party
	 * Params: Party edited and id of the party to edit
	 * Return: "Ok" or "Bad" 
	 */
	public String updateParty(Party p, String id) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.updateParty(con, p, id);
		return result;
	}

	/*
	 * Create new ticket
	 * Params: id of the party and id of the user
	 * Return: "Ok" or "Bad" or "Already have ticket"
	 */
	public String addTicket(Ticket t) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.addTicket(con,t);
		return result;
	}
	
	/*
	 * Get a list of the parties of which a user has the ticket
	 * Param: user's id
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getTickets(String userId) throws Exception {
		ArrayList<Party> partyList = new ArrayList<Party>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		partyList = access.getTickets(con,userId);
		return partyList;
	}
	
	/*
	 * Get the value of a ticket (used to create qr code)
	 * Params: id of the party and id of the user
	 * Return: value of the ticket or "No ticket" if user has not the ticket for this party
	 */
	public String getTicketValue(String partyId, String userId) throws Exception {
		String result = null;
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.getTicketValue(con, partyId, userId);
		return result;
	}
	
}
