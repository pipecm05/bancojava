module uniquindio.edu.co {
    requires javafx.controls;
    requires javafx.fxml;

    opens uniquindio.edu.co to javafx.fxml;
    exports uniquindio.edu.co;
}
