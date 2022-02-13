package no.ntnu.vildegy.wargames.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommanderUnitTest {

    //Sjekker at commanderUnit faktisk arver getAttackBonus fra CavarlyUnit
    @Test
    void getAttackBonusSuccess2() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        rangedUnit.attack(commanderUnit);
        rangedUnit.attack(commanderUnit);

        int value = commanderUnit.timesAttacked;
        System.out.println(value);

        assertTrue(commanderUnit.getAttackBonus() == 2);
    }
}
