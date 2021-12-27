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
    private Label bottomLeftChoice;
    @FXML
    private StackPane bottomRight;
    
    @FXML
    private StackPane bottom;
    @FXML
    private Label bottomChoice;
    @FXML
    private Label bottomRightChoice;
    
    private Board b;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b = new Board();
        System.out.println(b);
    }

    @FXML
    private void surrender(ActionEvent event) throws IOException {
        Reader.setGameResult(-1);
        App.setRoot("Credits");
    }
    
    private void insert(Coordinate c, char ch) throws IOException{
        String result = b.insertChar(c, ch);
        switch (result) {
            case "YOU WIN":
                Reader.setGameResult(1);
                App.setRoot("Credits");
                break;
            case "YOU LOSE":
                Reader.setGameResult(-1);
                App.setRoot("Credits");
                break;
            case "DRAW":
                Reader.setGameResult(0);
                App.setRoot("Credits");
                break;
        }
    }

    @FXML
    private void topLeftClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(0,0), Reader.getPlayer());
        topLeft.setDisable(true);
        topLeftChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void topClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(0, 1), Reader.getPlayer());
        top.setDisable(true);
        topChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void topRightClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(0, 2), Reader.getPlayer());
        topRight.setDisable(true);
        topRightChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void centerLeftClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(1, 0), Reader.getPlayer());
        centerLeft.setDisable(true);
        centerLeftChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void centerClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(1, 1), Reader.getPlayer());
        center.setDisable(true);
        centerChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void centerRightClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(1, 2), Reader.getPlayer());
        centerRight.setDisable(true);
        centerRightChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void bottomLeftClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(2, 0), Reader.getPlayer());
        bottomLeft.setDisable(true);
        bottomLeftChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void bottomClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(2, 1), Reader.getPlayer());
        bottom.setDisable(true);
        bottomChoice.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void bottomRightClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(2, 2), Reader.getPlayer());
        bottomRight.setDisable(true);
        bottomRightChoice.setText(String.valueOf(Reader.getPlayer()));
    }

}
