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
	private static final String URI_Warenkoerbe 
	= REST_URI + "/warenkoerbe";
			

	private Client client = ClientBuilder.newClient();

	public Artikel[] getOneArtikel(int id) {
		Artikel[] artikelArray = 
				client
				.target(URI_Artikel)
				.path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON)
				.get(Artikel[].class);

		return artikelArray;
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
		
		Response response = 
				client
				.target(URI_Artikel)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(artikel, MediaType.APPLICATION_JSON));
		
		return response;
	}
	//...
}
