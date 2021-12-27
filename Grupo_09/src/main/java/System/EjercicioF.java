package System;

import TDAs.Tree;
import java.util.LinkedList;

public class EjercicioF {

    public static void main(String[] args) {
        Board b = new Board();
        b.insertChar(0, 2, 'x');
        b.insertChar(0, 1, '0');
        b.insertChar(2, 2, '0');
        System.out.println(b.getCoordinatesOf('x'));
        System.out.println(b.getCoordinatesOf('0'));
        System.out.println(b);
        b.winOrLose('x','0');
        System.out.print(b.generateMinimax('x', 'c'));
        System.out.print(b.minimax('x', 'c'));
    }
}
