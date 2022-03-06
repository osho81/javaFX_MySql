module com.example.javafxmysql {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    opens com.javafxmysql.login to javafx.fxml;
    exports com.javafxmysql.login;
}