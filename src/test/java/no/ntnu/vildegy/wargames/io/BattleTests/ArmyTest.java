package no.ntnu.vildegy.wargames.io.BattleTests;

import no.ntnu.vildegy.wargames.io.Battle.Army;
import no.ntnu.vildegy.wargames.io.Units.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    //bruker assertEquals og NotEquals for å sjekke at army1 er ulik før og etter remove-meotden
    @Test
    @DisplayName("Using remove method")
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
    @DisplayName("Checking hasUnits success")
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
    @DisplayName("Checking unsuccessful hasUnits test")
    void hasUnitsUnSuccess() {

        ArrayList<Unit> units = new ArrayList<Unit>();
        Army army = new Army("army", units);

        assertFalse(army.hasUnits());
    }

    //bruker assert equals for å sjekke at meotden finner alle units i en army
    @Test
    @DisplayName("Get all units from arraylist of units")
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
    @DisplayName("Testing equals method, success")
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
    @DisplayName("Testing equals method, unsuccessful")
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


    @Test
    @DisplayName("Get Infantry units in army")
    void getInfantryUnitsTest(){
        ArrayList<Unit> units = new ArrayList<>();
        Army testArmy = new Army("army", units);
        units.add(new CommanderUnit("Bob",180));
        int i = 0;
        for (i = 0;i < 50;i++){
            units.add(new InfantryUnit("Footman",100));
        }
        for (i = 0; i < 20; i++){
            units.add(new RangedUnit("Archer",100));
        }
        for (i = 0; i < 5; i++){
            units.add(new CavarlyUnit("Chad",100));
        }
        testArmy.addAllUnits(units);
        assertEquals(50,testArmy.getInfantryUnits().size());
    }

    @Test
    @DisplayName("Get Cavalry units in army")
    void getCavalryUnitsTest(){
        ArrayList<Unit> units = new ArrayList<>();
        Army testArmy = new Army("army", units);
        units.add(new CommanderUnit("Bob",180));
        int i = 0;
        for (i = 0;i < 50;i++){
            units.add(new InfantryUnit("Footman",100));
        }
        for (i = 0; i < 20; i++){
            units.add(new RangedUnit("Archer",100));
        }
        for (i = 0; i < 5; i++){
            units.add(new CavarlyUnit("Chad",100));
        }
        testArmy.addAllUnits(units);
        assertEquals(5,testArmy.getCavarlyUnits().size());
    }

    @Test
    @DisplayName("Get Commander units in army")
    void getCommanderUnitsTest(){
        ArrayList<Unit> units = new ArrayList<>();
        Army testArmy = new Army("army", units);
        units.add(new CommanderUnit("Bob",180));
        units.add(new CommanderUnit("Bob",180));
        units.add(new CommanderUnit("Bob",180));
        units.add(new CommanderUnit("Bob",180));
        units.add(new CommanderUnit("Bob",180));
        units.add(new CommanderUnit("Bob",180));
        units.add(new CommanderUnit("Bob",180));
        int i = 0;
        for (i = 0;i < 50;i++){
            units.add(new InfantryUnit("Footman",100));
        }
        for (i = 0; i < 20; i++){
            units.add(new RangedUnit("Archer",100));
        }
        for (i = 0; i < 5; i++){
            units.add(new CavarlyUnit("Chad",100));
        }
        testArmy.addAllUnits(units);
        assertEquals(7,testArmy.getCommanderUnits().size());
    }
}

