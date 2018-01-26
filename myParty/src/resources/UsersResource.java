package resources;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.AccessManager;
import model.User;

@Path("/users")
public class UsersResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Create new user
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser(User user){
    	User u = new User();
    	String u1 = null;
    	u.setUsername(user.getUsername());
    	u.setPassword(user.getPassword());
    	try {
    		u1 = new AccessManager().addUser(u);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return u1;
    }
    
    // Return user's id from his name
    @Path("{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String getId(@PathParam("name") String name) {
    	String name1 = name;
    	String result = null;
    	try {
			 result = new AccessManager().getUserId(name1);
		 } catch (Exception e) {
	    		e.printStackTrace();
	    	}
		 return result;
    }
    
    // Delete user (receive his id)
    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("id") String id) {
    	String res = null;
    	try {
    		res = new AccessManager().deleteUser(id);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return res;
    }
  
}
