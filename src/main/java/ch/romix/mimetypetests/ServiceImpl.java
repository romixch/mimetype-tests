package ch.romix.mimetypetests;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.net.URL;

/**
 * Created by sx9 on 10/24/16.
 */
@Path("/resourcename")
public class ServiceImpl {

    @GET
    @Produces({"application/resourcename-v1+pdf", "application/resourcename-v1+x-java-serialized-object", "application/resourcename-v1+xml", "application/resourcename-v1+json", "application/resourcename-v1+msexcel", "application/resourcename-v1+csv" })
    public Response getResource(@HeaderParam("Accept") String acceptHeader) {
        if (acceptHeader.endsWith("pdf")) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.pdf");
            StreamingOutput output = new MyStreamingOutput(resource);
            return Response.ok().type(acceptHeader).entity(output).build();
        } else if (acceptHeader.endsWith("csv")) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.csv");
            StreamingOutput output = new MyStreamingOutput(resource);
            return Response.ok().type(acceptHeader).entity(output).build();
        } else if (acceptHeader.endsWith("msexcel")) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.xls");
            StreamingOutput output = new MyStreamingOutput(resource);
            return Response.ok().type(acceptHeader).entity(output).build();
        }
        return Response.ok().type(acceptHeader).entity("produce " + acceptHeader).build();
    }

}

