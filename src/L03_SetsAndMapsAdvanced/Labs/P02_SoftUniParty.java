package L03_SetsAndMapsAdvanced.Labs;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        while (!input.equals("PARTY")){
            char firstChar = input.charAt(0);

            if (firstChar > 47 && firstChar < 58){
                vipGuests.add(input);

            }else {
                regularGuests.add(input);
            }
            input = scanner.nextLine();


        }

        String command = scanner.nextLine();

        while (!command.equals("END")){

            if(vipGuests.contains(command)){
                vipGuests.remove(command);
            }else if(regularGuests.contains(command)){
                regularGuests.remove(command);
            }



            command = scanner.nextLine();
        }

        int count = vipGuests.size() + regularGuests.size();
        System.out.println(count);

        if(!vipGuests.isEmpty()) {
            vipGuests.stream().forEach(entry -> System.out.println(entry));
        }
        if (!regularGuests.isEmpty()){
            regularGuests.stream().forEach(entry -> System.out.println(entry));
        }
    }
}
