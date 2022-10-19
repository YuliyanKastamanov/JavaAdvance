package L06_DefiningClasses.Labs.P01_CarInfo;

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
            String name = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);

            Car currentCar = new Car(name, model, horsePower);
            cars.add(currentCar);

        }

        for (Car car : cars) {
            System.out.println(car.CarInfo());
        }

    }
}
