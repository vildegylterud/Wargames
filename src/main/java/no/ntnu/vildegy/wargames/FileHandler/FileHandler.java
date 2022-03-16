package no.ntnu.vildegy.wargames.FileHandler;

import no.ntnu.vildegy.wargames.io.Battle.Army;
import no.ntnu.vildegy.wargames.io.Units.Unit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {

    private static String delimiter = Constants.CSV_DELIMITER_STRING;

    private final File FILE;


    /**
     * @param path
     * @throws IOException
     */
    public FileHandler(String path) throws IOException {
        if (!path.endsWith(".csv")) {
            throw new IOException(path + " is not a .csv file.");
        }
        this.FILE = new File(path);

        if (!FILE.exists()) {
            throw new IOException("Did not find the file " + FILE.getAbsolutePath());
        }
    }


    //TODO: all javadoc i filklassene er feil
    /**
     * Method for exporting postal register to file
     *
     * @param army a list with all the postal code objects
     * @param file
     * @throws IOException
     */
    public static void exportToFile(Army army, File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        for (Unit unit : army.getAllUnits()) {
            printWriter.println(army.getName() + delimiter + unit.getClass().getName() + delimiter + unit.getName() + delimiter + unit.getHealth());
        }
        printWriter.close();
    }

}
