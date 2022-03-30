package no.ntnu.vildegy.wargames.filehandler;

import no.ntnu.vildegy.wargames.model.Army;
import no.ntnu.vildegy.wargames.model.Unit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportUnits {

    private static String delimiter = Constants.CSV_DELIMITER_STRING;

    private final File FILE;


    /**
     * @param path
     * @throws IOException
     */
    public ExportUnits(String path) throws IOException {
        if (!path.endsWith(".csv")) {
            throw new IOException(path + " is not a .csv file.");
        }
        this.FILE = new File(path);

        if (!FILE.exists()) {
            throw new IOException("Did not find the file " + FILE.getAbsolutePath());
        }
    }

    /**
     * Method for exporting an Army to file
     *
     * @param army a list with all the army objects
     * @param file
     * @throws IOException
     */
    public static void exportToFile(Army army, File file) throws IOException {

        if (!file.getAbsolutePath().endsWith(".csv")) {
            throw new IOException(file + " is not a .csv file.");
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        printWriter.println(army.getName() + delimiter);
        for (Unit unit : army.getAllUnits()) {
            printWriter.println(unit.getClass().getSimpleName() + delimiter + unit.getName() + delimiter + unit.getHealth());
        }
        printWriter.close();

        if (!file.exists()) {
            throw new IOException("Did not find the file " + file.getAbsolutePath());
        }

    }

}
