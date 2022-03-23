package no.ntnu.vildegy.wargames.io.FilehandlerTest;

import no.ntnu.vildegy.wargames.filehandler.ImportUnits;
import no.ntnu.vildegy.wargames.io.Battle.Army;
import no.ntnu.vildegy.wargames.io.Units.CommanderUnit;
import no.ntnu.vildegy.wargames.io.Units.InfantryUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ImportUnitsTest {

    @Test
    public void ImportUnitsTest() throws IOException {

        //lese innholdet fra testfil

        Army testArmy = ImportUnits.importArmy("ImportArmyFile.csv");

        System.out.println(testArmy + "\n");

        //oppretter en army med samme innhold i ønsket format
        Army army = new Army("Human army");


        InfantryUnit infantryUnit = new InfantryUnit("Footman", 100);
        CommanderUnit commanderUnit = new CommanderUnit("Mountain King", 180);

        army.add(infantryUnit);
        army.add(commanderUnit);

        System.out.println(army);

        //verifiser at armeen som er lest, er som forventet

        assertEquals(testArmy,army);

    }
}
