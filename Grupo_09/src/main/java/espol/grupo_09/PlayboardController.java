package espol.grupo_09;

import System.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PlayboardController implements Initializable {

    @FXML
    private BorderPane bpPlayboard;
    @FXML
    private Button btSurrender;
    @FXML
    private Pane Pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void surrender(ActionEvent event) throws IOException {
        Reader.setGameResult(false);
        App.setRoot("Credits");
    }

}
