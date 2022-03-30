package no.ntnu.vildegy.wargames.filehandler;

import no.ntnu.vildegy.wargames.model.Army;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import no.ntnu.vildegy.wargames.model.CommanderUnit;
import no.ntnu.vildegy.wargames.model.CavarlyUnit;
import no.ntnu.vildegy.wargames.model.InfantryUnit;
import no.ntnu.vildegy.wargames.model.RangedUnit;

public class ImportUnits {

    /**Method for importing an army object from file
     *
     * @return the file information as an army object with units
     * @throws IOException
     */
        public static Army importArmy(String fileName) throws IOException {

            if (!fileName.endsWith(".csv"))
                throw new IOException("The file format is unsupported. Only \".csv\"-files are supported");


            try {
                ClassLoader classLoader = ImportUnits.class.getClassLoader();

                // Return a input stream for reading the specific resource

                InputStream inputStream = classLoader.getResourceAsStream(fileName);


                //Reads the text from the inputStream. Standard charset set to UTF 8
                BufferedReader readText = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                // Create Army object
                String line = readText.readLine();
                Army army = new Army(line);

                line = readText.readLine();

                while (line != null) {
                    String[] fields = line.split(";"); //split the string on every comma

                    if (fields.length != 3)
                        throw new IOException("Invalid line data '" + line + "'. Make sure the file has the format \"unit type,unit name,unit health\"");

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
            Army testArmy = importArmy("ImportArmyFile.csv");
            System.out.println(testArmy);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}