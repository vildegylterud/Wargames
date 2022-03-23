package no.ntnu.vildegy.wargames.io.FilehandlerTest;

import no.ntnu.vildegy.wargames.filehandler.ExportUnits;
import no.ntnu.vildegy.wargames.io.Battle.Army;
import no.ntnu.vildegy.wargames.io.Units.CommanderUnit;
import no.ntnu.vildegy.wargames.io.Units.InfantryUnit;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ExportUnitsTest {


    @Test
    public void  exportUnitsTest() throws IOException {

        //oppretter en army som senere skal export

        Army army = new Army("Human army;");

        InfantryUnit infantryUnit = new InfantryUnit("Footman", 100);
        CommanderUnit commanderUnit = new CommanderUnit("Mountain King", 180);

        army.add(infantryUnit);
        army.add(commanderUnit);

        System.out.println(army);

        //exports army til .csv fil
        ExportUnits.exportToFile(army, new File("ExportTestFile.csv"));


    }
}

