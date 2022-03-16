package no.ntnu.vildegy.wargames.FileHandler;

import no.ntnu.vildegy.wargames.io.Battle.Army;
import no.ntnu.vildegy.wargames.io.Units.Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;


public class ImportUnits {

    public static void importAllUnits(Army army) throws IOException {

        try {
            ClassLoader classLoader = ImportUnits.class.getClassLoader();

            // Return a input stream for reading the specific resource

            InputStream inputStream = classLoader.getResourceAsStream("Bok5.csv");

            //Reads the text from the inputStream. Standard charset set to UTF 8
            BufferedReader readText = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));


            // Reads a line of text and returns a string containing the contents of the line
            for (String line; (line = readText.readLine()) != null; ) {
                String[] fields = line.split("\t"); //split the string on every "tab"
                army.addUnit(new Army(fields[0]), new Unit(fields[1],fields[2],fields[3])); //adds all the values to the correct Unit values
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
