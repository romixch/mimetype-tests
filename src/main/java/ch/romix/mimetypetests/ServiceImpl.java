package ch.romix.mimetypetests;


import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
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
        StreamingOutput output;
        if (acceptHeader.endsWith("pdf")) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.pdf");
            output = new MyStreamingOutput(resource);
        } else if (acceptHeader.endsWith("csv")) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.csv");
            output = new MyStreamingOutput(resource);
        } else if (acceptHeader.endsWith("msexcel")) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.xls");
            output = new MyStreamingOutput(resource);
        } else {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.txt");
            output = new MyStreamingOutput(resource);
        }
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);
        return Response.ok().type(acceptHeader).entity(output).cacheControl(cacheControl).build();
    }

}

