package ch.romix.mimetypetests;

import org.apache.commons.io.IOUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by sx9 on 10/25/16.
 */
class MyStreamingOutput implements StreamingOutput {
    private URL url;

    public MyStreamingOutput(URL url) {
        this.url = url;
    }

    public void write(OutputStream os) throws IOException, WebApplicationException {
        try (InputStream is = url.openStream()) {
            IOUtils.copy(is, os);
        }
    }
}
