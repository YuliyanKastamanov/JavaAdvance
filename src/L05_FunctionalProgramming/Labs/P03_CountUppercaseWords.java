package L05_FunctionalProgramming.Labs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> checkUpperCase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = word -> System.out.println(word);

        numbers = numbers.stream().filter(checkUpperCase).collect(Collectors.toList());

        System.out.println(numbers.size());
        numbers.stream().forEach(print);




    }
}
