package no.ntnu.vildegy.wargames.frontend;

/**
 * The main application
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent main = FXMLLoader.load(getClass().getResource("scenes/main.fxml"));
            Scene scene = new Scene(main);

            stage.setScene(scene);


            stage.show();

            stage.setTitle("Wargames av Vilde");
            stage.sizeToScene();

            stage.setMinWidth(1100);
            stage.setMinHeight(640);
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Unable to start wargames...");
            a.setHeaderText("We were unable to start the Wargames application, sorry about that!.\n\nPlease contact Wargames support and show the following message: ");
            a.setContentText("Error type: " + e.getClass().getName() + "\nError message: " + e.getMessage());
            a.show();

            e.printStackTrace();
        }

    }
}

    /**

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scenes/main.fxml"));
        Parent main = fxmlLoader.load();
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();


        /**
        Parent main = FXMLLoader.load(getClass().getResource("scenes/main.fxml"));
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();*/


