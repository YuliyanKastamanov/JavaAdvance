package L03_SetsAndMapsAdvanced.Labs;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int round = 0; round < 50; round++) {

            if(firstPlayer.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            if(secondPlayer.isEmpty()){
                System.out.println("First player win!");
                return;
            }
            int firstPlayerNumber = firstPlayer.iterator().next();
            int secondPlayerNumber = secondPlayer.iterator().next();
            firstPlayer.remove(firstPlayerNumber);
            secondPlayer.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber){
                firstPlayer.add(firstPlayerNumber);
                firstPlayer.add(secondPlayerNumber);

            }else if(secondPlayerNumber > firstPlayerNumber){
                secondPlayer.add(firstPlayerNumber);
                secondPlayer.add(secondPlayerNumber);
            }

        }

        if(firstPlayer.size() >  secondPlayer.size()){
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
