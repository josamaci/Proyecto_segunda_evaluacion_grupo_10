
package System;

public class Reader {
    private static char you;
    private static char rival;
    private static boolean starting;
    private static boolean gameResult;

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
