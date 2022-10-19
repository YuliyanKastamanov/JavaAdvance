package L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int number = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> filter = e -> e % number == 0;


        Collections.reverse(numbers);
        numbers.removeIf(filter);
        numbers.stream().forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }
}
