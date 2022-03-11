package no.ntnu.vildegy.wargames.io.Battle;

import no.ntnu.vildegy.wargames.io.Units.Unit;

import java.util.Objects;
import java.util.Random;

public class Battle {

    private Army armyOne;
    private Army armyTwo;
    private Army winner;


    public Battle(Army armyOne, Army armyTwo) {
        if (!armyOne.hasUnits() || !armyTwo.hasUnits()) throw new IllegalArgumentException("Army can not be empty");
        if (Objects.equals(armyOne, armyTwo)) throw new IllegalArgumentException("Cannot simulate with the same army");
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    public Army getWinner() {
        return winner;
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


/**
        if (winner != null) throw new UnsupportedOperationException("The simulation has already been run");

        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            Army attackingArmy;
            Army defendingArmy;

            int index = new Random().nextInt(2);
            if (index == 0) {
                attackingArmy = armyOne;
                defendingArmy = armyTwo;
            } else {
                attackingArmy = armyTwo;
                defendingArmy = armyOne;
            }

            Unit attacker = attackingArmy.getRandom();
            Unit defender = defendingArmy.getRandom();

            attacker.attack(defender);

            if (defender.getHealth() <= 0)
                defendingArmy.remove(defender);
        }

        winner = (armyOne.hasUnits()) ? armyOne : armyTwo;
        return winner;
    }*/

    }

    public void armyOneAttack() {
        Unit armyTwoRandomUnit = armyTwo.getRandom();
        armyOne.getRandom().attack(armyTwoRandomUnit);

        if (armyTwoRandomUnit.getHealth() <= 0){
            armyTwo.remove(armyTwoRandomUnit);
        }
    }

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
                "Winner: " + this.simulate().getName();
    }
}
