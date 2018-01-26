package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.security.NoSuchAlgorithmException;

import model.Party;
import model.Ticket;
import model.User;
import model.Organizer;
import model.Credentials;
import model.OrganizerLocation;

/*
 * This class contains the functions for database operations
 * Each function get as parameter the database connection created in
 * AccessManager class, which calls the following methods
 */
public class Access {
	
	/*
	 * Get id of the party from its name
	 * Param: name of the party
	 * Return: id of the party
	 */
	public int getId(Connection con, String name) throws SQLException {
		int id = 0;
		String sql = "SELECT id FROM party WHERE name = (?)";
		PreparedStatement pst = con.prepareStatement(sql); // Protection against SQL-Injection
		try {
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return id;
	}
	
	/*
	 * Get organizer's id from his name
	 * Param: organizer's name
	 * Return: organizer's id or "Bad" if occurs an error
	 */
	public String getOrgId(Connection con, String name) throws SQLException {
		String id = null;
		String sql = "SELECT id FROM organizer WHERE name = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				id = rs.getString("id");
			else
				id = "Bad";
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return id;
	}
	
	/*
	 * Get organizer's city and address from his name
	 * Param: organizer's name
	 * Return: organizer's city and address
	 */
	public OrganizerLocation getOrgCityAddress(Connection con, String name) throws SQLException {
		OrganizerLocation ol = new OrganizerLocation();
		String sql = "SELECT city, address FROM organizer WHERE name = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ol.setCity(rs.getString("city"));
				ol.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return ol;
	}
	
	/*
	 * Get user's id from his name
	 * Pamas: user's name
	 * Return: user's id
	 */
	public String getUserId(Connection con, String name) throws SQLException {
		String id = null;
		String sql = "SELECT id FROM user WHERE username = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return id;
	}
	
	/*
	 * Get a list of all the parties
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getParties(Connection con) throws SQLException {
		ArrayList<Party> partyList = new ArrayList<Party>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM party");
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				Party partyObj = new Party();
				partyObj.setId(rs.getInt("id"));
				partyObj.setName(rs.getString("name"));
				partyObj.setOrganizerId(rs.getString("organizerId"));
				partyObj.setOrganizerName(rs.getString("organizerName"));
				partyObj.setDate(rs.getString("date"));
				partyObj.setCity(rs.getString("city"));
				partyObj.setAddress(rs.getString("address"));
				partyObj.setDescription(rs.getString("description"));
				partyObj.setPrice(rs.getDouble("price"));
				partyObj.setTickets(rs.getInt("tickets"));
				partyObj.setLatitude(rs.getDouble("latitude"));
				partyObj.setLongitude(rs.getDouble("longitude"));
				partyList.add(partyObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return partyList;
	}
	
	/*
	 * Get a list of parties created by a specific organizer
	 * Param: organizer's id
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getPartiesOrg(Connection con, String organizer) throws SQLException {
		ArrayList<Party> partyList = new ArrayList<Party>();
		String sql = "SELECT * FROM party WHERE organizerId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, organizer);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Party partyObj = new Party();
				partyObj.setId(rs.getInt("id"));
				partyObj.setName(rs.getString("name"));
				partyObj.setOrganizerId(rs.getString("organizerId"));
				partyObj.setOrganizerName(rs.getString("organizerName"));
				partyObj.setDate(rs.getString("date"));
				partyObj.setCity(rs.getString("city"));
				partyObj.setAddress(rs.getString("address"));
				partyObj.setDescription(rs.getString("description"));
				partyObj.setPrice(rs.getDouble("price"));
				partyObj.setTickets(rs.getInt("tickets"));
				partyObj.setLatitude(rs.getDouble("latitude"));
				partyObj.setLongitude(rs.getDouble("longitude"));
				partyList.add(partyObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return partyList;
	}
	
	/*
	 * Get a list of parties created by a specific organizer
	 * Param; organizer's name
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getPartiesOrgName(Connection con, String organizerName) throws SQLException {
		String id = getOrgId(con, organizerName);
		ArrayList<Party> partyList = new ArrayList<Party>();
		String sql = "SELECT * FROM party WHERE organizerId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Party partyObj = new Party();
				partyObj.setId(rs.getInt("id"));
				partyObj.setName(rs.getString("name"));
				partyObj.setOrganizerId(rs.getString("organizerId"));
				partyObj.setOrganizerName(rs.getString("organizerName"));
				partyObj.setDate(rs.getString("date"));
				partyObj.setCity(rs.getString("city"));
				partyObj.setAddress(rs.getString("address"));
				partyObj.setDescription(rs.getString("description"));
				partyObj.setPrice(rs.getDouble("price"));
				partyObj.setTickets(rs.getInt("tickets"));
				partyObj.setLatitude(rs.getDouble("latitude"));
				partyObj.setLongitude(rs.getDouble("longitude"));
				partyList.add(partyObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return partyList;
	}
	
	/*
	 * Get data of a party
	 * Param; id of the party
	 * Return: Party
	 */
	public Party getParty(Connection con, String id) throws SQLException {
		Party partyObj = new Party();
		String sql = "SELECT * FROM party WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				partyObj.setId(rs.getInt("id"));
				partyObj.setName(rs.getString("name"));
				partyObj.setOrganizerId(rs.getString("organizerId"));
				partyObj.setOrganizerName(rs.getString("organizerName"));
				partyObj.setDate(rs.getString("date"));
				partyObj.setCity(rs.getString("city"));
				partyObj.setAddress(rs.getString("address"));
				partyObj.setTickets(rs.getInt("tickets"));
				partyObj.setPrice(rs.getDouble("price"));
				partyObj.setDescription(rs.getString("description"));
				partyObj.setLatitude(rs.getDouble("latitude"));
				partyObj.setLongitude(rs.getDouble("longitude"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partyObj;
	}
	
	/*
	 * Get a list of parties of which a user has the ticket
	 * Param: user's id
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getPartiesTickets(Connection con, String user) throws SQLException {
		ArrayList<Party> partyList = new ArrayList<Party>();
		String sql = "SELECT party.id, party.name, party.organizerId, party.organizerName, party.date, party.city, party.address,"
				+ " party.description, party.price, party.tickets, party.latitude, party.longitude FROM party JOIN ticket ON party.id=ticket.partyId WHERE ticket.userId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, user);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Party partyObj = new Party();
				partyObj.setId(rs.getInt("id"));
				partyObj.setName(rs.getString("name"));
				partyObj.setOrganizerId(rs.getString("organizerId"));
				partyObj.setOrganizerName(rs.getString("organizerName"));
				partyObj.setDate(rs.getString("date"));
				partyObj.setCity(rs.getString("city"));
				partyObj.setAddress(rs.getString("address"));
				partyObj.setDescription(rs.getString("description"));
				partyObj.setPrice(rs.getDouble("price"));
				partyObj.setTickets(rs.getInt("tickets"));
				partyObj.setLatitude(rs.getDouble("latitude"));
				partyObj.setLongitude(rs.getDouble("longitude"));
				partyList.add(partyObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return partyList;
	}
	
	/*
	 * Create new party
	 * Param; Party
	 * Return: "Ok" or "Bad"
	 */
	public String addParty(Connection con, Party party) throws SQLException {
		String result = null;
		String sql = "INSERT INTO party( name, organizerId, organizerName, date, city, address, description, price, latitude, longitude) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, party.getName());
			pst.setString(2, party.getOrganizerId());
			pst.setString(3, party.getOrganizerName());
			pst.setString(4, party.getDate());
			pst.setString(5, party.getCity());
			pst.setString(6, party.getAddress());
			pst.setString(7, party.getDescription());
			pst.setDouble(8, party.getPrice());
			pst.setDouble(9, party.getLatitude());
			pst.setDouble(10, party.getLongitude());
			int rowsInserted = pst.executeUpdate();
			if (rowsInserted > 0) {
				int id = getId(con,party.getName());
				party.setId(id);
				System.out.println("A new party was inserted successfully!\n" +party.toString());
				result = "Ok";
			}
			else {
				System.out.println("The party " + party.toStringNoId() + "was not inserted.");
				result = "Bad";
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Check if exists another user with the same username (used during registration phase)
	 * Param: username
	 * Return: boolean
	 */
	public boolean checkDuplicate(Connection con, User user) throws SQLException {
		final String username= user.getUsername();
		String sql = "SELECT username FROM user WHERE username = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		boolean result = false;
		try {
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if (rs.isBeforeFirst())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Create new user
	 * Param: User
	 * Return: "Ok" or "Name already in use" or "Bad" 
	 */
	public String addUser(Connection con, User user) throws SQLException, NoSuchAlgorithmException {
		String result = null;
		if (checkDuplicate(con,user))
			result = "Name already in use";
		else {
			final String username= user.getUsername();
			final String hash_psw= user.getPassword();
			String sql = "INSERT INTO user(username, password) VALUES (?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			try {
				pst.setString(1, username);
				pst.setString(2, hash_psw);
				int rowsInserted = pst.executeUpdate();
				if (rowsInserted > 0) {
					int id = getId(con,user.getUsername());
					user.setId(id);
					System.out.println("A new user was inserted successfully!\n" +user.toString());
					result = "Ok";
				}
				else {
					System.out.println("The user " + user.toStringNoId() + "was not inserted.");
					result = "Bad";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
		return result;
	}
	
	/*
	 * Check if exists another organizer with the same username (used during registration phase)
	 * Param: username
	 * Return: boolean
	 */
	public boolean checkDuplicateO(Connection con, Organizer organizer) throws SQLException {
		final String name= organizer.getName();
		String sql = "SELECT name FROM organizer WHERE name = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		boolean result = false;
		try {
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			if (rs.isBeforeFirst())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Create new organizer
	 * Param: Organizer
	 * Return: "Ok" or "Name already in use" or "Bad" 
	 */
	public String addOrganizer(Connection con, Organizer organizer) throws SQLException, NoSuchAlgorithmException {
		String result = null;
		if (checkDuplicateO(con,organizer))
			result = "Name already in use";
		else {
			final String name= organizer.getName();
			final String hash_psw= organizer.getPassword();
			final String city= organizer.getCity();
			final String address= organizer.getAddress();
			String sql = "INSERT INTO organizer(name, password, city, address) VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			try {
				pst.setString(1, name);
				pst.setString(2, hash_psw);
				pst.setString(3, city);
				pst.setString(4, address);
				int rowsInserted = pst.executeUpdate();
				if (rowsInserted == 1) {
					int id = getId(con,organizer.getName());
					organizer.setId(id);
					System.out.println("A new organizer was inserted successfully!\n" +organizer.toString());
					result = "Ok"; 
					}
				else {
					System.out.println("The organizer " + organizer.toString() + "was not inserted.");
					result = "Bad";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
		return result;
	}
	
	/*
	 * User's authentication
	 * Param: Credentials
	 * Return: 0 if something gone wrong 1 if credentials are invalid 2 if they are valid
	 */
	public int loginUser(Connection con, Credentials c) throws SQLException, NoSuchAlgorithmException  {
		int result = 0;
		String name=c.getName();
		String hash_psw=c.getPassword();
		String sql="SELECT username, password FROM user WHERE username = (?) AND password = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, name);
			pst.setString(2, hash_psw);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				result = 2; // Correct login
			else
				result = 1; // Invalid credentials
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	
	/*
	 * Organizer's authentication
	 * Param: Credentials
	 * Return: 0 if something gone wrong 1 if credentials are invalid 2 if they are valid
	 */
	public int loginOrg(Connection con, Credentials c) throws SQLException, NoSuchAlgorithmException  {
		int result = 0;
		String name=c.getName();
		String hash_psw=c.getPassword();
		String sql="SELECT name, password FROM organizer WHERE name = (?) AND password = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, name);
			pst.setString(2, hash_psw);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				result = 2; // Correct login
			else
				result = 1; // Invalid credentials
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	
	/*
	 * Delete party
	 * Param: id of the party
	 * Return: "Ok" or "Bad"
	 */
	public String deleteParty(Connection con, String id) throws SQLException {
		int res = 0;
		String result = null;
		String sql = "DELETE FROM party WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		if (res == 1)
			result = "Ok";
		else
			result = "Bad";
		return result;
	}
	
	/*
	 * Delete parties of a specific organizer (used when an organizer delete his account)
	 * Param: organizer's id 
	 * Return: "Ok" or "Bad"
	 */
	public String deletePartyOrganizer(Connection con, String id) throws SQLException {
		int res = 0;
		String result = null;
		// Check if there is any party of this organizer
		String sql1 = "SELECT * FROM party WHERE organizerId = (?)";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		try {
			pst1.setString(1, id);
			ResultSet rs = pst1.executeQuery();
			if (!rs.next()) { // If there isn't
				result = "Ok"; // Nothing to delete
			}
			else { // If there is/are
				// Delete this organizer's party/parties
				String sql = "DELETE FROM party WHERE organizerId = (?)";
				PreparedStatement pst = con.prepareStatement(sql);
				try {
					pst.setString(1, id);
					res = pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					}
				if (res >= 1) // Party deleted
					result = "Ok";
				else // Party not deleted
					result = "Bad";	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Delete user
	 * Param: user's id
	 * Return: "Ok" or "Bad"
	 */
	public String deleteUser(Connection con, String id) throws SQLException {
		// Decrease the number of tickets sold of the parties of which this user had tickets
		String result1 = decreaseNumberOfTickets(con,id);
		int res = 0;
		String result = null;
		String sql = "DELETE FROM user WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		if (res == 1 && result1.equals("Ok")) 
			result = "Ok";
		else
			result = "Bad";
		return result;
	}
	
	/*
	 * Delete organizer
	 * Param: organizer's id
	 * Return: "Ok" or "Bad"
	 */
	public String deleteOrganizer(Connection con, String id) throws SQLException {
		String res1 = deletePartyOrganizer(con,id);
		int res = 0;
		String result = null;
		if (res1.equals("Ok")) {	
			String sql = "DELETE FROM organizer WHERE id = (?)";
			PreparedStatement pst = con.prepareStatement(sql);
			try {
				pst.setString(1, id);
				res = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				}
			if (res == 1)
				result = "Ok";
			else
				result = "Bad";
		}
		else
			result = "Bad";
		return result;
	}
	
	/*
	 * Delete organizer
	 * Param: organizer's name
	 * Return: "Ok" or "Bad"
	 */
	public String deleteOrganizerName(Connection con, String name) throws SQLException {
		String id = getOrgId(con,name);
		int res = 0;
		String result = null;
		String sql = "DELETE FROM organizer WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		if (res == 1)
			result = "Ok";
		else
			result = "Bad";	
	return result;
	}
	
	/*
	 * Edit party
	 * Params: Party edited and id of the party to edit
	 * Return: "Ok" o "Bad" 
	 */
	public String updateParty(Connection con, Party party, String id) throws SQLException {
		String result = null;
		String sql = "UPDATE party SET name = (?), date = (?), city = (?), address = (?), description = (?), price = (?), latitude = (?), longitude = (?) WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, party.getName());
			pst.setString(2, party.getDate());
			pst.setString(3, party.getCity());
			pst.setString(4, party.getAddress());
			pst.setString(5, party.getDescription());
			pst.setDouble(6, party.getPrice());
			pst.setDouble(7, party.getLatitude());
			pst.setDouble(8, party.getLongitude());
			pst.setString(9, id);
			int rowsInserted = pst.executeUpdate();
			if (rowsInserted > 0) {
				int id1 = getId(con,party.getName());
				party.setId(id1);
				System.out.println("A new party was updated successfully!\n" +party.toString());
				result = "Ok";
			}
			else {
				System.out.println("The party " + party.toStringNoId() + " was not updated.");
				result = "Bad";
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Create new ticket
	 * Params: id of the party and id of the user
	 * Return: "Ok" or "Bad" or "Already have ticket"
	 */
	public String addTicket(Connection con, Ticket t) throws SQLException, NoSuchAlgorithmException {
		String result = "Bad";
		if (checkDuplicateTicket(con, t))
			result = "Already have ticket";
		else {
			String value = randomAlphaNumeric(16);
			String sql = "INSERT INTO ticket (value, partyId, userId) VALUES (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			try {
				pst.setString(1, value);
				pst.setString(2, t.getPartyId());
				pst.setString(3, t.getUserId());
				int rowsInserted = pst.executeUpdate();
				if (rowsInserted > 0) {
					int oldNumberOfTickets = getNumberOfTickets(con, t.getPartyId());
					String result1 = increaseNumberOfTickets(con, t.getPartyId(), oldNumberOfTickets);
					if (result1.equals("Ok"))
						result = "Ok";
				}
				else
					result = "Bad";
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
		return result;
	}
		
	/*
	 * Get the number of tickets sold of a party
	 * Param. id of the party
	 * Return: number of tickets
	 */
	public int getNumberOfTickets(Connection con, String partyId) throws SQLException {
		int tickets = 0;
		String sql = "SELECT tickets FROM party WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, partyId);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				tickets = rs.getInt("tickets");
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return tickets;
	}
	
	/*
	 * Increase by 1 the number of tickets sold of a party
	 * Params: id of the party and previous number of tickets
	 * Return: "Ok" or "Bad"
	 */
	public String increaseNumberOfTickets(Connection con, String partyId, int tickets) throws SQLException {
		tickets++;
		String result = "Bad";
		String sql = "UPDATE party SET tickets = (?) WHERE id = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setInt(1, tickets);
			pst.setString(2, partyId);
			int rowsInserted = pst.executeUpdate();
			if (rowsInserted > 0) 
				result = "Ok";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * Decrease by 1 the number of tickets sold of a party (used when a user who had a ticket delete his account)
	 * Param: id of the party
	 * Return: "Ok" or "Bad"
	 */
	public String decreaseNumberOfTickets(Connection con, String userId) throws SQLException {
		String result = "Bad";
		ArrayList<Party> partyList = getPartiesTickets(con,userId);
		if (partyList.isEmpty()) 
			result = "Ok";
		else {
			for (int i=0; i<partyList.size(); i++) {
				Party partyObj = partyList.get(i);
				int partyId = partyObj.getId();
				int partyTickets = partyObj.getTickets();
				partyTickets--;
				String sql = "UPDATE party SET tickets = (?) WHERE id = (?)";
				PreparedStatement pst = con.prepareStatement(sql);
				try {
					pst.setInt(1, partyTickets);
					pst.setInt(2, partyId);
					int rowInserted = pst.executeUpdate();
					if (rowInserted > 0)
						result = "Ok";
					else
						result = "Bad";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/*
	 * Get a list of the parties of which a user has the ticket
	 * Param: user's id
	 * Return: ArrayList of Party
	 */
	public ArrayList<Party> getTickets(Connection con, String userId) throws SQLException {
		ArrayList<Party> partyList = new ArrayList<Party>();
		String sql = "SELECT party.id AS partyId, party.name AS partyName, party.organizerId AS partyOrganizerId, "
				+ "party.organizerName AS partyOrganizerName, party.date AS partyDate, party.city AS partyCity, "
				+ "party.address AS partyAddress, party.description AS partyDescription, party.price AS partyPrice, "
				+ "party.tickets AS partyTickets FROM party JOIN ticket ON party.id=ticket.partyId WHERE ticket.userId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, userId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Party partyObj = new Party();
				partyObj.setId(rs.getInt("partyId"));
				partyObj.setName(rs.getString("partyName"));
				partyObj.setOrganizerId(rs.getString("partyOrganizerId"));
				partyObj.setOrganizerName(rs.getString("partyOrganizerName"));
				partyObj.setDate(rs.getString("partyDate"));
				partyObj.setCity(rs.getString("partyCity"));
				partyObj.setAddress(rs.getString("partyAddress"));
				partyObj.setDescription(rs.getString("partyDescription"));
				partyObj.setPrice(rs.getDouble("partyPrice"));
				partyObj.setTickets(rs.getInt("partyTickets"));
				partyList.add(partyObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return partyList;
	}
	
	/*
	 * Get the value of a ticket (used to create qr code)
	 * Params: id of the party and id of the user
	 * Return: value of the ticket or "No ticket" if user has not the ticket for this party
	 */
	public String getTicketValue(Connection con, String partyId, String userId) throws SQLException {
		String result = null;
		String sql = "SELECT value FROM ticket WHERE partyId = (?) AND userId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, partyId);
			pst.setString(2, userId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("value");
			}
			else
				result = "No ticket";
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Check if a user already has the ticket for this party
	 * Param: Ticket
	 * Return: boolean
	 */
	public boolean checkDuplicateTicket(Connection con, Ticket t) throws SQLException {
		boolean result = false;
		String partyId = t.getPartyId();
		String userId = t.getUserId();
		String sql = "SELECT userId FROM ticket WHERE partyId = (?) AND userId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, partyId);
			pst.setString(2, userId);
			ResultSet rs = pst.executeQuery();
			if (rs.isBeforeFirst())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	/*
	 * Check if a user already has the ticket for this party
	 * Params; id of the party and id of the user
	 * Return: boolean
	 *  
	 */
	public boolean checkIfUserHasTicket(Connection con, String partyId, String userId) throws SQLException {
		boolean result = false;
		String sql = "SELECT userId FROM ticket WHERE partyId = (?) AND userId = (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		try {
			pst.setString(1, partyId);
			pst.setString(2, userId);
			ResultSet rs = pst.executeQuery();
			if (rs.isBeforeFirst())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return result;
	}
	
	// Create random string to use as value for the ticket
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	/*
	// Hashing of password
    public String hash(String text) throws NoSuchAlgorithmException {
        //Hashing della password con MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        byte byteData[] = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++)
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        return sb.toString();
    }
	*/
	
}
