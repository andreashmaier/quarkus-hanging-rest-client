# Quarkus Hanging REST Client 
https://adambien.blog/roller/abien/entry/quarkus_hanging_mp_rest_client

## RESTEasy Reactive REST Client

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-rest-client-reactive</artifactId>
</dependency>
```

```
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
```
- http://localhost:8080/timestamp-response
```
    @GET
    @Path("timestamp-response")
    @Produces(MediaType.TEXT_PLAIN)
    public String timestamp() {
        for (int i = 0; i < 500; i++) {
            Timestamp timestamp = myRestClient.getTimestamkp();
            log.debug("response: " + timestamp);
            log.debug("call number: " + (i + 1));
        }
        return "successfully called timestamp endpoint 500 times";
    }
```
- http://localhost:8080/close-response
```
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
```
- http://localhost:8080/response-not-closed
```
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
```
