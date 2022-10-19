package L03_SetsAndMapsAdvanced.Labs;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Set<String> carParking = new LinkedHashSet<>();


        while (!line.split(", ")[0].equals("END")){
            String command = line.split(", ")[0];

            String carNumber = line.split(", ")[1];

            if (command.equals("IN")){
                carParking.add(carNumber);

            }else if(command.equals("OUT")){
                carParking.remove(carNumber);

            }




            line = scanner.nextLine();
        }

        if (carParking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car: carParking) {
                System.out.println(car);
            }
        }

    }
}
