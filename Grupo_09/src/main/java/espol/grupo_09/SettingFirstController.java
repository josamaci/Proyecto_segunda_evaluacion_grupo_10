/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.grupo_09;

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
/**
 * FXML Controller class
 *
 * @author JMaci
 */
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectYou(ActionEvent event) {
    }

    @FXML
    private void selectPC(ActionEvent event) {
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
