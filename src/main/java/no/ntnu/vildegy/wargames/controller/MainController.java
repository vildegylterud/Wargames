package no.ntnu.vildegy.wargames.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import no.ntnu.vildegy.wargames.filehandler.ExportUnits;
import no.ntnu.vildegy.wargames.filehandler.ImportUnits;
import no.ntnu.vildegy.wargames.model.Army;
import no.ntnu.vildegy.wargames.model.Unit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class MainController {

    private Army army;

    @FXML
    private ObservableList<Unit> observableList;
    public TableColumn<Unit,String> armyOneColumn;
    public TableColumn<Unit,String> armyTwoColumn;
    public TableColumn<Unit,String> winnerColumn;
    public TableView<Unit> tableView;
    public Button clearButton;
    public Button simulateButton;
    public AnchorPane anchorPane;
    public MenuBar menuBar;



    /**
     * Initializing the application
     * creates an instance of Army and an
     * observable list to show in tableview
     */
    /*
    @FXML
    public void initialize() throws IOException {
        this.army = new Army();

        ImportUnits.importArmy(String.valueOf(army));

        armyOneColumn.setCellValueFactory(new PropertyValueFactory<>("ARMY_ONE"));
        armyTwoColumn.setCellValueFactory(new PropertyValueFactory<>("ARMY_TWO"));
        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("WINNER"));

        anchorPane.setStyle("-fx-background-color: #424242");

        this.observableList = FXCollections.observableArrayList();
        updateTableView(army.getAllUnits());

    }*/

    /**
     * Shows an about box with information of the program
     */
    @FXML
    public void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog - About");
        alert.setContentText("Vilde Gylterud" + "\n" + "Version: 1.0-SNAPSHOT" );

        //To get the dark mode design on all the dialog boxes
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #424242; -fx-prompt-text-fill: white; -fx-base: #121212; -fx-focus-traversable: false;  -fx-control-inner-background: derive(-fx-base, 35%);\n" +
                "    -fx-control-inner-background-alt: -fx-control-inner-background ; -fx-accent: #212121;\n" +
                "    -fx-focus-color: -fx-accent;");

        alert.showAndWait();
    }


    /**
     * Method for exit the application
     * Asks the user if she really wants to exit the application
     */
    @FXML
    public void exitApplication() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Exit?");
        alert.setContentText("Are you sure you want to exit?");

        //To get the dark mode design on the dialog boxes too
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #424242; -fx-prompt-text-fill: white; -fx-base: #121212; -fx-focus-traversable: false;  -fx-control-inner-background: derive(-fx-base, 35%);\n" +
                "    -fx-control-inner-background-alt: -fx-control-inner-background ; -fx-accent: #212121;\n" +
                "    -fx-focus-color: -fx-accent;");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {

            Platform.exit();
        }
    }

    /** Method that sends a selected message to the user
     *
     * @param message selected message to the user
     */
    public void messageAlertToUser(String message) {
        Alert alert = new Alert((Alert.AlertType.INFORMATION));

        alert.setTitle("Information");
        alert.setContentText(message);

        //To get the dark mode design on all the dialog boxes
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #424242; -fx-prompt-text-fill: white; -fx-base: #121212; -fx-focus-traversable: false;  -fx-control-inner-background: derive(-fx-base, 35%);\n" +
                "    -fx-control-inner-background-alt: -fx-control-inner-background ; -fx-accent: #212121;\n" +
                "    -fx-focus-color: -fx-accent;");

        alert.showAndWait();
    }

    /** Method that clears the tableview
     *  and sets/adds the new values in it
     *
     * @param arrayList a list with all the postal codes
     */
    public void updateTableView(ArrayList<Unit> arrayList) {
        tableView.getItems().clear();
        observableList.setAll(arrayList);
        tableView.getItems().addAll(observableList);
    }

    public void clearTables() {

    }

    public void simulate() {

    }

    /**
     * Method for exporting Txt file
     */
    @FXML
    public void exportToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Csv files (.csv)", ".csv"));
        File importFile = fileChooser.showSaveDialog(null);

        try {
            ExportUnits.exportToFile(this.army, importFile);
            updateTableView(army.getAllUnits());
        } catch (IOException e) {
            messageAlertToUser("Error in exporting file. Could not import file");
            e.printStackTrace();
        }
    }

    //TODO: metoden fungerer ikke opitmalt
    @FXML
    public void importFromFile() {
        FileChooser file =  new FileChooser();
        file.setTitle("Open file");
        file.showOpenDialog(null);

        String filename = file.getInitialFileName();

        try {
            ImportUnits.importArmy(filename);
        } catch (IOException e) {
            messageAlertToUser("Error in importing file. Could not import file");
            e.printStackTrace();
        }

    }

}
