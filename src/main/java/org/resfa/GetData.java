package org.resfa;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import okhttp3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetData {
    public static void main(String[] args) throws IOException {
        GetData getData = new GetData();
        Path path = Paths.get("src/main/resources/polygons/admiralteisky.txt");

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        Response response = getData.polygonRequest(line);
        String string = response.body().string();
        Gson gson = new Gson();
        Object object = gson.fromJson(string,Object.class);
        List<LinkedTreeMap<String, Object>> linkedTreeMaps = new ArrayList<>();
        linkedTreeMaps = (List<LinkedTreeMap<String, Object>>) ((LinkedTreeMap) object).get("data");
        System.out.println(object);
    }

    public Response polygonRequest(String polygon) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("cityId", "1,2")
                .add("sourceId", "1,2")
                .add("polygon", polygon)
                .add("categoryId","1,2,3,4")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept","application/json")
                .url("https://inpars.ru/api/v2/estate?access-token=fhGZ5Fq5q1U6jWAd3FPAHdAKsNwWkHEc")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        return call.execute();
    }
}
