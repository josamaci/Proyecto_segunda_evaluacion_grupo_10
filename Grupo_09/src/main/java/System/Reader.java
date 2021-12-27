
package System;

public class Reader {
    private static char you = '0';
    private static char rival = 'x';
    private static boolean starting = false;
    private static boolean gameResult = false;

    public static boolean getGameResult() {
        return gameResult;
    }

    public static void setGameResult(boolean gameResult) {
        Reader.gameResult = gameResult;
    }
    
    public static char getYou() {
        return you;
    }

    public static void setYou(char you) {
        Reader.you = you;
    }

    public static char getRival() {
        return rival;
    }

    public static void setRival(char rival) {
        Reader.rival = rival;
    }

    public static boolean getStarting() {
        return starting;
    }

    public static void setStarting(boolean starting) {
        Reader.starting = starting;
    }
    
}
