package org.resfa.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.resfa.pojo.District;
import org.resfa.pojo.ParserResponse;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


@ApplicationScoped
public class Inparse {
    public ParserResponse getData(District district) {
        Inparse getData = new Inparse();
        try {
        Path path = Paths.get(String.format("src/main/resources/polygons/%s", district.getFileName()));
        BufferedReader reader = null;

            reader = Files.newBufferedReader(path);

        String line = reader.readLine();
        Response response = getData.polygonRequest(line);
        String string = Objects.requireNonNull(response.body()).string();
        Gson gson = new Gson();
            return gson.fromJson(string, ParserResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response polygonRequest(String polygon) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("cityId", "1,2")
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
}
