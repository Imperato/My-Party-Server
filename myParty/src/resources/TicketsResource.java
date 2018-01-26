package resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import model.AccessManager;
import model.Party;
import model.Ticket;

@Path("/tickets")
public class TicketsResource {
	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Create new ticket
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addTicket(Ticket ticket){
    	String u1 = null;
    	try {
    		u1 = new AccessManager().addTicket(ticket);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return u1;
    }
    
    // Return a list of Party of which a user has the ticket (receive user's id)
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTickets(@PathParam("id") String id) {
    	String parties = null;
    	ArrayList<Party> partyList = new ArrayList<Party>();
    	try {
			partyList = new AccessManager().getTickets(id);
		    Gson gson = new Gson();
			parties = gson.toJson(partyList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parties;
    }
    
    // Return the value of a ticket or "No ticket" if the user has not the ticket for this party
    // Receive the value pair (id of the party, user's id) of the ticket
    @Path("{partyId}/{userId}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTicketValue(@PathParam("partyId") String partyId, @PathParam("userId") String userId) {
    	String result = null;
    	try {
			result = new AccessManager().getTicketValue(partyId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }


}
