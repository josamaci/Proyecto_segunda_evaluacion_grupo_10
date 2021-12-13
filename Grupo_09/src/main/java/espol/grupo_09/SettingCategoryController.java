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
public class SettingCategoryController implements Initializable {


    @FXML
    private Pane pCat;
    @FXML
    private Button btBackToBS;
    @FXML
    private Label lbTitle;
    @FXML
    private ToggleButton btCategoryAnimal;
    @FXML
    private ToggleGroup btGroupCategory;
    @FXML
    private ToggleButton btCategoryColor;
    @FXML
    private ToggleButton btCategoryFruit;
    @FXML
    private ToggleButton btCategoryNumber;
    @FXML
    private ToggleButton btCategoryRandom;
    @FXML
    private Button btNextSetting2;
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
    private void catAnimals(ActionEvent event) {
    }

    @FXML
    private void catColors(ActionEvent event) {
    }

    @FXML
    private void catFruits(ActionEvent event) {
    }

    @FXML
    private void catNumbers(ActionEvent event) {
    }

    @FXML
    private void catRandom(ActionEvent event) {
    }

    @FXML
    private void switchToGameMode(ActionEvent event) {
    }

}
