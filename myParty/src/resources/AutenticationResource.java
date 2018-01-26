package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.AccessManager;
import model.Credentials;

@Path("/autentication")
public class AutenticationResource {

	 @Context
	 UriInfo uriInfo;
	 @Context
	 Request request;
	 
	 // Authentication of a user
	 @Path("{varX}/{varY}")
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String loginUser(@PathParam("varX") String varX, @PathParam("varY") String varY) {
		 String name = varX;
		 String password = varY;
		 Credentials c = new Credentials(name,password);
		 String result = null;
		 try {
			 result = new AccessManager().loginUser(c);
		 } catch (Exception e) {
	    		e.printStackTrace();
	    	}
		 return result;
	 }

}
