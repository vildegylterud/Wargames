package no.ntnu.vildegy.wargames;

public class CavarlyUnit extends Unit {


    /**
     * Constructor
     *
     * @param name   a short descriptive name
     * @param health value of health, cannot be less than 0
     * @param attack represents the unit´s weapon
     * @param armour defensive value that protects during attack
     */
    public CavarlyUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    public CavarlyUnit(String name, int health) {
        super(name, health, 20, 12);
        this.name = name;
        this.health = health;
        this.attack = 20;
        this.armour = 12;


    }
    @Override
    public int getAttackBonus() {
        int chargeBonus = 6;
        int melee = 2;

        //først attack -> returner chargeBonus + melee
        //attack > 1 -> sett chargebonus = 0;
        return chargeBonus + melee;
    }

    @Override
    public int getResistBonus() {
        int meleeBonus = 1;
        return meleeBonus;
    }
}
