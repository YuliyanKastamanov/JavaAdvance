package L03_SetsAndMapsAdvanced.Labs;

import java.util.*;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> markets = new TreeMap<>();

        while (!command.equals("Revision")) {

            String currentMarket = command.split(",\\s+")[0];
            String currentProduct = command.split(",\\s+")[1];
            double price = Double.parseDouble(command.split(",\\s+")[2]);
            LinkedHashMap<String, Double> currentList = new LinkedHashMap<>();

            if (!markets.containsKey(currentMarket)) {
                currentList.put(currentProduct, price);
                markets.put(currentMarket, currentList);
            } else {
                currentList = markets.get(currentMarket);
                currentList.put(currentProduct, price);
            }

            command = scanner.nextLine();
        }

        markets.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");


                        entry.getValue().entrySet().stream().forEach(e -> {
                            System.out.printf("Product: %s, Price: %.1f%n", e.getKey(), e.getValue());

                        });



                });
    }
}
