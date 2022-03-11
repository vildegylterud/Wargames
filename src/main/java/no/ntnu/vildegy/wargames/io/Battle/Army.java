package no.ntnu.vildegy.wargames.io.Battle;

import no.ntnu.vildegy.wargames.io.Units.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;


public class Army {

    private String name;
    private ArrayList<Unit> units;


    public Army(String name) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Name can not be empty");
        this.name = name;
    }

    public Army(String name, ArrayList<Unit> units) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Name can not be empty");
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    /**
     * Method for adding a unit to the list of units
     * @param unit
     */
    public void add(Unit unit) {
        if(!units.contains(unit))
        units.add(unit);
    }

    /**Method for adding a new list inside a already existing list
     *
     * @param unitsList arraylist with units
     */
    public void addAllUnits(ArrayList<Unit> unitsList) {
        for (Unit unit : unitsList) {
            add(unit);
        }
    }

    /**Method that removes a unit from the list unitlist
     *
     * @param unit, the unit that we want to remove
     */
    public void remove(Unit unit) {
        units.remove(unit);
    }

    /**
     * Checks if the list of units is empty
     * @return true is the list is not empty
     */
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
     * Get all infantryUnits in the Army.
     *
     * Checks if the unit in army is an instance of InfantryUnit
     *
     * @return An array list consisting of infantryUnits in the army.
     */
    public ArrayList<Unit> getInfantryUnits() {
        return (ArrayList<Unit>) getAllUnits().stream()
                .filter(unit -> unit instanceof InfantryUnit)
                .collect(Collectors.toList());
    }

    /**
     * Get all cavarlyUnits in the Army.
     *
     * Checks if the unit in army is an instance of cavarlyUnits and that its not
     * an instance of commanderunit
     *
     * @return An array list consisting of cavarlyUnits in the army.
     */
    public ArrayList<Unit> getCavarlyUnits() {

        return (ArrayList<Unit>) getAllUnits().stream()
                .filter(unit -> unit instanceof CavarlyUnit)
                .filter(unit -> !(unit instanceof CommanderUnit))
                .collect(Collectors.toList());
    }

    /**
     * Get all rangedUnits in the Army.
     *
     * Checks if the unit in army is an instance of rangesUnits
     *
     * @return An array list consisting of rangedUnits in the army.
     */
    public ArrayList<Unit> getRangedUnits() {
        return (ArrayList<Unit>) getAllUnits().stream()
                .filter(unit -> unit instanceof RangedUnit)
                .collect(Collectors.toList());

    }

    /**
     * Get all commanderUnits in the Army.
     *
     * Checks if the unit in army is an instance of commanderUnits
     *
     * @return An array list consisting of commanderUnits in the army.
     */
    public ArrayList<Unit> getCommanderUnits() {
        return (ArrayList<Unit>) getAllUnits().stream()
                .filter(unit -> unit instanceof CommanderUnit)
                .collect(Collectors.toList());
    }


    /**
     *
     * @return a random Unit form the Unit list
     */
    public Unit getRandom() {
        if(hasUnits())
            return units.get(new Random().nextInt(units.size()));
        return null;
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
        if (!(o instanceof Army)) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }

}
