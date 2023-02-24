package employeeDatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class Driver extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader employeeDatabaseLoader = new FXMLLoader();
        Parent root = employeeDatabaseLoader.load(Objects.requireNonNull(getClass().getResource("employeeDatabase.fxml")).openStream());
        primaryStage.setTitle("Employee Database");
        primaryStage.setScene(new Scene(root));
        employeeDatabaseController employeeDatabaseController = employeeDatabaseLoader.getController();
        employeeDatabaseController.setMainGrid((Pane) root);
        employeeDatabaseController.load();
        primaryStage.show();

        FXMLLoader employeeModificationLoader = new FXMLLoader();
        Stage secondaryStage = new Stage();
        Parent secondaryRoot = employeeModificationLoader.load(Objects.requireNonNull(getClass().getResource("employeeModification.fxml")).openStream());
        employeeModificationController employeeModificationController = employeeModificationLoader.getController();
        GuardModel selectedGuard = employeeDatabaseController.getSelectedGuard();
        secondaryStage.setTitle("Modifying Guard ID: " + selectedGuard.getIdNumber() + " Guard Name: " + selectedGuard.getName());
        secondaryStage.setScene(new Scene(secondaryRoot));

        employeeDatabaseController.setOtherStage(secondaryStage);
        employeeDatabaseController.setOtherController(employeeModificationController);

        employeeModificationController.setMainStage(primaryStage);
        employeeModificationController.setMainController(employeeDatabaseController);
    }
}