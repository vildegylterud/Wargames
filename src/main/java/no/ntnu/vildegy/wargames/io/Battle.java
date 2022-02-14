package no.ntnu.vildegy.wargames.io;

import java.util.Random;

public class Battle {

    private Army armyOne;
    private Army armyTwo;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    //TODO: lag metoden
    public Army simulate() {


        Army armyWinner = null;

        return armyWinner;

                //units.get(rand.nextInt(units.size()));
    }

    @Override
    public String toString() {
        return "Battle: " + "\n" +
                "army one: " + armyOne + "\n"+
                "army wo=: " + armyTwo;
    }
}
