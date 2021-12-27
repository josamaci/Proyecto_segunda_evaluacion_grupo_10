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
    private ToggleGroup btGroupGameMode;
    @FXML
    private Button btBackToMainMenu;
    @FXML
    private ToggleButton btX;
    @FXML
    private ToggleButton bt0;
    @FXML
    private Button btSettingFirst;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void charX(ActionEvent event) {
        Reader.setYou(btX.getText().charAt(0));
        Reader.setRival(bt0.getText().charAt(0));
    }

    @FXML
    private void char0(ActionEvent event) {
        Reader.setYou(bt0.getText().charAt(0));
        Reader.setRival(btX.getText().charAt(0));
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
