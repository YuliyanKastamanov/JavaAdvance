package L03_SetsAndMapsAdvanced.Labs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> nestedMap = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            LinkedHashMap<String, List<String>> currentMap = new LinkedHashMap<>();
            List<String> currentListCity = new ArrayList<>();

            if (!nestedMap.containsKey(continent)){
                currentListCity.add(city);
                currentMap.put(country, currentListCity);
                nestedMap.put(continent, currentMap);
            }else {
                currentMap = nestedMap.get(continent);
                if (!currentMap.containsKey(country)){
                    currentListCity.add(city);
                    currentMap.put(country, currentListCity);
                    nestedMap.put(continent, currentMap);
                }
                else {

                    currentListCity = currentMap.get(country);
                    currentListCity.add(city);
                    currentMap.put(country, currentListCity);
                    nestedMap.put(continent, currentMap);

                }
            }

        }

        nestedMap.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");


                    entry.getValue().entrySet().stream().forEach(e -> {
                        System.out.printf("  %s -> ", e.getKey());

                        for (int i = 0; i < e.getValue().size(); i++) {
                            if (i ==0 ){
                                System.out.printf("%s", e.getValue().get(i));
                            }else {
                                System.out.printf(", %s", e.getValue().get(i));
                            }
                        }

                       // e.getValue().stream().forEach(b -> {
                       //     System.out.print(b);
                       // });
                        System.out.println();

                    });



                });


    }
}
