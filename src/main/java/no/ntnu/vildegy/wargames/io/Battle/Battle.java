package no.ntnu.vildegy.wargames.io.Battle;

import no.ntnu.vildegy.wargames.io.Units.Unit;

import java.util.Objects;
import java.util.Random;

public class Battle {

    private Army armyOne;
    private Army armyTwo;



    public Battle(Army armyOne, Army armyTwo) {
        if (!armyOne.hasUnits() || !armyTwo.hasUnits()) throw new IllegalArgumentException("Army can not be empty");
        if (Objects.equals(armyOne, armyTwo)) throw new IllegalArgumentException("Cannot simulate with the same army");
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }


    /**Method for getting the winner from the simulate method
     *
     * @return the name of the army winner
     */
    public String getWinner() {
        return simulate().getName();
    }

    /** Simulate a battle
     *
     * The attacking army is random
     * If the defender has 0 or less in health
     * it will be removed
     *
     * @return the army that has won
     */
    public Army simulate() {
        int counter = 0;
        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            if (counter % 2 == 0) {
                armyOneAttack();
            }

            if (counter % 2 != 0) {
                armyTwoAttack();
            }
            counter++;
        }
        if (armyOne.getAllUnits().size() > 0){
            return armyOne;
        }
        return armyTwo;

    }

    /**
     * Random method for finding the army
     * that attacks in the simulate method
     */
    public void armyOneAttack() {
        Unit armyTwoRandomUnit = armyTwo.getRandom();
        armyOne.getRandom().attack(armyTwoRandomUnit);

        if (armyTwoRandomUnit.getHealth() <= 0){
            armyTwo.remove(armyTwoRandomUnit);
        }
    }

    /**
     * Random method for finding the army
     * that attacks in the simulate method
     */
    public void armyTwoAttack(){
        Unit armyOneRandomUnit = armyOne.getRandom();
        armyTwo.getRandom().attack(armyOneRandomUnit);

        if (armyOneRandomUnit.getHealth() <= 0){
            armyOne.remove(armyOneRandomUnit);
        }
    }


    @Override
    public String toString() {
        return "Battle: " + "\n" +
                "army one: " + armyOne + "\n"+
                "army two: " + armyTwo + "\n" +
                "Winner: " + getWinner();
    }
}
