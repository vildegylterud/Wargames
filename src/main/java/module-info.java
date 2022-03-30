module Wargames {

    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.vildegy.wargames.controller to javafx.fxml;
    opens no.ntnu.vildegy.wargames.model to javafx.graphics,javafx.base, javafx.fxml;

    exports no.ntnu.vildegy.wargames;



}