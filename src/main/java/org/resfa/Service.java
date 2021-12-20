package org.resfa;

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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public static void main(String[] args) throws IOException {
        Service service = new Service();
        List<String> districts = service.getDistricts();
        for (String district : districts) {
            var polygon = service.getPolygon(district);
            polygon = service.sizeReduction(polygon);
            service.writeCoordinates(polygon, district);
        }
    }

    public List<String> getPolygon(String pathName) throws IOException {
        Path path = Paths.get(String.format("src/main/resources/polygons/%s", pathName));

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        return Arrays.stream(line.replaceAll(" ", ",")
                .replace(")", "")
                .replace("(", "")
                .split(",")).toList();
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
