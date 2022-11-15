package agh.dp.decorator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GUIController customControl = new GUIController();

        stage.setScene(new Scene(customControl));
        stage.setTitle("Decorate!");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}