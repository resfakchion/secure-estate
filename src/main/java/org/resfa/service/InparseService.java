package org.resfa.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.apache.http.client.methods.RequestBuilder;
import org.resfa.pojo.District;
import org.resfa.pojo.ParserResponse;
import org.resfa.request.SecureRealEstateRequest;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;


@ApplicationScoped
public class InparseService {
    public ParserResponse getData(District district) throws IOException {
        InparseService getData = new InparseService();
        Response response = getData.polygonRequest(getPolygon(district));
        String string = Objects.requireNonNull(response.body()).string();
        Gson gson = new Gson();
        return gson.fromJson(string, ParserResponse.class);
    }

    public ParserResponse optionalRequest(SecureRealEstateRequest request) throws IOException {
        InparseService getData = new InparseService();
        District district = Arrays.stream(District.values())
                .filter(x -> x.getNumber() == request.getDistrict())
                .findFirst()
                .orElseThrow();
        Response response = getData.optionalPolygonRequest(request,getPolygon(district));
        String string = Objects.requireNonNull(response.body()).string();
        Gson gson = new Gson();
        return gson.fromJson(string, ParserResponse.class);
    }


    public String getPolygon(District district) {
        try {
            Path path = Paths.get(String.format("src/main/resources/polygons/%s", district.getFileName()));
            BufferedReader reader = Files.newBufferedReader(path);
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response polygonRequest(String polygon) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("cityId", "2")
                .add("sourceId", "1,2")
                .add("polygon", polygon)
                .add("categoryId", "1,2,3,4")
                .add("limit", "20")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url("https://inpars.ru/api/v2/estate?access-token=fhGZ5Fq5q1U6jWAd3FPAHdAKsNwWkHEc")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        return call.execute();
    }

    public Response optionalPolygonRequest(SecureRealEstateRequest realEstateRequest, String polygon) throws IOException {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBody = new FormBody.Builder()
                .add("cityId", "2")
                .add("sourceId", "1,2")
                .add("polygon", polygon);
        if (realEstateRequest.getCostMin() != 0) {
            formBody.add("costMin", String.valueOf(realEstateRequest.getCostMin()));
        }
        if (realEstateRequest.getCostMax() != 0) {
            formBody.add("costMax", String.valueOf(realEstateRequest.getCostMax()));
        }
        if (realEstateRequest.getFloorMin() != 0) {
            formBody.add("floorMin", String.valueOf(realEstateRequest.getFloorMin()));
        }
        if (realEstateRequest.getFloorMax() != 0) {
            formBody.add("floorMax", String.valueOf(realEstateRequest.getFloorMax()));
        }
        if (realEstateRequest.getCountFlat() != null) {
            formBody.add("categoryId", String.valueOf(realEstateRequest.getCountFlat()));
        }
        /*if (realEstateRequest.getLimit() != 0) {
            formBody.add("limit", String.valueOf(realEstateRequest.getLimit()));
        }*/

        FormBody post = formBody.build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url("https://inpars.ru/api/v2/estate?access-token=fhGZ5Fq5q1U6jWAd3FPAHdAKsNwWkHEc")
                .post(post)
                .build();

        Call call = client.newCall(request);
        return call.execute();
    }
}
