package espol.grupo_09;

import System.Board;
import System.Coordinate;
import System.Game;
import System.Reader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
    
    private Game game;
    @FXML
    private Label lblP1;
    @FXML
    private Label lblP2;
    @FXML
    private Label lblP11;
    @FXML
    private Label lblTurn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new Game (new Board(), Reader.getPlayer1(), Reader.getPlayer2(), Reader.getGameMode());
        lblP1.setText(game.getP1().getName()+": "+game.getP1().getCharacter());
        lblP2.setText(game.getP2().getName()+": "+game.getP2().getCharacter());
        lblTurn.setText(game.whoTurn().getName());
        ableButtons();
        System.out.println(game.getActualBoard());
        //PVE y empieza la PC
        if(game.getP2().getIsTurn() && game.getGameMode()==0){
            try {
                pcInsert(game.minimaxCoord());
                System.out.println(game.getActualBoard());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //PC vs PC
        if(game.getGameMode()==-1){
            disableButtons();
            try {
                pcInsert(game.minimaxCoord());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
   
    private void insert(Coordinate c) throws IOException{
        if(game.getGameMode()==0){
            game.insertChar(c);
            lblTurn.setText(game.whoTurn().getName());
            resultEvaluation(game.getResult());
            if(game.getResult().equals("STILL PLAYING")){
                System.out.println(game.getActualBoard());
            }
            if(game.getActualBoard().getRoot().getContent().getCoordinatesOf(' ').size()>0 && game.getResult().equals("STILL PLAYING")){
                pcInsert(game.minimaxCoord());
                lblTurn.setText(game.whoTurn().getName());
                System.out.println(game.getActualBoard());
            }
        }else if(game.getGameMode()==1){
            game.insertChar(c);
            lblTurn.setText(game.whoTurn().getName());
            resultEvaluation(game.getResult());
            if(game.getResult().equals("STILL PLAYING")){
                System.out.println(game.getActualBoard());
            }
        }
    }
        
    private void pcInsert(Coordinate c) throws IOException {
        disablePanel(c);
        game.insertChar(c);
        lblTurn.setText(game.whoTurn().getName());
        resultEvaluation(game.getResult());
        if(game.getGameMode()==-1){
            game.setGameMode(-2);
            ComputerInsert ci = new ComputerInsert();
            Thread t = new Thread(ci);
            t.setDaemon(true);
            t.start();
        }
    }
    
    private void disablePanel(Coordinate c){
        if(c.equals(new Coordinate(0,0))){
        lblTopLeft.setDisable(true);
        lblTopLeft.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(0,1))){
        lblTop.setDisable(true);
        lblTop.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(0,2))){
        lblTopRight.setDisable(true);
        lblTopRight.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(1,0))){
        lblLeft.setDisable(true);
        lblLeft.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(1,1))){
        lblCenter.setDisable(true);
        lblCenter.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(1,2))){
        lblRight.setDisable(true);
        lblRight.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(2,0))){
        lblBottomLeft.setDisable(true);
        lblBottomLeft.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(2,1))){
        lblBottom.setDisable(true);
        lblBottom.setText(String.valueOf(game.whoTurn().getCharacter()));}
        if(c.equals(new Coordinate(2,2))){
        lblBottomRight.setDisable(true);
        lblBottomRight.setText(String.valueOf(game.whoTurn().getCharacter()));}
    }
    
    private void resultEvaluation(String result) throws IOException{
        if(!game.getResult().equals("STILL PLAYING")){
            System.out.println(game.getOriginalBoard());
            Reader.setGameResult(game.getResult());
            App.setRoot("Credits");
        }
    }
    
    @FXML
    private void topLeftClicked(MouseEvent event) throws IOException {
        lblTopLeft.setText(String.valueOf(game.whoTurn().getCharacter()));
        insert(new Coordinate(0,0));
        lblTopLeft.setDisable(true); 
    }

    @FXML
    private void topClicked(MouseEvent event) throws IOException {
        lblTop.setText(String.valueOf(game.whoTurn().getCharacter()));
        insert(new Coordinate(0, 1));
        lblTop.setDisable(true);
    }

    @FXML
    private void topRightClicked(MouseEvent event) throws IOException {
        lblTopRight.setText(String.valueOf(game.whoTurn().getCharacter()));
        insert(new Coordinate(0, 2));
        lblTopRight.setDisable(true);
    }

    @FXML
    private void leftClicked(MouseEvent event) throws IOException {
        lblLeft.setText(String.valueOf(game.whoTurn().getCharacter()));
        insert(new Coordinate(1, 0));
        lblLeft.setDisable(true);
    }

    @FXML
    private void centerClicked(MouseEvent event) throws IOException {
        lblCenter.setText(String.valueOf(game.whoTurn().getCharacter()));        
        insert(new Coordinate(1, 1));
        lblCenter.setDisable(true);
    }

    @FXML
    private void rightClicked(MouseEvent event) throws IOException {
        lblRight.setText(String.valueOf(game.whoTurn().getCharacter()));       
        insert(new Coordinate(1, 2));
        lblRight.setDisable(true);

    }

    @FXML
    private void bottomLeftClicked(MouseEvent event) throws IOException {
        lblBottomLeft.setText(String.valueOf(game.whoTurn().getCharacter()));        
        insert(new Coordinate(2, 0));
        lblBottomLeft.setDisable(true);
    }

    @FXML
    private void bottomClicked(MouseEvent event) throws IOException {
        lblBottom.setText(String.valueOf(game.whoTurn().getCharacter()));        
        insert(new Coordinate(2, 1));
        lblBottom.setDisable(true);
    }

    @FXML
    private void bottomRightClicked(MouseEvent event) throws IOException {
        lblBottomRight.setText(String.valueOf(game.whoTurn().getCharacter()));        
        insert(new Coordinate(2, 2));
        lblBottomRight.setDisable(true);
    }

    @FXML
    private void surrender(MouseEvent event) throws IOException {
        game.setResult(game.whoTurn().getName()+" LOSE");
        Reader.setGameResult(game.getResult());
        App.setRoot("Credits");
        
    }
    
    private class ComputerInsert implements Runnable{
        @Override
        public void run(){
            try{
                sleep(2000);
                while(game.getResult().equals("STILL PLAYING")){
                        Platform.runLater(()->{
                            try {
                                pcInsert(game.minimaxCoord());
                                System.out.println(game.getActualBoard());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        ;});
                        sleep(2000);
                }
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
        }
    }
    
    private void disableButtons(){
        lblTopLeft.setDisable(true);
        lblTop.setDisable(true);
        lblTopRight.setDisable(true);
        lblLeft.setDisable(true);
        lblCenter.setDisable(true);
        lblRight.setDisable(true);
        lblBottomLeft.setDisable(true);
        lblBottom.setDisable(true);
        lblBottomRight.setDisable(true);
        btSurrender.setVisible(false);
    }
    
    private void ableButtons(){
        lblTopLeft.setDisable(false);
        lblTop.setDisable(false);
        lblTopRight.setDisable(false);
        lblLeft.setDisable(false);
        lblCenter.setDisable(false);
        lblRight.setDisable(false);
        lblBottomLeft.setDisable(false);
        lblBottom.setDisable(false);
        lblBottomRight.setDisable(false);
    }
}
