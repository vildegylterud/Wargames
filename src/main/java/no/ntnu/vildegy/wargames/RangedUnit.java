package no.ntnu.vildegy.wargames;

public class RangedUnit extends Unit {


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
        this.name = name;
        this.health = health;

        this.attack = 15;
        this.armour = 8;
    }

    //TODO: lag metode
    public boolean isAttacket() {
        return null;
    }


    @Override
    public int getAttackBonus() {
        return rangeBonus;
    }

    //TODO: lag metoden
    @Override
    public int getResistBonus() {
        int distanceDefense = 6;

        //hvis attack fra fiende =* 1
        //returner distanceDefense

        //hvis attack fra fiende

        Unit fiende = null;
        RangedUnit enhet = null;

        if(enhet.isAttacket()) {
            distanceDefense -= 2;
        }
        return distanceDefense;
    }

}



