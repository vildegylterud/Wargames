package no.ntnu.vildegy.wargames.io.Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    //Test for å sjekke at getAttackBonus endres etter 1, 2 og 3 attacker
    @Test
    void getResistBonusSuccess1() {
        CommanderUnit commanderUnit = new CommanderUnit("Commanderunit", 50);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 50);

        commanderUnit.attack(rangedUnit);

        assertTrue(rangedUnit.getResistBonus() == 6 );

    }

    @Test
    void getResistBonusSuccess2() {
        CommanderUnit commanderUnit = new CommanderUnit("Commanderunit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);

        int value = rangedUnit.timesAttacked;
        System.out.println(value);

        assertTrue(rangedUnit.getResistBonus() == 4);
    }

    @Test
    void getResistBonusSuccess3() {
        CommanderUnit commanderUnit = new CommanderUnit("Commanderunit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);

        int value = rangedUnit.timesAttacked;

        assertTrue(rangedUnit.getResistBonus() == 2);
    }


    //Test for å sjekke at 1 attack ikke gir mindre enn 6 i bonus
    @Test
    void getResistBonusUnSuccess() {
        CommanderUnit commanderUnit = new CommanderUnit("Commanderunit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);

        assertFalse(rangedUnit.getResistBonus() == 4);
    }


    @Test
    void getAttackBonusSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        assertTrue(rangedUnit.getAttackBonus() == 3);
    }


    @Test
    void getAttackBonusUnSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        assertFalse(rangedUnit.getAttackBonus() != 3);

    }

    @Test
    void getAttackBonus() {
        RangedUnit rangedUnit = new RangedUnit("vilde", 10);
        System.out.println(rangedUnit.getAttack());
        System.out.println(rangedUnit.getArmour());
    }
}