package L05_FunctionalProgramming.Labs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Predicate<Integer> predicate = e -> e % 2 == 0;
        Function<String, Integer> toInt =  Integer::parseInt;
        Function<Integer, String> toString = Object::toString;



        numbers  = numbers.stream()
                .map(toInt)
                .filter(predicate)
                .map(toString).collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

        numbers = numbers.stream()
                .map(toInt)
                .sorted((Integer::compareTo))
                .map(toString).collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));
    }

}
