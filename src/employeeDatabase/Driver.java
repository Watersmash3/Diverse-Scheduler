package employeeDatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Driver extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(Objects.requireNonNull(getClass().getResource("employeeDatabase.fxml")).openStream());
        stage.setTitle("Employee Database");
        stage.setScene(new Scene(root));
        employeeDatabaseController controller = loader.getController();
        controller.load();
        stage.show();
    }
}