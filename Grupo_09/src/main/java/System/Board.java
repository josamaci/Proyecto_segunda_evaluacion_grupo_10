package System;

import TDAs.NodeTree;
import TDAs.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Board {
    Character board[][] = new Character[3][3];

    public Board() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }
    }
    
    public Board(Character board[][]) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.board[i][j] = board[i][j];
            }
        }
    }
        
    public Character[][] getBoard() {
        return board;
    }

    public void setBoard(Character[][] board) {
        this.board = board;
    }
    
    public String insertChar(Coordinate c, Character content){
        board[c.getX()][c.getY()] = content;
        return winOrLose();
    }
    
    public ArrayList<Coordinate> getCoordinatesOf(Character content){
        ArrayList<Coordinate> coords = new ArrayList<>();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(content.equals(board[i][j])){
                    coords.add(new Coordinate(i,j));
                }
            }
        }
    return coords;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i=0; i<3; i++){
            s+="\n";
            for(int j=0; j<3; j++){
                s+=board[i][j]+" ";
            }
        }
        s+="\n";
        return s; 
    }
    
    public String winOrLose(){
        String result = "STILL PLAYING";
        int i = 3;
        if(winner(Reader.getPlayer())){
            i = 0;
        }else if(winner(Reader.getPC())){
            i = 1;
        }else if (!isNotComplete()){
            i = 2;
        }
        switch(i){
            case 0:
                result = "YOU WIN";
                break;
            case 1:
                result = "YOU LOSE";
                break;
            case 2:
                result = "DRAW";
                break;
        }
        return result;
    }
    
    private boolean winner(Character eval){
        boolean win = false;
        ArrayList<Coordinate> coordsEval = this.getCoordinatesOf(eval); 
        ArrayList<ArrayList<Coordinate>> array = winPossibilities();
        for (ArrayList<Coordinate> c: array){
            if(coordsEval.containsAll(c)){
                System.out.println(c);
                win = true;
            }
        }
        return win;
    }
    
    private ArrayList<ArrayList<Coordinate>> winPossibilities(){
        ArrayList<ArrayList<Coordinate>> winPos = new ArrayList<>();
            ArrayList<Coordinate> winPos1 = new ArrayList<>();
            winPos1.add(new Coordinate(0,0));
            winPos1.add(new Coordinate(0,1));
            winPos1.add(new Coordinate(0,2));
            
            ArrayList<Coordinate> winPos2 = new ArrayList<>();
            winPos2.add(new Coordinate(1,0));
            winPos2.add(new Coordinate(1,1));
            winPos2.add(new Coordinate(1,2));
            
            ArrayList<Coordinate> winPos3 = new ArrayList<>();
            winPos3.add(new Coordinate(2,0));
            winPos3.add(new Coordinate(2,1));
            winPos3.add(new Coordinate(2,2));
            
            ArrayList<Coordinate> winPos4 = new ArrayList<>();
            winPos4.add(new Coordinate(0,0));
            winPos4.add(new Coordinate(1,1));
            winPos4.add(new Coordinate(2,2));
            
            ArrayList<Coordinate> winPos5 = new ArrayList<>();
            winPos5.add(new Coordinate(0,2));
            winPos5.add(new Coordinate(1,1));
            winPos5.add(new Coordinate(2,0));
            
            ArrayList<Coordinate> winPos6 = new ArrayList<>();
            winPos6.add(new Coordinate(0,0));
            winPos6.add(new Coordinate(1,0));
            winPos6.add(new Coordinate(2,0));
            
            ArrayList<Coordinate> winPos7 = new ArrayList<>();
            winPos7.add(new Coordinate(0,1));
            winPos7.add(new Coordinate(1,1));
            winPos7.add(new Coordinate(2,1));
            
            ArrayList<Coordinate> winPos8 = new ArrayList<>();
            winPos8.add(new Coordinate(0,2));
            winPos8.add(new Coordinate(1,2));
            winPos8.add(new Coordinate(2,2));
            
            winPos.add(winPos1);
            winPos.add(winPos2);
            winPos.add(winPos3);
            winPos.add(winPos4);
            winPos.add(winPos5);
            winPos.add(winPos6);
            winPos.add(winPos7);
            winPos.add(winPos8);
            
        return winPos;
    }

    private boolean isNotComplete() {
        return contains(' ');
    }
    
    private boolean contains(Character c){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j].equals(c)){
                    return true;
                }
            }
        }
    return false;
    }
    
    public LinkedList<Tree<Board>> generateAlternatives(Character eval){
        LinkedList<Tree<Board>> b = new LinkedList<>();
            for(Coordinate c:getCoordinatesOf(' ')){
                Board bi = new Board(this.board);
                bi.insertChar(c, eval);
                Tree<Board> t = new Tree<>(new NodeTree<>(bi));
                b.add(t);
            }
        return b;
    }
    
    private int waysToWin(Character c){
        int i = 0;
        ArrayList<Coordinate> coords = this.getCoordinatesOf(c);
        ArrayList<Coordinate> coordsV = this.getCoordinatesOf(' ');
        coords.addAll(coordsV);
        ArrayList<ArrayList<Coordinate>> array = winPossibilities();
        for(ArrayList<Coordinate> t: array){
            if(coords.containsAll(t)){
                i++;
            }
        }
    return i;
    }
    
    private int boardUtility(Character you, Character rival){
        return waysToWin(you) - waysToWin(rival);
    }
    
    public Map<Tree<Board>, Integer> generateMinimax(Character you, Character rival){
        int i = -100;
        LinkedList<Tree<Board>> alternativesYou = this.generateAlternatives(you);
        Map<Tree<Board>, Integer> mapYou = new HashMap<>();
        for(Tree<Board> boa: alternativesYou){
            int j = 0;
            LinkedList<Tree<Board>> alternativesRival = boa.getRoot().getContent().generateAlternatives(rival);
            j = alternativesRival.get(0).getRoot().getContent().boardUtility(you, rival);
            for(Tree<Board> board: alternativesRival){
                mapYou.put(boa, j);
                if(board.getRoot().getContent().boardUtility(you, rival)<j){
                    j = board.getRoot().getContent().boardUtility(you, rival);
                    mapYou.replace(boa,j);
                }
            }
        }
        return mapYou;
    }
    
    public Board minimax(Character you, Character rival){
        Map<Tree<Board>, Integer> mapYou = this.generateMinimax(you, rival);
        int content = -10;
        Board b = null;
        for(int i: mapYou.values()){
            if(i>content){
                content = i;
            }
        }
        for(Tree<Board> boa: mapYou.keySet()){
            if(mapYou.get(boa).equals(content)){
                b = new Board(boa.getRoot().getContent().getBoard());
            }
        }
        return b;
    }
    
    //This is only for PC
    public Coordinate minimaxCoord(){
        Coordinate coords = null;
        ArrayList<Coordinate> newCoords = this.minimax(Reader.getPC(), Reader.getPlayer()).getCoordinatesOf(Reader.getPC());
        ArrayList<Coordinate> oldCoords = this.getCoordinatesOf(Reader.getPC());
        for(Coordinate c: newCoords){
            if(!oldCoords.contains(c)){
                coords = c;
            }
        }
        return coords;
    }
}
