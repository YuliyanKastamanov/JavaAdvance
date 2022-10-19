package Exam.P03_Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();

    }

    public void addEmployee(Employee employee){
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        boolean isSuccessful = false;

        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                isSuccessful = true;
                break;
            }
        }

        return isSuccessful;
    }

    public Employee getOldestEmployee(){

        Employee oldestEmployee = null;
        int employeeYears = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > employeeYears){
                employeeYears = employee.getAge();
                oldestEmployee = employee;
            }
        }

        return oldestEmployee;
    }

    public Employee getEmployee(String name){

        Employee employee = null;

        for (Employee employee1 : employees) {
            if (employee1.getName().equals(name)){
                employee = employee1;
            }
        }

        return employee;

    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Employees working at Cafe %s:\n", this.name));

        for (Employee employee: employees) {
            stringBuilder.append(employee.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString();


    }
}
