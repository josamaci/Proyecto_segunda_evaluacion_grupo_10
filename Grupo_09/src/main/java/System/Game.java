package System;

import TDAs.NodeTree;
import TDAs.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Game {
    private Tree<Board> originalBoard;
    private Tree<Board> actualBoard;
    private int gameMode;
    private Player p1;
    private Player p2;
    private String result;

    public Game(Tree<Board> board, Player p1, Player p2, int gameMode) {
        this.originalBoard = board;
        this.actualBoard = this.originalBoard;
        this.gameMode = gameMode;
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public Game(Board board, Player p1, Player p2, int gameMode) {
        this.originalBoard = new Tree<Board>(new NodeTree<>(board));
        this.actualBoard = this.originalBoard;
        this.gameMode = gameMode;
        this.p1 = p1;
        this.p2 = p2;
    }

    public Tree<Board> getOriginalBoard() {
        return originalBoard;
    }

    public void setOriginalBoard(Tree<Board> originalBoard) {
        this.originalBoard = originalBoard;
    }

    public Tree<Board> getActualBoard() {
        return actualBoard;
    }

    public void setActualBoard(Tree<Board> actualBoard) {
        this.actualBoard = actualBoard;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }
    
    public void insertChar(Coordinate c){
        generateAlternatives(whoTurn());
        Tree<Board> t = new Tree();
        Board b = new Board(actualBoard.getRoot().getContent().getBoard());
        b.insertChar(c,whoTurn().getCharacter());
        t.setRoot(new NodeTree<>(b));
        for(Tree<Board> tb : actualBoard.getChildren()){
            if(tb.getRoot().getContent().equals(b))
            actualBoard = tb;
        }
        switchTurn();
        if(whoTurn().equals(p2) && p2.getIsPC()){
            generateAlternatives(whoTurn());
        }
        winOrLose();
    }

    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public void winOrLose(){
        result = "STILL PLAYING";
        if(winner(p1)){
            result = p1.getName()+" WIN";
        }else if(winner(p2)){
            if(p2.getIsPC()){
                result = p1.getName()+" LOSE";
            }else{
                result = p2.getName()+" WIN";
            }
        }else if (!actualBoard.getRoot().getContent().isNotComplete()){
            result = "DRAW";
        }
    }
    
    private boolean winner(Player eval){
        boolean win = false;
        ArrayList<Coordinate> coordsEval = actualBoard.getRoot().getContent().getCoordinatesOf(eval.getCharacter()); 
        ArrayList<ArrayList<Coordinate>> arrayWins = actualBoard.getRoot().getContent().winPossibilities();
        for (ArrayList<Coordinate> c: arrayWins){
            if(coordsEval.containsAll(c)){
                win = true;
            }
        }
        return win;
    }
    
    public void generateAlternatives(Player eval){
        if(actualBoard!=originalBoard){
            LinkedList<Tree<Board>> b = actualBoard.getRoot().getContent().generateAlternatives(eval.getCharacter());
            actualBoard.getRoot().setChildren(b);
        }else{
            LinkedList<Tree<Board>> b = originalBoard.getRoot().getContent().generateAlternatives(eval.getCharacter());
            originalBoard.getRoot().setChildren(b);
        }
    }
    
    public Map<Tree<Board>, Integer> generateMinimax(Player you, Player rival){
        int i = -100;
        Map<Tree<Board>, Integer> mapYou = new HashMap<>();
        generateAlternatives(you);
        if(actualBoard.getChildren().size()>1){
            for(Tree<Board> boa: actualBoard.getChildren()){
                int j = 0;
                LinkedList<Tree<Board>> alternativesRival = boa.getRoot().getContent().generateAlternatives(rival.getCharacter());
                j = alternativesRival.get(0).getRoot().getContent().boardUtility(you.getCharacter(), rival.getCharacter());
                for(Tree<Board> board: alternativesRival){
                    mapYou.put(boa, j);
                    if(board.getRoot().getContent().boardUtility(you.getCharacter(), rival.getCharacter())<j){
                        j = board.getRoot().getContent().boardUtility(you.getCharacter(), rival.getCharacter());
                        mapYou.replace(boa,j);
                    }
                }
            }
        }else if(actualBoard.getChildren().size()==1){
            mapYou.put(actualBoard.getChildren().get(0),0);
        }
        return mapYou;
    }
    
    public Tree<Board> minimax(Player you, Player rival){
        Map<Tree<Board>, Integer> mapYou = this.generateMinimax(p2, p1);
        Tree<Board> b = null;
        if(mapYou.size()>0){
            int content = -10;
            for(int i: mapYou.values()){
                if(i>content){
                    content = i;
                }
            }
            for(Tree<Board> boa: mapYou.keySet()){
                if(mapYou.get(boa).equals(content)){
                    b = boa;
                }
            }
        }
        return b;
    }
    
    //This is only for PC
    public Coordinate minimaxCoord(){
        Coordinate coords = new Coordinate();
        if(whoTurn().getIsPC()){
            ArrayList<Coordinate> newCoords = this.minimax(whoTurn(), nextTurn()).getRoot().getContent().getCoordinatesOf(p2.getCharacter());
            ArrayList<Coordinate> oldCoords = actualBoard.getRoot().getContent().getCoordinatesOf(p2.getCharacter());
            if(newCoords!=null && oldCoords!=null){
                for(Coordinate c: newCoords){
                    if(!oldCoords.contains(c)){
                        coords = c;

                    }
                }
            }
        }
        return coords;
    }
    
    public void switchTurn(){
        if(p1.getIsTurn()){
            p1.setIsTurn(false);
            p2.setIsTurn(true);
        }else{
            p1.setIsTurn(true);
            p2.setIsTurn(false);
        }
    }
    
    public Player whoTurn(){
        if(p1.getIsTurn()){
            return p1;
        }else{
            return p2;
        }
    }
    
    public Player nextTurn(){
        if(p1.getIsTurn()){
            return p2;
        }else{
            return p1;
        }
    }
}
