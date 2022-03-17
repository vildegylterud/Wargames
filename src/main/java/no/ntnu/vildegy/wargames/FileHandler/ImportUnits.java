package no.ntnu.vildegy.wargames.FileHandler;

import no.ntnu.vildegy.wargames.io.Battle.Army;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import no.ntnu.vildegy.wargames.io.Units.CommanderUnit;
import no.ntnu.vildegy.wargames.io.Units.CavarlyUnit;
import no.ntnu.vildegy.wargames.io.Units.InfantryUnit;
import no.ntnu.vildegy.wargames.io.Units.RangedUnit;

public class ImportUnits {


    /**Method for importing an army object from file
     *
     * @return the file informtion as an army object with units
     * @throws IOException
     */
        public static Army importArmy() throws IOException {

            try {
                ClassLoader classLoader = ImportUnits.class.getClassLoader();

                // Return a input stream for reading the specific resource

                InputStream inputStream = classLoader.getResourceAsStream("ImportArmyFile.csv");

                //Reads the text from the inputStream. Standard charset set to UTF 8
                BufferedReader readText = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                // Create Army object
                String line = readText.readLine();
                Army army = new Army(line);

                line = readText.readLine();
                while (line != null) {
                    String[] fields = line.split(";"); //split the string on every comma

                    //Checks the Unit type, and add the correct unit type to the army
                    if (fields.length == 0) break;
                    switch (fields[0]) {
                        case "CommanderUnit":
                            army.add(new CommanderUnit(fields[1], Integer.parseInt(fields[2])));
                            break;

                        case "CavalryUnit":
                            army.add(new CavarlyUnit(fields[1], Integer.parseInt(fields[2])));
                            break;

                        case "InfantryUnit":
                            army.add(new InfantryUnit(fields[1], Integer.parseInt(fields[2])));
                            break;

                        case "RangedUnit":
                            army.add(new RangedUnit(fields[1], Integer.parseInt(fields[2])));
                            break;
                    }

                    line = readText.readLine();
                }
                return army;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    public static void main(String[] args) {
        try {
            Army testArmy = importArmy();
            System.out.println(testArmy);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}