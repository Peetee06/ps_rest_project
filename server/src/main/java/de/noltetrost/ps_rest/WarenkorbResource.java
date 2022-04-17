package de.noltetrost.ps_rest;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("warenkoerbe")
public class WarenkorbResource {

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{warenkorbid}")
	public String getWarenkorb(@PathParam("warenkorbid") int warenkorbID) throws JsonProcessingException, ClassNotFoundException, SQLException {
		
		DatabaseHandler dbHandler = new DatabaseHandler();
		ObjectMapper objectMapper = new ObjectMapper();
		dbHandler.connectDb();
		Warenkorb[] warenkorb = dbHandler.leseWarenkorb(warenkorbID);
		dbHandler.closeDb();
		String warenkorbJSON = objectMapper.writeValueAsString(warenkorb);
		
		return warenkorbJSON;
	}
	
	

}
