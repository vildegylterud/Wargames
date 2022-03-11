package no.ntnu.vildegy.wargames.io.Units;

public abstract class Unit {

    protected String name;
    protected int health;
    protected int attack;
    protected int armour;

    public int timesAttacked;

    /** Constructor
     *
     * @param name a short descriptive name
     * @param health value of health, cannot be less than 0
     * @param attack represents the unit´s weapon
     * @param armour defensive value that protects during attack
     */
    public Unit(String name, int health, int attack, int armour) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Name can not be empty");
        if (health <= 0) throw new IllegalArgumentException("Health can not be less then, or 0");
        this.name = name;
        this.attack = attack;
        this.armour = armour;
        // call Setter method from within constructor
        this.setHealth(health);
    }


    /**x
     * Method that finds the health of the opponent after attacking the unit
     * Adds a counter that counts how many
     *
     * @param opponent,the one who is attacked
     */
    public void attack(Unit opponent) {
        opponent.setHealth(opponent.getHealth()
                - (this.attack + this.getAttackBonus())
                + (opponent.getArmour()
                + opponent.getResistBonus()));
        opponent.timesAttacked++;
    }

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

    /**
     * Set method for health value
     *
     * @param health cant be set to less than zero
     * if so, illegal argument exception will be thrown
     */
    public void setHealth(int health) {
            this.health = health;
    }

    @Override
    public String toString() {
        return "Unit: " +
                "Name: '" + name +  "\n" +
                "Health: " + health + "\n" +
                "Attack: " + attack + "\n" +
                "Armour: " + armour;
    }

    public abstract int getAttackBonus();
    public abstract int getResistBonus();

}
