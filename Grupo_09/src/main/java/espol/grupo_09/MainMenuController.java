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
import java.io.IOException;
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
    private Button btPlay;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToChar(ActionEvent event) throws IOException{
        App.setRoot("SettingChar");
    }

}
