package com.javafxmysql.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Practise project for improving java/javaFx/SceneBuilder with MySql
// Basis for this project: https://www.youtube.com/watch?v=DH3dWzmkT5Y


import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400); // Aligned with sceneBuilder/fxml

        stage.initStyle(StageStyle.UNDECORATED); // No upper frame
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}