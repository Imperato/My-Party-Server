package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
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

// Will map the resource to the URL parties
@Path("/parties")
public class PartiesResource {
	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Return a list of all the parties
    @GET
    @Produces({ MediaType.APPLICATION_JSON }) // Produce a JSON
    public String getParties() throws InterruptedException {
    	String parties = null;
        List<Party> partyList = new ArrayList<Party>();
        try {
			partyList = new AccessManager().getParties();
		    Gson gson = new Gson();
			parties = gson.toJson(partyList); // Parsing from ArrayList of Party to JSON
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parties;
	}
    
    /*
     * 
     * Return a list of parties created by a specific organizer from his id
    @Path("{org}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPartiesOrg(@PathParam("org") String org) {
    	String parties = null;
    	String organizer = org;
    	List<Party> partyList = new ArrayList<Party>();
    	try {
			partyList = new AccessManager().getPartiesOrg(organizer);
		    Gson gson = new Gson();
			parties = gson.toJson(partyList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parties;
    }
    */
    
    // Return a list of parties created by a specific organizer from his name
    @Path("{org}") // Receive the organizer's name as a parameter in the URL  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPartiesOrgName(@PathParam("org") String org) {
    	String parties = null;
    	String organizer = org;
    	List<Party> partyList = new ArrayList<Party>();
    	try {
			partyList = new AccessManager().getPartiesOrgName(organizer);
		    Gson gson = new Gson();
			parties = gson.toJson(partyList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parties;
    }
    
    // Create new party
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Receive the new party in the body of the request
    @Produces(MediaType.TEXT_PLAIN) // Return "Ok" or "Bad"
    public String addParty(Party party){
    	Party p = new Party();
    	String result = null;
    	p.setName(party.getName());
    	p.setOrganizerId(party.getOrganizerId());
    	p.setOrganizerName(party.getOrganizerName());
    	p.setDate(party.getDate());
    	p.setCity(party.getCity());
    	p.setAddress(party.getAddress());
    	p.setDescription(party.getDescription());
    	p.setPrice(party.getPrice());
    	p.setLatitude(party.getLatitude());
    	p.setLongitude(party.getLongitude());
    	try {
    		result = new AccessManager().addParty(p);

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }       
    
    // Delete party (receive its id)
    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteParty(@PathParam("id") String id) {
    	String res = null;
    	try {
    		res = new AccessManager().deleteParty(id);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return res;
    }
    
    // Edit party (receive its id)
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON) // Receive the party edited in the body of the request
    @Produces(MediaType.TEXT_PLAIN)
    public String updateParty(Party party, @PathParam("id") String id) {
    	Party p = new Party();
    	String result = null;
    	p.setName(party.getName());
    	p.setDate(party.getDate());
    	p.setCity(party.getCity());
    	p.setAddress(party.getAddress());
    	p.setDescription(party.getDescription());
    	p.setPrice(party.getPrice());
    	p.setLatitude(party.getLatitude());
    	p.setLongitude(party.getLongitude());
    	try {
    		result = new AccessManager().updateParty(p, id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }
    
    // Return the details of a party
    @GET
    @Path("details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getParty(@PathParam("id") String id) {
    	String partyS=null;
    	try {
    		Party party = new AccessManager().getParty(id);
		    Gson gson = new Gson();
		    partyS = gson.toJson(party);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return partyS;
    }
    
    // Return a list of Party of which a user has the ticket (receive user's id)
    @GET
    @Path("tickets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPartiesTicket(@PathParam("id") String id) {
    	String parties = null;
        List<Party> partyList = new ArrayList<Party>();    	
        try {
    		partyList = new AccessManager().getPartiesTickets(id);
		    Gson gson = new Gson();
		    parties = gson.toJson(partyList);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return parties;
    }

}
