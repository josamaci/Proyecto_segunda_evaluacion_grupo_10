package espol.grupo_09;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CreditsController implements Initializable {

    @FXML
    private VBox vbCredits;
    @FXML
    private Label lblWinLose;
    @FXML
    private Button btMainMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backToTheTitle(ActionEvent event) throws IOException {
        App.setRoot("MainMenu");
    }

}