package Exam.P03_Parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot){
        if (this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }
    public boolean remove(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }
    public int count(){
        return this.data.size();
    }


    public List<Parrot> sellParrotBySpecies(String species){

        List<Parrot> sellParrots = new ArrayList<>();

        for (Parrot parrot: data) {
            if (parrot.getSpecies().equals(species)) {
                sellParrots.add(parrot);

            }

        }
        return sellParrots;
    }

    public Parrot sellParrot(String name){
        Parrot sellParrot = null;
        for (Parrot parrot: data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                sellParrot = parrot;
            }
        }
        return sellParrot;

    }



    public String report(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Parrots available at %s:\n", this.name));

        for (Parrot parrot: data) {
            stringBuilder.append(parrot.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString();

    }

}
