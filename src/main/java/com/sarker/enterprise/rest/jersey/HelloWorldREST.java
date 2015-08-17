/**
 * HelloWorldREST.java
 *
 * Date 17/08/2015 10:08:15 AM
 * @author ayub, ayub.ali.sarker@gmail.com
 * 
 **/

package com.sarker.enterprise.rest.jersey;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author ayub
 * 
 */
@Path("/helloWorldREST")
public class HelloWorldREST {
	@GET
	@Path("/{parameter}")
	public Response responseMsg(@PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {
		String output = "Hello from: " + parameter + " : " + value;
		return Response.status(200).entity(output).build();
	}

	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("/plain/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	// This method is called if XML is request
	@GET
	@Path("/xml/get")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
	
	///http://localhost:8889/SimpleMavenWebApp/rest/helloWorldREST/plain/get

	@GET
	@Path("/json/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

}
