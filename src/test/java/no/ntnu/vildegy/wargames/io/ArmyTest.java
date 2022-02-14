package no.ntnu.vildegy.wargames.io;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    //bruker assertEquals og NotEquals for å sjekke at army1 er ulik før og etter remove-meotden
    @Test
    void remove() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> unitsWithCommanderUnit = new ArrayList<Unit>();
        unitsWithCommanderUnit.add(rangedUnit);
        unitsWithCommanderUnit.add(cavarlyUnit);
        unitsWithCommanderUnit.add(commanderUnit);

        ArrayList<Unit> unitsWithoutCommanderUnit = new ArrayList<Unit>();
        unitsWithoutCommanderUnit.add(rangedUnit);
        unitsWithoutCommanderUnit.add(cavarlyUnit);


        Army army1 = new Army("army", unitsWithCommanderUnit);
        Army army2 = new Army("army", unitsWithoutCommanderUnit);

        assertNotEquals(army1,army2);

        army1.remove(commanderUnit);

        assertEquals(army1, army2);
    }

    //oppretter en liste units og adder tre units i den. Metoden skal derfor returnere true
    @Test
    void hasUnitsSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavarlyUnit);
        units.add(commanderUnit);

        Army army = new Army("army", units);

        assertTrue(army.hasUnits());
    }

    //oppretter en tom liste med units som en army. Metoden skal returnere false
    @Test
    void hasUnitsUnSuccess() {

        ArrayList<Unit> units = new ArrayList<Unit>();
        Army army = new Army("army", units);

        assertFalse(army.hasUnits());
    }

    //bruker assert eqals for å sjekke at meotden finner alle units i en army
    @Test
    void getAllUnits() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavarlyUnit);
        units.add(commanderUnit);

        Army army = new Army("army", units);

        assertEquals(army.getAllUnits(), units);

    }

    //legger til samme lista med units i to army. metoden skal returnere true
    @Test
    void testEqualsSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavarlyUnit);
        units.add(commanderUnit);

        Army army1 = new Army("army", units);
        Army army2 = new Army("army", units);

        assertTrue(army1.equals(army2));
    }


    //legger kun til units i army1 slik at army1 og 2 ikke er like
    @Test
    void testEqualsUnSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavarlyUnit);
        units.add(commanderUnit);

        Army army1 = new Army("army", units);
        Army army2 = new Army("army");

        assertFalse(army1.equals(army2));
    }


    //dette er strengt tatt ikke en test, men ønsker å kjøre denne flere gangen for å sjekke
    //at den returnerer tilfeldig og ulikt hver gang
    @Test
    void randomSuccess() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavarlyUnit cavarlyUnit = new CavarlyUnit("CavarlyUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavarlyUnit);
        units.add(commanderUnit);

        Army army1 = new Army("army", units);
        System.out.println(army1.getRandom());

    }
}
