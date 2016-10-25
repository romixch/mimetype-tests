package ch.romix.mimetypetests;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.net.URL;

@Path("/simple")
public class SimpleRest {

    @GET
    @Path("/pdf")
    @Produces({"application/pdf"})
    public Response getPdf() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.pdf");
        StreamingOutput output = new MyStreamingOutput(resource);
        return Response.ok(output).type("application/pdf").header("Content-Disposition", "inline; filename=\"sample.pdf\"").build();
    }

    @GET
    @Path("/xls")
    @Produces({"application/msexcel"})
    public Response getXls() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.xls");
        StreamingOutput output = new MyStreamingOutput(resource);
        return Response.ok(output).type("application/msexcel").header("Content-Disposition", "inline; filename=\"sample.xls\"").build();
    }

    @GET
    @Path("/csv")
    @Produces({"application/csv" })
    public Response getCsv() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.csv");
        StreamingOutput output = new MyStreamingOutput(resource);
        return Response.ok(output).type("application/csv").header("Content-Disposition", "inline; filename=\"sample.csv\"").build();
    }

}