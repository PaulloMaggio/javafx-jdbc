module java_jdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens gui to javafx.fxml;
    exports gui;

    opens application to javafx.graphics, javafx.fxml;
}