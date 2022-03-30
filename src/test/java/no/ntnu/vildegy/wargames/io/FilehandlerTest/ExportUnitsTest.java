package no.ntnu.vildegy.wargames.io.FilehandlerTest;

import no.ntnu.vildegy.wargames.filehandler.ExportUnits;
import no.ntnu.vildegy.wargames.model.Army;
import no.ntnu.vildegy.wargames.model.InfantryUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;


public class ExportUnitsTest {


    @Test
    @DisplayName("Checks if the method exportToFile() thrown an exception when the file does not end with '.csv'")
    public void testToCheckThatAFileWithTheWrongFormatThrowsIOException() {
        assertThrows(IOException.class, () -> ExportUnits.exportToFile(new Army("test army"), new File("src/main/resources/ExportWrongFormat.txt")));
    }


    @Test
    @DisplayName("Checks if the method exportToFile() does not throw an IOException")
    public void testExportWithNoIOException() throws IOException {
        var testArmy = new Army("Test army");
        testArmy.add(new InfantryUnit("Footman", 100));
        testArmy.add(new InfantryUnit("Footman", 100));

        try {
            ExportUnits.exportToFile(testArmy, new File("src/main/resources/ExportTest.csv"));
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    @DisplayName("Checks if the method exportToFile() Throws An IOException when the file is a directory instead of a csv file")
    public void testExportWithNoExistingFile() {
        assertThrows(IOException.class, () -> ExportUnits.exportToFile(new Army("test army"), new File("src/main/resources/Armyfile")));
    }

}