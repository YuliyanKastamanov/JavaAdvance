package Exam.P03_Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {


    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {

        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {

        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        boolean isSuccessful = false;

        for (Person person : roster) {
            if (person.getName().equals(name)) {
                roster.remove(person);
                isSuccessful = true;
                break;
            }
        }

        return isSuccessful;
    }

    public Person getPerson(String name, String hometown) {
        Person personName = null;

        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                personName = person;
            }
        }
        return personName;

    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The people in the hotel %s are:\n", this.name));
        for (Person person : roster) {
            stringBuilder.append(person.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
