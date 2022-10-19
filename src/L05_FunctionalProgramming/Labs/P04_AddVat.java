package L05_FunctionalProgramming.Labs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Double> numbers = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Double::parseDouble).collect(Collectors.toList());

        Function<Double, Double> vat = number -> number*1.2;
        Consumer<Double> print = word -> System.out.printf("%.2f%n", word);

        System.out.println("Prices with VAT: ");
        numbers.stream().map(vat).forEach(print);

    }
}
