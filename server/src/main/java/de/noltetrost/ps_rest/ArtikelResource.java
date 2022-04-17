package de.noltetrost.ps_rest;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("artikel")
public class ArtikelResource {
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{artikelid}")
	public String getOneArtikel(@PathParam("artikelid") int artikelID) throws JsonProcessingException, ClassNotFoundException, SQLException {
		
		DatabaseHandler dbHandler = new DatabaseHandler();
		ObjectMapper objectMapper = new ObjectMapper();
		dbHandler.connectDb();
		Artikel[] artikel = dbHandler.leseEinenArtikel(artikelID);
		dbHandler.closeDb();
		String artikelJSON = objectMapper.writeValueAsString(artikel);
		
		return artikelJSON;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getArtikel() throws JsonProcessingException, ClassNotFoundException, SQLException {
		
		DatabaseHandler dbHandler = new DatabaseHandler();
		ObjectMapper objectMapper = new ObjectMapper();
		dbHandler.connectDb();
		Artikel[] artikel = dbHandler.leseAlleArtikel();
		dbHandler.closeDb();
		String artikelJSON = objectMapper.writeValueAsString(artikel);
		
		return artikelJSON;
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String createArtikel(
//			@FormParam("artikelid") String _artikelID,
//			@FormParam("bezeichnung") String bezeichnung,
//			@FormParam("lagerbestand") String _lagerbestand,
//			@FormParam("preis") String _preis) 
//					throws ClassNotFoundException, SQLException, JsonProcessingException {
//
//		int artikelID = Integer.parseInt(_artikelID);
//		int lagerbestand = Integer.parseInt(_lagerbestand);
//		double preis = Double.parseDouble(_preis);
//		
//		Artikel artikel = new Artikel(artikelID, bezeichnung, lagerbestand, preis);
//		
//		DatabaseHandler dbHandler = new DatabaseHandler();
//		ObjectMapper objectMapper = new ObjectMapper();
//		
//		dbHandler.connectDb();
//		try {
//			dbHandler.fuegeArtikelEin(artikel);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return "";
//		}
//		
//		System.out.println("wrote artikel");
//		dbHandler.closeDb();
//		String artikelJSON = objectMapper.writeValueAsString(artikel);
//		System.out.println(artikelJSON);
//		
//		return artikelJSON;
//
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createArtikel(Artikel artikel) 
					throws ClassNotFoundException, SQLException, JsonProcessingException {
		
		DatabaseHandler dbHandler = new DatabaseHandler();
		ObjectMapper objectMapper = new ObjectMapper();
		
		dbHandler.connectDb();
		try {
			dbHandler.fuegeArtikelEin(artikel);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.CONFLICT).build();
		}
		
		System.out.println("wrote artikel");
		dbHandler.closeDb();
		String artikelJSON = objectMapper.writeValueAsString(artikel);
		System.out.println(artikelJSON);
		
		return Response.status(Response.Status.CREATED).entity(artikelJSON).build();

	}
	
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createArtikel(Artikel artikel) 
//					throws ClassNotFoundException, SQLException, JsonProcessingException {
//		
//		
//		System.out.println("got: " + artikel);
//		
//		return Response.status(Response.Status.CREATED).entity(artikel).build();
//
//	}

}