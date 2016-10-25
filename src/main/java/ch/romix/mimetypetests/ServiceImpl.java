package ch.romix.mimetypetests;


import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by sx9 on 10/24/16.
 */
@Path("/resourcename")
public class ServiceImpl {

    @GET
    @Produces({"application/resourcename-v1+pdf", "application/resourcename-v1+x-java-serialized-object", "application/resourcename-v1+xml", "application/resourcename-v1+json" })
    public Response getResource(@HeaderParam("Accept") String acceptHeader) {
        return Response.ok().type(acceptHeader).entity("produce " + acceptHeader).build();
    }
}
