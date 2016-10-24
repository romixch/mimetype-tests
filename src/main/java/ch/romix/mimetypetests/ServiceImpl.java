package ch.romix.mimetypetests;

import javax.ws.rs.core.Response;

/**
 * Created by sx9 on 10/24/16.
 */
public class ServiceImpl implements Service {

    public Response getResource(String acceptHeader) {
        return Response.ok("produce " + acceptHeader).type(acceptHeader).build();
    }
}
