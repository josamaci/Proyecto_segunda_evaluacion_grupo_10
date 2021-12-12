/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.f;

import java.util.ArrayList;

public class EjercicioF {

    public static void main(String[] args) {
        Board b = new Board();
        b.insertChar(0, 2, 'x');
        b.insertChar(0, 1, '0');
        b.insertChar(0, 0, 'x');
        b.insertChar(2, 2, '0');
        System.out.println(b.getCoordinatesOf('x'));
        System.out.println(b.getCoordinatesOf('0'));
        System.out.println(b);
        b.winOrLose('x','0');
        System.out.println(b.waysToWin('x'));
        
        ArrayList<Board> boards = b.generateAlternatives('x');
        for(Board boa:boards){
            System.out.print(boa);
            System.out.println(boa.waysToWin('x'));
            System.out.println(boa.waysToWin('0'));
        }
        
    }
}
