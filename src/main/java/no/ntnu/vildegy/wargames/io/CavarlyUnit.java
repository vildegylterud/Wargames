package no.ntnu.vildegy.wargames.io;

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
        int totalBonus = 0;
        int chargeBonus = 4;
        int melee = 2;

        if(timesAttacked == 1) {
            totalBonus = chargeBonus + melee;
        } else if(timesAttacked >= 2) {
            totalBonus = melee;
        }
        return totalBonus;
    }

    @Override
    public int getResistBonus() {
        int meleeBonus = 1;
        return meleeBonus;
    }
}
