package de.maier.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/timestamp")
public class TimestampResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Timestamp timestamp(){
        return new Timestamp(LocalDateTime.now());
    }
}
