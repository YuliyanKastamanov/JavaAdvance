package L05_FunctionalProgramming.Labs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(",\\s+");
            String currentName = data[0];
            int currentAge = Integer.parseInt(data[1]);
            people.put(currentName, currentAge);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;

        if(condition.equals("younger")){
            filterPredicate = (personAge, age) -> personAge <= age;
        }else {
            filterPredicate = (personAge, age) -> personAge >= age;
        }


        Consumer<Map.Entry<String, Integer>> printConsumer;

        if (format.equals("age")){
            printConsumer = person -> System.out.println(person.getValue());
        } else if(format.equals("name")){
            printConsumer = person -> System.out.println(person.getKey());

        }else {
            printConsumer = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }

        people.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageLimit))
                .forEach(printConsumer);
    }
}
