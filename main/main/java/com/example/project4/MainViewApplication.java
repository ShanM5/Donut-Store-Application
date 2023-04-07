package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * A class that starts the application
 * @author Hieu Nguyen, Shan Malik
 */
public class MainViewApplication extends Application {

    /**
     * method to start
     * @param stage the first stage that is shown, the main view
     * @throws IOException throws errors for if file is not found
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainViewApplication.class.getResource("MainView.fxml"));
        int dist = 580;
        Scene scene = new Scene(fxmlLoader.load(), dist, dist);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method to launch the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}