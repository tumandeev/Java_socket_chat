module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

//    opens client.javafx to javafx.fxml;
//    exports client.javafx;
    exports client;
    opens client to javafx.fxml;
    exports client.controllers;
    opens client.controllers to javafx.fxml;
}