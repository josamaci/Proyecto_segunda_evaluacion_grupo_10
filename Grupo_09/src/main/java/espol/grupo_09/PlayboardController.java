package espol.grupo_09;

import System.Board;
import System.Coordinate;
import System.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class PlayboardController implements Initializable {

    @FXML
    private BorderPane bpPlayboard;
    @FXML
    private Button btSurrender;
    private Board b;
    @FXML
    private Label lblTopLeft;
    @FXML
    private Label lblTopRight;
    @FXML
    private Label lblLeft;
    @FXML
    private Label lblCenter;
    @FXML
    private Label lblRight;
    @FXML
    private Label lblBottomLeft;
    @FXML
    private Label lblBottom;
    @FXML
    private Label lblBottomRight;
    @FXML
    private Label lblTop;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b = new Board();
        
        //PVE y empieza la PC
        if(!Reader.getStarting() && Reader.getGameMode()==0){
            try {
                pcInsert(generateCoord());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }
   
    private void insert(Coordinate c, char ch) throws IOException{
        String result = b.insertChar(c, ch);
        resultEvaluation(result);
        if(b.getCoordinatesOf(' ').size()>0){
            pcInsert(b.minimaxCoord());
        }
    }
        
    private void pcInsert(Coordinate c) throws IOException {
        String result = b.insertChar(c,Reader.getPc());
        disablePanel(c);
        resultEvaluation(result);
    }
    
    private void disablePanel(Coordinate c){
        if(c.equals(new Coordinate(0,0))){
        lblTopLeft.setDisable(true);
        lblTopLeft.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(0,1))){
        lblTop.setDisable(true);
        lblTop.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(0,2))){
        lblTopRight.setDisable(true);
        lblTopRight.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(1,0))){
        lblLeft.setDisable(true);
        lblLeft.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(1,1))){
        lblCenter.setDisable(true);
        lblCenter.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(1,2))){
        lblRight.setDisable(true);
        lblRight.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(2,0))){
        lblBottomLeft.setDisable(true);
        lblBottomLeft.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(2,1))){
        lblBottom.setDisable(true);
        lblBottom.setText(String.valueOf(Reader.getPc()));}
        if(c.equals(new Coordinate(2,2))){
        lblBottomRight.setDisable(true);
        lblBottomRight.setText(String.valueOf(Reader.getPc()));}
    }
    
    private void resultEvaluation(String result) throws IOException{
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
        lblTopLeft.setDisable(true);
        lblTopLeft.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void topClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(0, 1), Reader.getPlayer());
        lblTop.setDisable(true);
        lblTop.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void topRightClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(0, 2), Reader.getPlayer());
        lblTopRight.setDisable(true);
        lblTopRight.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void leftClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(1, 0), Reader.getPlayer());
        lblLeft.setDisable(true);
        lblLeft.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void centerClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(1, 1), Reader.getPlayer());
        lblCenter.setDisable(true);
        lblCenter.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void rightClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(1, 2), Reader.getPlayer());
        lblRight.setDisable(true);
        lblRight.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void bottomLeftClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(2, 0), Reader.getPlayer());
        lblBottomLeft.setDisable(true);
        lblBottomLeft.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void bottomClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(2, 1), Reader.getPlayer());
        lblBottom.setDisable(true);
        lblBottom.setText(String.valueOf(Reader.getPlayer()));
    }

    @FXML
    private void bottomRightClicked(MouseEvent event) throws IOException {
        insert(new Coordinate(2, 2), Reader.getPlayer());
        lblBottomRight.setDisable(true);
        lblBottomRight.setText(String.valueOf(Reader.getPlayer()));
    }

    private Coordinate generateCoord() {
        Coordinate c = null;
        Random r = new Random();
        switch(r.nextInt(9)){
            case 0: c = new Coordinate(0, 0);
                break;  
            case 1: c = new Coordinate(0, 1);
                break; 
            case 2: c = new Coordinate(0, 2);
                break; 
            case 3: c = new Coordinate(1, 0);
                break; 
            case 4: c = new Coordinate(1, 1);
                break; 
            case 5: c = new Coordinate(1, 2);
                break; 
            case 6: c = new Coordinate(2, 0);
                break; 
            case 7: c = new Coordinate(2, 1);
                break;  
            case 8: c = new Coordinate(2, 2);
                break; 
        }
        return c;
    }

    @FXML
    private void surrender(MouseEvent event) throws IOException {
        Reader.setGameResult(-1);
        App.setRoot("Credits");
        
    }

}
