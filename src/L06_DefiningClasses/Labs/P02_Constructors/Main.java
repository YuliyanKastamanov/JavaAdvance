package L06_DefiningClasses.Labs.P02_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car;
            String brand = data[0];
            if (data.length == 1){

                car = new Car(brand);
            }else {
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                car = new Car(brand, model, horsePower);
            }

            cars.add(car);

        }

        cars.forEach(entry -> System.out.println(entry.toString()));



    }
}
