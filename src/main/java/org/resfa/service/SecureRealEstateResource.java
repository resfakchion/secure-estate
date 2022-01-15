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
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class SecureRealEstateResource {
    @Inject
    public Inparse inparse;

    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllEstate() throws IOException {
        List<String> result = Arrays.stream(District.values()).map(x -> x.getFileName() + " район").collect(Collectors.toList());
        List<ParserResponse> collect = Arrays.stream(District.values())
                .map(x -> inparse.getData(x))
                .collect(Collectors.toList());
        int place = 1;
        for (int i = 0; i < collect.size(); i++) {
            result.add(place, collect.get(i).data.toString());
            place = place + 1 + i;
        }
        return Response.ok().type("application/json").entity(collect).build();
    }

    @Path("/districts")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getDistricts() throws IOException {
        List<String> collect = Arrays.stream(District.values()).map(x -> x.getNumber() + " - " + x.getName()).collect(Collectors.toList());
        return Response.ok().type("application/json").entity(collect).build();
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptionalEstate(@PathParam String id, SecureRealEstateRequest request) throws Exception {
        District district = Arrays.stream(District.values())
                .filter(x -> x.getNumber() == Integer.parseInt(id))
                .findFirst()
                .orElseThrow();
        ParserResponse data = inparse.getData(district);
        return Response.ok().type("application/json").entity(data.data).build();
    }

}
