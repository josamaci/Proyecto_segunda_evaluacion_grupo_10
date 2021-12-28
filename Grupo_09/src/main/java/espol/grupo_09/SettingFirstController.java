package espol.grupo_09;

import System.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class SettingFirstController implements Initializable {

    @FXML
    private Pane pCat;
    @FXML
    private ToggleGroup btGroupCategory;
    @FXML
    private Button btBackToChar;
    @FXML
    private ToggleButton btYou;
    @FXML
    private ToggleButton btPC;
    @FXML
    private Button btPlayboard;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btPlayboard.setDisable(true);
    }

    @FXML
    private void selectYou(ActionEvent event) {
        if (!btYou.isSelected()) {
            btPlayboard.setDisable(true);
        } else {
            Reader.setStarting(true);
            btPlayboard.setDisable(false);
        }

    }

    @FXML
    private void selectPC(ActionEvent event) {
        if (!btPC.isSelected()) {
            btPlayboard.setDisable(true);
        } else {
            Reader.setStarting(false);
            btPlayboard.setDisable(false);
        }

    }

    @FXML
    private void switchToPlayboard(ActionEvent event) throws IOException {
        App.setRoot("Playboard");
    }

    @FXML
    private void switchBackToChar(ActionEvent event) throws IOException {
        App.setRoot("SettingChar");
    }

}
