
package System;

public class Reader {
    private static char player = '0';
    private static char pc = 'x';
    private static boolean starting = false;
    private static boolean gameResult = false;

    public static boolean getGameResult() {
        return gameResult;
    }

    public static void setGameResult(boolean gameResult) {
        Reader.gameResult = gameResult;
    }
    
    public static char getPlayer() {
        return player;
    }

    public static void setPlayer(char player) {
        Reader.player = player;
    }

    public static char getPC() {
        return pc;
    }

    public static void setPC(char pc) {
        Reader.pc = pc;
    }

    public static boolean getStarting() {
        return starting;
    }

    public static void setStarting(boolean starting) {
        Reader.starting = starting;
    }
    
}
