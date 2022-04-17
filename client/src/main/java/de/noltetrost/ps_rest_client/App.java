package de.noltetrost.ps_rest_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Artikel");
        GridPane myPane = FXMLLoader.load(getClass().getResource("Tabelle.fxml"));
        primaryStage.setResizable(false);
        Scene myScene = new Scene(myPane);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {  	
        launch(args);
    }
}
