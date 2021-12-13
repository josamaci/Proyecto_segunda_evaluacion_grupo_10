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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class CreditsController implements Initializable {

    @FXML
    private VBox vbCredits;
    @FXML
    private Label lblWinLose;
    @FXML
    private Label lbPoints;
    @FXML
    private Label lblPoints;
    @FXML
    private Button btMainMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToTheTitle(ActionEvent event) {
    }
    
}
