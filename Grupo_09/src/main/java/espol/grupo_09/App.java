package espol.grupo_09;

import System.FileManager;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainMenu"), 360, 640);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        if (FileManager.loadGame() != null) {
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setTitle("Load...");
            a.setContentText("Wanna reload your last game?");
            Optional<ButtonType> confi = a.showAndWait();
            if (confi.get() == ButtonType.OK) {
                FileManager.loadGame();
            }
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void stop() throws IOException {
        FileManager.saveGame();
    }
}
