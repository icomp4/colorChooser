module org.example.colorchooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.colorchooser to javafx.fxml;
    exports org.example.colorchooser;
}