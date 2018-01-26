package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.AccessManager;
import model.Organizer;
import model.OrganizerLocation;

@Path("/organizers")
public class OrganizersResource {
	
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Create new organizer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addOrganizer(Organizer organizer){
    	Organizer o = new Organizer();
    	String o1 = null;
    	o.setName(organizer.getName());
    	o.setPassword(organizer.getPassword());
    	o.setCity(organizer.getCity());
    	o.setAddress(organizer.getAddress());
    	try {
    		o1 = new AccessManager().addOrganizer(o);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return o1;
    }
    
    // Return organizer's id from his name
    @Path("{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String getId(@PathParam("name") String name) {
    	String name1 = name;
    	String result = null;
    	try {
			 result = new AccessManager().getOrgId(name1);
		 } catch (Exception e) {
	    		e.printStackTrace();
	    	}
		 return result;
    }
    
    // Delete organizer (receive his name)
    @DELETE
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteOrganizer(@PathParam("name") String name) {
    	String res = null;
    	try {
    		res = new AccessManager().deleteOrganizerName(name);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return res;
    }
    
    /*
     * Delete organizer (receive his id)
    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteOrganizer(@PathParam("id") String id) {
    	String res = null;
    	try {
    		res = new AccessManager().deleteOrganizer(id);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return res;
    }
    */
    
    // Return organizer's city and address from his name
    @Path("location/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public OrganizerLocation getCityAddress(@PathParam("name") String name) {
    	String name1 = name;
    	OrganizerLocation ol = new OrganizerLocation();
    	try {
			 ol = new AccessManager().getOrgCityAddress(name1);
		 } catch (Exception e) {
	    		e.printStackTrace();
	    	}
		 return ol;
    }


}
