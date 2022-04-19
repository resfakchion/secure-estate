package org.resfa.service;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@ApplicationScoped
public class Service {

    public List<String> switchCoords(List<String> polygons) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < polygons.size() - 1; i = i + 2) {
            result.add(polygons.get(i + 1));
            result.add(polygons.get(i));
        }
        return result;
    }

    public List<String> getPolygon(String pathName) throws IOException {
        Path path = Paths.get(String.format("src/main/resources/polygons/%s", pathName));

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        return Arrays.stream(line.replaceAll(" ", ",")
                .replace(")", "")
                .replace("(", "")
                .split(",")).collect(Collectors.toList());
    }

    public void writeCoordinates(List<String> result, String pathName) throws IOException {

        Path path = Paths.get(String.format("src/main/resources/polygons/%s", pathName));

        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        writer.write(String.join(",", result));
        writer.flush();
        writer.close();

    }

    public List<String> sizeReduction(List<String> strings) {
        while (strings.size() > 1200) {
            List<String> result = new ArrayList<>(strings);
            double temp = strings.size() - 1100;
            int number = (int) Math.ceil(strings.size() / temp);
            int start = number % 2 == 0 ? number : number + 1;
            for (int i = start; i < strings.size() - number * 2; i = i + (number * 2)) {
                result.set(i, "");
                result.set(i + 1, "");
            }
            strings = result.stream().filter(x -> !x.equals(""))
                    .collect(Collectors.toList());
        }
        return strings;
    }

    public String prepareFlat(String request) {
        if (request.length() < 1) {
            return request;
        }
        List<Integer> collect = Arrays.stream(request.split("")).map(Integer::parseInt).collect(Collectors.toList());
        if (collect.contains(1)) {
            collect.add(28);
        }
        if (collect.contains(2)) {
            collect.add(29);
        }
        if (collect.contains(3)) {
            collect.add(30);
        }
        if (collect.contains(4)) {
            collect.add(31);
        }
        return collect.stream().map(x -> "," + x).collect(Collectors.joining()).substring(1);
    }


    public List<String> getDistricts() {
        List<String> districts = new ArrayList<>();
        districts.add("admiralteisky.txt");
        districts.add("centralnyj.txt");
        districts.add("frunzensky.txt");
        districts.add("kalininsky.txt");
        districts.add("kirovsky.txt");
        districts.add("kolpinsky.txt");
        districts.add("krasnogvardesky.txt");
        districts.add("krasnoselsky.txt");
        districts.add("kronstadtsky.txt");
        districts.add("kurortnyj.txt");
        districts.add("moskovsky.txt");
        districts.add("nevsky.txt");
        districts.add("petrodvorcovyj.txt");
        districts.add("petrogradsky.txt");
        districts.add("primorsky.txt");
        districts.add("pushkinsky.txt");
        districts.add("vasileostrovsky.txt");
        districts.add("vyborgsky.txt");
        return districts;
    }


}
