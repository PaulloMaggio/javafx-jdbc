module java_jdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires transitive javafx.graphics; 

    opens gui to javafx.fxml;
    opens model.entities to javafx.base, javafx.fxml;
    opens application to javafx.graphics, javafx.fxml;

    exports gui;
    exports application;
    exports model.entities;
    exports model.services;
}