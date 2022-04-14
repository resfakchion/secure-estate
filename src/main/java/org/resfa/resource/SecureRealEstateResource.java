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
        /*ArrayList<ArrayList<Object>> response = new ArrayList<>();
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
        return Response.ok().type("application/json").entity(response).build();*/
        return null;
    }

    @Path("/districts")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getDistricts() throws IOException {
        List<String> collect = Arrays.stream(District.values()).map(x -> x.getNumber() + " - " + x.getName()).collect(Collectors.toList());
        return Response.ok().type("application/json").entity(collect).build();
    }


    @GET
    @Path("/district/{id}")
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

    @POST
    @Path("/district")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public TemplateInstance testMap(SecureRealEstateRequest request) throws Exception {
        ParserResponse realEstates = inparseService.optionalRequest(request);
        return mapService.createMap(realEstates.data);
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance mainPage() throws Exception {
        return mapService.mainPage();
    }

    @POST
    @Path("/test")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public TemplateInstance test() throws Exception {
        RealEstate estate = new RealEstate();
        estate.setId("1");
        estate.setName("1");
        estate.setLat("59.931");
        estate.setLng("30.331");
        estate.setTitle("Первая точка");
        ArrayList<String> images = new ArrayList<>();
        images.add("https://22.img.avito.st/640x480/8845088222.jpg");
        images.add("https://63.img.avito.st/640x480/8845089163.jpg");
        images.add("https://31.img.avito.st/640x480/8845089631.jpg");
        estate.setImages(images);
        RealEstate estate2 = new RealEstate();
        estate2.setId("2");
        estate2.setTitle("2-к квартира, 55 м²");
        estate2.setFloor(3);
        estate2.setAddress("Санкт-Петербург, Садовая улица дом 28");
        estate2.setLat("59.93026542043342");
        estate2.setLng("30.326776285506025");
        estate2.setText("Арт. 48210565 Срочная продажа квартиры в центре Петербурга. Рядом 5 станций метро. Только наличные средства. Тихий двор. Есть место для парковки во дворе. Квартира правильной прямоугольной формы. Нет несущих стен внутри квартиры - можете делать ремонт с любой перепланировкой под себя. Высота потолков - 3,2 м. Остались вопросы? - звоните, расскажу подробнее.");
        estate2.setImages(images);
        estate2.setName("Александр");
        estate2.setCost(BigDecimal.valueOf(14000000));
        ArrayList<String> phones = new ArrayList<>();
        phones.add("+79101513151");
        estate2.setPhones(phones);
        estate2.setSqLand(49.2);
        estate2.setUrl("https://spb.domclick.ru/card/sale__flat__1436517577");
        ArrayList<RealEstate> estates = new ArrayList<>();
        estates.add(estate2);
        estates.add(estate);
        return mapService.createMap(estates);
    }

}
