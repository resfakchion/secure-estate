package org.resfa.resource;


import io.quarkus.qute.TemplateInstance;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.resfa.pojo.District;
import org.resfa.pojo.ParserResponse;
import org.resfa.pojo.RealEstate;
import org.resfa.request.SecureRealEstateRequest;
import org.resfa.service.InparseService;
import org.resfa.service.MapService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class SecureRealEstateResource {
    @Inject
    public InparseService inparseService;

    @Inject
    MapService mapService;

    @Path("/filter/all")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllEstate(SecureRealEstateRequest request) throws IOException, InterruptedException {
        ArrayList<ArrayList<Object>> response = new ArrayList<>();
        for (District district : District.values()) {
            ArrayList<Object> districtResponse = new ArrayList<>();
            ParserResponse data = inparseService.optionalRequest(request, district);
            BigDecimal averageCostMeter = BigDecimal.valueOf(data.data.stream().mapToDouble(x -> x.cost.doubleValue() / x.sq).average().getAsDouble());
            BigDecimal averageCost = BigDecimal.valueOf(data.data.stream().mapToDouble(x -> x.cost.doubleValue()).average().getAsDouble());
            districtResponse.add(district.getName());
            districtResponse.add(averageCostMeter.setScale(2, RoundingMode.HALF_UP));
            districtResponse.add(averageCost.setScale(2, RoundingMode.HALF_UP));
            response.add(districtResponse);
            if (data.meta.rateRemaining == 1) {
                TimeUnit.SECONDS.sleep(data.meta.rateReset.longValue());
            }
        }
        return Response.ok().type("application/json").entity(response).build();
    }

    @Path("/districts")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getDistricts() throws IOException {
        List<String> collect = Arrays.stream(District.values()).map(x -> x.getNumber() + " - " + x.getName()).collect(Collectors.toList());
        return Response.ok().type("application/json").entity(collect).build();
    }

    @POST
    @Path("/district/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOptionalEstate(@PathParam String id, SecureRealEstateRequest request) throws Exception {
        District district = Arrays.stream(District.values())
                .filter(x -> x.getNumber() == Integer.parseInt(id))
                .findFirst()
                .orElseThrow();
        ParserResponse data = inparseService.optionalRequest(request, district);
        return Response.ok().type("application/json").entity(data.data).build();
    }

    @GET
    @Path("/district//{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOptionalEstate(@PathParam String id) throws Exception {
        District district = Arrays.stream(District.values())
                .filter(x -> x.getNumber() == Integer.parseInt(id))
                .findFirst()
                .orElseThrow();
        ParserResponse data = inparseService.getData(district);
        return Response.ok().type("application/json").entity(data.data).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance testMap() throws Exception {
        RealEstate estate = new RealEstate();
        estate.setName("1");
        estate.setLat("59.931");
        estate.setLng("30.331");
        estate.setTitle("Первая точка");
        ArrayList<String> images = new ArrayList<>();
        images.add("http://img-fotki.yandex.ru/get/6114/82599242.2d6/0_88b97_ec425cf5_M");
        images.add("http://img-fotki.yandex.ru/get/6114/82599242.2d6/0_88b97_ec425cf5_M");
        images.add("http://img-fotki.yandex.ru/get/6114/82599242.2d6/0_88b97_ec425cf5_M");
        estate.setImages(images);
        ArrayList<RealEstate> estates = new ArrayList<>();
        estates.add(estate);
        return mapService.createMap(estates);
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance mainPage() throws Exception {
        return mapService.mainPage();
    }




}
