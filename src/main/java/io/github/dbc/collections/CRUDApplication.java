package io.github.dbc.collections;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class CRUDApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CRUDApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),
                Screen.getPrimary().getBounds().getMinX(),
                Screen.getPrimary().getBounds().getMinY());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}