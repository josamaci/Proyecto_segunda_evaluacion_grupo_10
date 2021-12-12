module espol.grupo_10 {
    requires javafx.controls;
    requires javafx.fxml;

    opens espol.grupo_10 to javafx.fxml;
    exports espol.grupo_10;
}
