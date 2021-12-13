/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.grupo_09;

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
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class SettingGameModeController implements Initializable {


    @FXML
    private Pane pSettings;
    @FXML
    private Button btBackToCat;
    @FXML
    private Label lbTitle;
    @FXML
    private ToggleButton btNormalMode;
    @FXML
    private ToggleGroup btGroupGameMode;
    @FXML
    private ToggleButton btExtremeMode;
    @FXML
    private Button btPlayboard;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToCategory(ActionEvent event) {
    }

    @FXML
    private void gmNormal(ActionEvent event) {
    }

    @FXML
    private void gmExtreme(ActionEvent event) {
    }

    @FXML
    private void switchToPlayboard(ActionEvent event) {
    }

}
