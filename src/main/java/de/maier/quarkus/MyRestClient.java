package de.maier.quarkus;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080/")
public interface MyRestClient {
    @GET
    @Path("/timestamp")
    @Produces(MediaType.APPLICATION_JSON)
    Timestamp getTimestamp();

    @GET
    @Path("/timestamp")
    @Produces(MediaType.APPLICATION_JSON)
    Response getContent();
}
