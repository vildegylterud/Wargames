package no.ntnu.vildegy.wargames.io.Units;

public class CavarlyUnit extends Unit {

    /**
     * Constructor, initializing a new CavarlyUnit
     * Inherit from the superclass Unit
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
    }

    /** Method for getting the total bonus (AttackBonus) depending on
     * how many times the Cavarly unit has been attacked
     *
     * after 1 attack, the total bonus is charge bonus + melee
     * from 2 attacks and after the total bonus is the meleee
     *
     * @return the total attack bonus
     */
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


    /**
     * @return the total resist bonus to the cavarly unit
     */
    @Override
    public int getResistBonus() {
        int meleeBonus = 1;
        return meleeBonus;
    }
}
