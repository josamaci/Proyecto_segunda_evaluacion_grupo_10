
package System;

public class Reader {
    private static char player = 'O';
    private static char pc = 'x';
    private static boolean starting = false;
    private static int gameResult = 2;
    private static int gameMode = 0;

    public static char getPc() {
        return pc;
    }

    public static void setPc(char pc) {
        Reader.pc = pc;
    }

    public static int getGameMode() {
        return gameMode;
    }

    public static void setGameMode(int gameMode) {
        Reader.gameMode = gameMode;
    }
    
    
    public static int getGameResult() {
        return gameResult;
    }

    public static void setGameResult(int gameResult) {
        Reader.gameResult = gameResult;
    }
    
    public static char getPlayer() {
        return player;
    }

    public static void setPlayer(char player) {
        Reader.player = player;
    }

    public static boolean getStarting() {
        return starting;
    }

    public static void setStarting(boolean starting) {
        Reader.starting = starting;
    }
    
}
