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
import javafx.scene.layout.BorderPane;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class MainMenuController implements Initializable {


    @FXML
    private BorderPane bpMenu;
    @FXML
    private Label lbTitle;
    @FXML
    private Button btPlay;
    @FXML
    private Button btOptions;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToBoardSize(ActionEvent event) {
    }

    @FXML
    private void switchToSettingsLanguage(ActionEvent event) {
    }

}
