package L03_SetsAndMapsAdvanced.Labs;

import java.util.*;
import java.util.stream.Collectors;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();


        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {

            double currentNumber = input[i];

            if (!numbers.containsKey(currentNumber)){
                numbers.put(currentNumber, 1);
            }else {
                int count = numbers.get(currentNumber);
                count++;
                numbers.put(currentNumber, count);
            }

        }

        for (Double number : numbers.keySet()) {

            System.out.printf("%.1f -> %d%n", number, numbers.get(number));
        }

       // for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
       //     System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
       //
       // }
    }
}
