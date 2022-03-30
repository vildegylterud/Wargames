package no.ntnu.vildegy.wargames;

/**
 * The main application
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.Optional;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main" + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setOnCloseRequest(event ->{
                exit();
                event.consume();
            });
            stage.show();
            stage.setTitle("Wargames av Vilde");
            stage.sizeToScene();

            //stage.setMinWidth(1100);
           // stage.setMinHeight(640);

        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Unable to start wargames...");
            a.setHeaderText("We were unable to start the Wargames application, sorry about that!.\n\nPlease contact Wargames support and show the following message: ");
            a.setContentText("Error type: " + e.getClass().getName() + "\nError message: " + e.getMessage());
            a.show();

            e.printStackTrace();
        }

    }

    /**
     * Method called when the system is to close. User is met with confirmation dialog to
     * confirm if this is intended.
     */
    public static void exit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit confirmation");
        alert.setHeaderText("Are you sure you want to exit the application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(1);
        }
    }
}