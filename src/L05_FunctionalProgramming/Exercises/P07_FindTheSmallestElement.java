package L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //indexOf -> връща първия индекс, на който срещаме елемента
        //lastIndexOf -> връща последния индекс, на който срещаме елемента

        Function<List<Integer>, Integer> indexOfSmallestNum = numb -> numb.lastIndexOf(Collections.min(numbers));
        System.out.println(indexOfSmallestNum.apply(numbers));





    }
}