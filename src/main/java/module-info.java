module org.example.javafxtema3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;
    requires static lombok;


    opens org.example.javafxtema3 to javafx.fxml;
    exports org.example.javafxtema3;
}