package ch.romix.mimetypetests;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface Service {

    @GET
    @Produces({"application/resourcename-v1+pdf", "application/resourcename-v1+x-java-serialized-object", "application/resourcename-v1+xml", "application/resourcename-v1+json" })
    @Path("/resourcename")
    Response getResource(@HeaderParam("user-agent") String acceptHeader);

}