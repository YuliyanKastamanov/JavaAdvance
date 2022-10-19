package L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        Function<Integer, Integer> funcAdd = e -> e + 1;
        Function<Integer, Integer> funcMultiply = e -> e * 2;
        Function<Integer, Integer> funcSubtract = e -> e - 1;
        Consumer<Integer> print = e -> System.out.printf("%d ", e);

        while (!command.equals("end")){
            if (command.equals("add")){
                numbers = numbers.stream().map(funcAdd).collect(Collectors.toList());
            } else if (command.equals("multiply")){
                numbers = numbers.stream().map(funcMultiply).collect(Collectors.toList());
            }else if(command.equals("subtract")){
                numbers = numbers.stream().map(funcSubtract).collect(Collectors.toList());
            }else if(command.equals("print")){
                numbers.stream().forEach(print);
                System.out.println();
            }



            command = scanner.nextLine();
        }
    }
}
