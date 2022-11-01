package de.maier.quarkus;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Slf4j
public class QuarkusHangingRestClientResource {

    @Inject
    @RestClient
    MyRestClient myRestClient;

    @GET
    @Path("timestamp-response")
    @Produces(MediaType.TEXT_PLAIN)
    public String timestamp() {
        for (int i = 0; i < 500; i++) {
            Timestamp timestamp = myRestClient.getTimestamp();
            log.debug("response: " + timestamp);
            log.debug("call number: " + (i + 1));
        }
        return "successfully called timestamp endpoint 500 times";
    }

    @GET
    @Path("close-response")
    @Produces(MediaType.TEXT_PLAIN)
    public String closeResponse() {
        for (int i = 0; i < 500; i++) {
            Response response = myRestClient.getContent();
            response.close();
            log.debug("call number: " + (i + 1));
        }
        return "successfully called timestamp endpoint 500 times";
    }

    @GET
    @Path("response-not-closed")
    @Produces(MediaType.TEXT_PLAIN)
    public String response() {
        for (int i = 0; i < 500; i++) {
            Response response = myRestClient.getContent();
            log.debug("call number: " + (i + 1));
        }
        return "successfully called timestamp endpoint 500 times";
    }
}
