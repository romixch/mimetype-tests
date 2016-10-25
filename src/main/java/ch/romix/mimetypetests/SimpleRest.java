package ch.romix.mimetypetests;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/simple")
public class SimpleRest {

    @GET
    @Produces("text/plain")
    public Response getResource(@HeaderParam("user-agent") String acceptHeader) {
        return Response.ok("The simple resource seams to work", "text/plain").build();
    }

}