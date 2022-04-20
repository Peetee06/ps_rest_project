package de.noltetrost.ps_rest_client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Artikel;

public class RestClient {
	private static final String REST_URI 
	= "http://localhost:8080/ps_rest/webapi";
	private static final String URI_Artikel 
	= REST_URI + "/artikel";
			

	private Client client = ClientBuilder.newClient();

	public Artikel getOneArtikel(int id) {
		Artikel[] artikelArray = 
				client
				.target(URI_Artikel)
				.path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON)
				.get(Artikel[].class);

		return artikelArray[0];
	}
	
	public Artikel[] getAllArtikel() {
		Artikel[] artikelArray = 
				client
				.target(URI_Artikel)
				.request(MediaType.APPLICATION_JSON)
				.get(Artikel[].class);

		return artikelArray;
	}
	
	public Response postArtikel(Artikel artikel) {
		System.out.println("posting Artikel");
		Response response = 
				client
				.target(URI_Artikel)
				.request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(artikel, MediaType.APPLICATION_JSON));
		System.out.println("response: " + response);
		return response;
	}
	
}
