package no.ntnu.vildegy.wargames;

public abstract class Unit {

    private String name;
    private int health;
    private int attack;
    private int armour;

    /** Constructor
     *
     * @param name a short descriptive name
     * @param health value of health, cannot be less than 0
     * @param attack represents the unit´s weapon
     * @param armour defensive value that protects during attack
     */
    public Unit(String name, int health, int attack, int armour) {
        this.name = name;
        this.attack = attack;
        this.armour = armour;
        // call Setter method from within constructor
        this.setHealth(health);
    }

    public void attack(Unit opponent) {
        opponent.setHealth(opponent.getHealth() - (this.attack + this.getAttackBonus()) + (opponent.getArmour() + opponent.getResistBonus()));
    };

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmour() {
        return armour;
    }

    public void setHealth(int health) {
        if(health >= 0)  {
            this.health = health;
        } else {
            throw new IllegalArgumentException("Health cant be set to less then 0");
        }


    }


    //TODO: endre tekslig beskrivelse
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armour=" + armour +
                '}';
    }

    public abstract int getAttackBonus();
    public abstract int getResistBonus();

}
