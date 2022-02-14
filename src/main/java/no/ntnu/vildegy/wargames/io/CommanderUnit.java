package no.ntnu.vildegy.wargames.io;

public class CommanderUnit extends CavarlyUnit {


    /**
     * Constructor
     *
     * @param name   a short descriptive name
     * @param health value of health, cannot be less than 0
     * @param attack represents the unit´s weapon
     * @param armour defensive value that protects during attack
     */
    public CommanderUnit(String name, int health, int attack, int armour) {

        super(name, health, attack, armour);
    }

    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }

    @Override
    public int getAttackBonus() {
        return super.getAttackBonus();
    }

    @Override
    public int getResistBonus() {
        return super.getResistBonus();
    }
}
