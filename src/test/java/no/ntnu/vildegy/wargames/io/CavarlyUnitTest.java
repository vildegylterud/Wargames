package no.ntnu.vildegy.wargames.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CavarlyUnitTest {
    

    @Test
    void getAttackBonusSuccess1() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);

        rangedUnit.attack(cavarlyUnit);

        assertTrue(cavarlyUnit.getAttackBonus() == 6);
    }

    @Test
    void getAttackBonusSuccess2() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);

        rangedUnit.attack(cavarlyUnit);
        rangedUnit.attack(cavarlyUnit);

        int value = cavarlyUnit.timesAttacked;
        System.out.println(value);

        assertTrue(cavarlyUnit.getAttackBonus() == 2);
    }

    @Test
    void getAttackBonusUnSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);

        rangedUnit.attack(cavarlyUnit);
        rangedUnit.attack(cavarlyUnit);

        assertFalse(cavarlyUnit.getAttackBonus() == 6);
    }
}
