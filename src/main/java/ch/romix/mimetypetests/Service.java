package ch.romix.mimetypetests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface Service {

    @GET
    @Produces({"application/resourcename-v1+pdf", "application/resourcename-v1+x-java-serialized-object", "application/resourcename-v1+xml", "application/resourcename-v1+json" })
    @Path("/resourcename")
    Response getResource();

}