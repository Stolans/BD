module com.example.BD {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;
    requires java.desktop;

    opens com.example.bd to javafx.fxml;
    exports com.example.bd;
}
