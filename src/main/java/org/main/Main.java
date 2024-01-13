package org.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    FXMLLoader fxmlLoader;
    Stage mainStage;

    /**
     * This method is the main entry point for the program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is the start method for javafx
     * @param stage - Default stage
     * @throws Exception - If the fxml file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws Exception {
        fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("/helloWorld.fxml"));
        Scene scene = new Scene(root);
        this.mainStage = stage;
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }
}
