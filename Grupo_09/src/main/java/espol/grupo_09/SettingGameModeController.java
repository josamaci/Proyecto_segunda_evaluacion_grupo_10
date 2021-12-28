/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class SettingGameModeController implements Initializable {


    @FXML
    private Pane pSettings;
    @FXML
    private Button btBackToMainMenu;
    @FXML
    private Button btSettingChar;
    @FXML
    private ToggleButton btPVP;
    @FXML
    private ToggleGroup btGroupGameMode;
    @FXML
    private ToggleButton btPVE;
    @FXML
    private ToggleButton btPCvsPC;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToMainMenu(ActionEvent event) throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void PVP(ActionEvent event) {
        if (!btPVP.isSelected()) {
            btSettingChar.setDisable(true);
        } else {
            Reader.setGameMode(1);
            btSettingChar.setDisable(false);
        }
    }

    @FXML
    private void PVE(ActionEvent event) {
        if (!btPVE.isSelected()) {
            btSettingChar.setDisable(true);
        } else {
            Reader.setGameMode(0);
            btSettingChar.setDisable(false);
        }
    }

    @FXML
    private void PCvsPC(ActionEvent event) {
        if (!btPCvsPC.isSelected()) {
            btSettingChar.setDisable(true);
        } else {
            Reader.setGameMode(-1);
            btSettingChar.setDisable(false);
        }
    }

    @FXML
    private void switchToChar(ActionEvent event) throws IOException {
        App.setRoot("SettingChar");
    }

}
