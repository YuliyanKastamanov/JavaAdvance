package L06_DefiningClasses.Exercises.P02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> employeeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            Employee currentEmployee = null;
            if (data.length == 4){
                currentEmployee = new Employee(name, salary, position, department);

            }else if(data.length == 6){
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                currentEmployee = new Employee(name, salary, position, department, email, age);
            }else if (data.length == 5){
                String element5 = data[4];

                if(element5.contains("@")){
                    currentEmployee = new Employee(name, salary, position, department, element5);
                }else {
                    int age = Integer.parseInt(element5);
                    currentEmployee = new Employee(name, salary, position, department, age);
                }
            }

            if (!employeeMap.containsKey(department)) {
                //отдел -> празен списък
                List<Employee> currentList = new ArrayList<>();
                currentList.add(currentEmployee);
                employeeMap.put(department, currentList);

            }else {
                employeeMap.get(department).add(currentEmployee);
            }

        }

        String maxDepartmentSalary = employeeMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get() //entry (отдел -> списък със служителите): отделът с най-висока заплата
                .getKey();

        System.out.println("Highest Average Salary: " + maxDepartmentSalary);

        List<Employee> employeesWithMaxSalary = employeeMap.get(maxDepartmentSalary);

        employeesWithMaxSalary.sort(Comparator.comparingDouble(Employee::getSalary));
        Collections.reverse(employeesWithMaxSalary);

        for (Employee employee : employeesWithMaxSalary) {

            System.out.println(employee);

        }


    }

    private static double getAverageSalary(List<Employee> employees) {

        double sum = 0;
        for (Employee employee : employees ) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
