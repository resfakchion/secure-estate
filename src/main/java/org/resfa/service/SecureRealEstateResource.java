package org.resfa.service;


import org.resfa.pojo.District;
import org.resfa.pojo.ParserResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class SecureRealEstateResource {
    @Inject
    public GetData getData;


    @Path("/moscow")
    @GET
    public Response getAllBooks() throws IOException {
        ParserResponse data = getData.getData(District.Moskovsky);
        return Response.ok(data.data).build();
    }

}
