package espol.grupo_09;

import System.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class SettingCharController implements Initializable {

    @FXML
    private Pane pSettings;
    @FXML
    private Button btBackToMainMenu;
    @FXML
    private ToggleButton btX;
    @FXML
    private ToggleButton bt0;
    @FXML
    private Button btSettingFirst;
    @FXML
    private ToggleGroup btGroupChar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btSettingFirst.setDisable(true);
    }

    @FXML
    private void charX(ActionEvent event) {
        if (!btX.isSelected()) {
            btSettingFirst.setDisable(true);
        } else {
            Reader.setPlayer(btX.getText().charAt(0));
            Reader.setPc(bt0.getText().charAt(0));
            btSettingFirst.setDisable(false);
        }

    }

    @FXML
    private void char0(ActionEvent event) {
        if (!bt0.isSelected()) {
            btSettingFirst.setDisable(true);
        } else {
            Reader.setPlayer(bt0.getText().charAt(0));
            Reader.setPc(btX.getText().charAt(0));
            btSettingFirst.setDisable(false);
        }
    }

    @FXML
    private void switchToFirst(ActionEvent event) throws IOException {
        App.setRoot("SettingFirst");
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) throws IOException {
        App.setRoot("MainMenu");
    }

}
