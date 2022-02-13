package no.ntnu.vildegy.wargames.io;

import java.util.ArrayList;

import java.util.Objects;
import java.util.Random;

public class Army {

    private String name;
    private ArrayList<Unit> units;

    public Army(String name) {
        this.name = name;
    }

    public Army(String name, ArrayList<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void add(Unit unit) {
        units.add(unit);
    }

    /**Method for adding a new list inside a already existing list
     *
     * @param unitsList arraylist with units
     */
    public void addAll(ArrayList<Unit> unitsList) {
        units.addAll(unitsList);
    }

    /**Method that removes a unit from the list unitlist
     *
     * @param unit, the unit that we want to remove
     */
    public void remove(Unit unit) {
        units.remove(unit);
    }

    public boolean hasUnits() {
        if(!units.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<Unit> getAllUnits() {
        return units;
    }


    /**
     *
     * @return a random Unit form the Unit list
     */
    public Unit getRandom() {
        Random rand = new Random();
        return units.get(rand.nextInt(units.size()));
    }


    @Override
    public String toString() {
        return "Army: " +  "\n" +
                "name: '" + name + "\n" +
                "units: " + units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }

}
