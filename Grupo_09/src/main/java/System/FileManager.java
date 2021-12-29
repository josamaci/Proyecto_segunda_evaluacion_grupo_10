/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author kevin
 */
public class FileManager {

    public static void saveGame() throws FileNotFoundException, IOException {
        Game g = new Game(new Board(), Reader.getPlayer1(), Reader.getPlayer2(), Reader.getGameMode());
        try {
            ObjectOutputStream charger = new ObjectOutputStream(new FileOutputStream("src/main/resources/savedata/game.bin"));
            charger.writeObject(g);
            charger.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not loaded");
        }
    }

    public static Game loadGame() {
        try {
            ObjectInputStream loader = new ObjectInputStream(new FileInputStream("src/main/resources/savedata/game.bin"));
            Game g = (Game) loader.readObject();
            loader.close();
            return g;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("File corrupted");
        }
        return null;
    }

}
