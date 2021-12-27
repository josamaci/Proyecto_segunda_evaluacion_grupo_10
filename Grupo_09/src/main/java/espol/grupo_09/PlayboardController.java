package espol.grupo_09;

import System.Board;
import System.Coordinate;
import System.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class PlayboardController implements Initializable {

    @FXML
    private BorderPane bpPlayboard;
    @FXML
    private Button btSurrender;
    @FXML
    private StackPane topLeft;
    @FXML
    private Label topLeftChoice;
    @FXML
    private StackPane top;
    @FXML
    private Label topChoice;
    @FXML
    private StackPane topRight;
    @FXML
    private Label topRightChoice;
    @FXML
    private StackPane centerLeft;
    @FXML
    private Label centerLeftChoice;
    @FXML
    private StackPane center;
    @FXML
    private Label centerChoice;
    @FXML
    private StackPane centerRight;
    @FXML
    private Label centerRightChoice;
    @FXML
    private StackPane bottomLeft;
    @FXML
    private Label bottonLeftChoice;
    @FXML
    private StackPane botton;
    @FXML
    private Label bottonChoice;
    @FXML
    private StackPane bottomRight;
    @FXML
    private Label bottonRightChoice;
    private Board b;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b = new Board();
    }

    @FXML
    private void surrender(ActionEvent event) throws IOException {
        Reader.setGameResult(false);
        App.setRoot("Credits");
    }
    
    private void insert(Coordinate c, char ch){
        b.insertChar(c, ch);
    }

    @FXML
    private void Pane00(MouseEvent event) {
        insert(new Coordinate(0,0), Reader.getPlayer());
        topLeft.setDisable(true);
        topLeftChoice.setText(String.valueOf(Reader.getPlayer()));
    }

}
