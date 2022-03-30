package no.ntnu.vildegy.wargames.io.FilehandlerTest;

import no.ntnu.vildegy.wargames.filehandler.ImportUnits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;


public class ImportUnitsTest {

    @Test
    @DisplayName("A test to see that the method importArmy() does not throw an IOException when the file format is correct")
    public void testSuccessImportArmyDoesNotThrowAnIOException() {
        try {
            ImportUnits.importArmy("ImportArmyFile.csv");
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    @DisplayName("A test to check if the method importArmy() Throws An IOException when the file format is wrong")
    public void testToCheckIfAFileWithTxtFileThrowsIOException() {
        assertThrows(IOException.class, () -> ImportUnits.importArmy("ImportArmyFile.txt"));
    }


    //TODO: denne testen feiler, men jeg skjønner ikke hvorfor
    //Den kaster jo tilsynelatende en IOException, men tester feiler fordi den ikke gjør det?
    @Test
    @DisplayName("Checks if the method importArmy() Throws An IOException too much commas")
    public void testImportArmyThrowsIOException() {
        assertThrows(IOException.class, () -> ImportUnits.importArmy("ImportArmyFile2.csv"));
    }

}