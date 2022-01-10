package org.resfa.service;


import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.resfa.exception.SecureRealEstateRequest;
import org.resfa.pojo.District;
import org.resfa.pojo.ParserResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class SecureRealEstateResource {
    @Inject
    public GetData getData;


    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllEstate(@PathParam String id) throws IOException {
        District district = Arrays.stream(District.values())
                .filter(x -> x.getNumber() == Integer.parseInt(id))
                .findFirst()
                .orElseThrow();
        ParserResponse data = getData.getData(district);
        return Response.ok().type("application/json").entity(data.data).build();
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptionalEstate(@PathParam String id, SecureRealEstateRequest request) throws IOException {
        District district = Arrays.stream(District.values())
                .filter(x -> x.getNumber() == Integer.parseInt(id))
                .findFirst()
                .orElseThrow();
        ParserResponse data = getData.getData(district);
        return Response.ok().type("application/json").entity(data.data).build();
    }

}
