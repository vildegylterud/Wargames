package no.ntnu.vildegy.wargames.io;

public class InfantryUnit extends Unit {

    /**
     * Constructor
     *
     * @param name   a short descriptive name
     * @param health value of health, cannot be less than 0
     * @param attack represents the unit´s weapon
     * @param armour defensive value that protects during attack
     */
    public InfantryUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
        this.name = name;
        this.health = health;
        this.attack = 15;
        this.armour = 10;
    }

    @Override
    public int getAttackBonus() {
        int meleeBonus = 2;
        return meleeBonus;
    }

    @Override
    public int getResistBonus() {
        int defenseBonus = 1;
        return defenseBonus;
    }


}