package no.ntnu.vildegy.wargames.io.Units;

import no.ntnu.vildegy.wargames.io.Units.Unit;

public class RangedUnit extends Unit {

    int distanceDefense;
    int rangeBonus = 3;

    /**
     * Constructor
     *
     * @param name   a short descriptive name
     * @param health value of health, cannot be less than 0
     * @param attack represents the unit´s weapon
     * @param armour defensive value that protects during attack
     */
    public RangedUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    @Override
    public int getAttackBonus() {
        return rangeBonus;
    }


    /**
     *
     * @return a int distancedefence depending on
     * the counter timesAttacked in Unit attack() method
     */
    @Override
    public int getResistBonus() {
        if (timesAttacked == 1) {
            distanceDefense = 6;
        } else if (timesAttacked == 2) {
            distanceDefense = 4;
        } else if(timesAttacked >= 3){
            distanceDefense = 2;
        }
        return distanceDefense;
    }

    public String getType() {
        return "RangedUnit" ;
    }

}



