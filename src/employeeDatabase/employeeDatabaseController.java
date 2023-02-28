package employeeDatabase;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Controller for the employee database
 */
public class employeeDatabaseController implements Initializable {

    // FXML Elements
    @FXML private TableView<GuardModel> guardTableData;
    @FXML private TableColumn<GuardModel, Integer> guardIdNumberCol;
    @FXML private TableColumn<GuardModel, Integer> guardSeniorityCol;
    @FXML private TableColumn<GuardModel, String> guardNameCol;
    @FXML private TableColumn<GuardModel, Integer> guardAgeCol;
    @FXML private TableColumn<GuardModel, Integer> guardLastFourCol;
    @FXML private TableColumn<GuardModel, String> guardDOBCol;
    @FXML private TableColumn<GuardModel, String> guardDOECol;
    @FXML private TableColumn<GuardModel, Boolean> guardBasicClearanceCol;
    @FXML private TableColumn<GuardModel, Boolean> guardTopSecretClearanceCol;
    @FXML private TableColumn<GuardModel, Boolean> guardNonScreenerCol;
    @FXML private TableColumn<GuardModel, Boolean> guardHandWanderCol;
    @FXML private TableColumn<GuardModel, Boolean> guardFullScreenerCol;
    @FXML private TableColumn<GuardModel, String> guardAddressCol;
    @FXML private TableColumn<GuardModel, String> guardCityCol;
    @FXML private TableColumn<GuardModel, Integer> guardZipCol;
    @FXML private Label selectedGuardIdLabel;
    @FXML private Label selectedGuardNameLabel;
    @FXML private Label selectedGuardDOBLabel;
    @FXML private Label selectedGuardDOELabel;

    // Secondary Stage / Modifier Elements
    private Stage secondaryStage;
    private employeeModificationController secondaryController;
    private Pane mainPane;

    // Instance Variables
    private GuardModel selectedGuard;

    /**
     * This method indexes the guardTableData for the current selected cell and sets the respective
     * labels to the selected guard's data. Additionally, it sets the selected guard to the
     * one indexed.
     */
    public void select() {
        GuardModel currentGuard = guardTableData.getSelectionModel().getSelectedItem();
        if (currentGuard != null) {
            selectedGuardIdLabel.setText("ID: " + selectedGuard.getIdNumber());
            selectedGuardNameLabel.setText("Name: " + selectedGuard.getName());
            selectedGuardDOBLabel.setText("DOB: " + selectedGuard.getDateOfBirth());
            selectedGuardDOELabel.setText("DOE: " + selectedGuard.getDateOfEmployment());
            this.selectedGuard = currentGuard;
        } else {
            this.createTimedAlert("Invalid Selection", "Please select a valid entry", 3.0);
        }
    }

    /**
     * This method handles the loading of the data and setting the data loaded from the files and
     * setting the data to the table.
     */
    public void load() {
        File file = new File("Data/Guards");
        File[] dir = file.listFiles();
        if (dir != null) {
            ObservableList<GuardModel> guardModels = Arrays.stream(dir)
                    .filter(File::isFile)
                    .map(this::parseGuardModel)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
           if (!guardModels.isEmpty()) {
               GuardModel selectedGuard = guardModels.get(0);
               selectedGuardIdLabel.setText("ID: " + selectedGuard.getIdNumber());
               selectedGuardNameLabel.setText("Name: " + selectedGuard.getName());
               selectedGuardDOBLabel.setText("DOB: " + selectedGuard.getDateOfBirth());
               selectedGuardDOELabel.setText("DOE: " + selectedGuard.getDateOfEmployment());
           }
           guardTableData.setItems(guardModels);
           selectedGuard = guardModels.get(0);
        }
    }

    /**
     * This method handles the bringing up of the modification window while changing the states
     * of the program to the addition state.
     */
    public void addGuard() {
        secondaryController.changeState();
        if (secondaryStage.isShowing()) {
            secondaryStage.hide();
        } else {
            secondaryStage.show();
        }
        secondaryController.clearFields();
    }

    /**
     * The opener for the modify method to change data
     */
    public void modify() {
        if (!secondaryController.getState().equals("modify")) {
            secondaryController.changeState();
        }
        if (secondaryStage.isShowing()) {
            secondaryStage.hide();
        } else {
            secondaryStage.show();
            secondaryController.load(this.selectedGuard);
        }
    }

    /**
     * This method will take the selected guard, using the parseGuardFile method to find the file
     * and delete it.
     */
    public void remove() {
        File guardFile = parseGuardFile(this.selectedGuard.getIdNumber());
        try {
            Files.delete(guardFile.toPath());
            this.selectedGuard = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.load();
    }

    /**
     * This method hides the Modifier stage
     */
    public void hideModifier() {
        secondaryStage.hide();
    }

    /**
     * This method takes in a file, reads the file, and parses the guard from the file.
     * @param guardFile - A passed in file
     * @return          - The parsed guard from the file
     */
    public GuardModel parseGuardModel(File guardFile) {
        GuardModel guard = null;
        try (FileInputStream in = new FileInputStream(guardFile)){
            Properties guardProps = new Properties();
            guardProps.load(in);
            guard = new GuardModel(
                    Integer.parseInt(guardProps.getProperty("idNumber")),
                    Integer.parseInt(guardProps.getProperty("seniority")),
                    guardProps.getProperty("name"),
                    Integer.parseInt(guardProps.getProperty("age")),
                    Integer.parseInt(guardProps.getProperty("lastFour")),
                    guardProps.getProperty("dateOfBirth"),
                    guardProps.getProperty("dateOfEmployment"),
                    Boolean.valueOf(guardProps.getProperty("basicClearance")),
                    Boolean.valueOf(guardProps.getProperty("topSecretClearance")),
                    Boolean.valueOf(guardProps.getProperty("nonScreener")),
                    Boolean.valueOf(guardProps.getProperty("handWander")),
                    Boolean.valueOf(guardProps.getProperty("fullScreener")),
                    guardProps.getProperty("address"),
                    guardProps.getProperty("city"),
                    Integer.parseInt(guardProps.getProperty("zip"))
            );
        } catch (IOException e) {
            this.createAlert("Error Reading File", "Error reading file from " + guardFile);
        }
        return guard;
    }

    /**
     * This helper method takes in an idNumber and parses the list of files to return the file of
     * the guard with the selected idNumber.
     * @param idNumber  - The passed in ID Number of the guard
     * @return          - The file of the guar with the specified ID Number
     */
    public File parseGuardFile(int idNumber) {
        File file = new File("Data/Guards");
        File[] dir = file.listFiles();
        for (File guardFile : dir) {
            try (FileInputStream in = new FileInputStream(guardFile)) {
                Properties guardProps = new Properties();
                guardProps.load(in);
                if (Integer.parseInt(guardProps.getProperty("idNumber")) == idNumber) {
                    file = guardFile;
                }
            } catch (IOException e) {

            }
        }
        return file;
    }

    /**
     * Initializes the Cell Values for the table and sets the data of the table.
     * @param url Defualt passed in URL
     * @param resourceBundle passed in resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guardIdNumberCol.setCellValueFactory(new PropertyValueFactory<>("IdNumber"));
        guardSeniorityCol.setCellValueFactory(new PropertyValueFactory<>("Seniority"));
        guardNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        guardAgeCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
        guardLastFourCol.setCellValueFactory(new PropertyValueFactory<>("LastFour"));
        guardDOBCol.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));
        guardDOECol.setCellValueFactory(new PropertyValueFactory<>("DateOfEmployment"));
        guardBasicClearanceCol.setCellValueFactory(new PropertyValueFactory<>("BasicClearance"));
        guardTopSecretClearanceCol.setCellValueFactory(new PropertyValueFactory<>("TopSecretClearance"));
        guardNonScreenerCol.setCellValueFactory(new PropertyValueFactory<>("NonScreener"));
        guardHandWanderCol.setCellValueFactory(new PropertyValueFactory<>("HandWander"));
        guardFullScreenerCol.setCellValueFactory(new PropertyValueFactory<>("FullScreener"));
        guardAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        guardCityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
        guardZipCol.setCellValueFactory(new PropertyValueFactory<>("Zip"));
        this.load();
    }

    // Getters and Setters

    // Class specific getters and setters

    // Secondary Stage / Modifier getters and setters
    /**
     * This method will set the main pane of the program.
     * @param root  - The passed in Pane from the other file.
     */
    public void setMainGrid(Pane root) {
        this.mainPane = root;
    }

    /**
     * This method sets the stage of the modifier fxml file.
     * @param secondaryStage    - The passed in stage from the other file.
     */
    public void setOtherStage(Stage secondaryStage) {
        this.secondaryStage = secondaryStage;
    }

    /**
     * This method sets the other controller from the other file.
     * @param employeeModificationController    - The passed in controller from the other file.
     */
    public void setOtherController(employeeModificationController employeeModificationController) {
        this.secondaryController = employeeModificationController;
    }

    /**
     * This method returns the current selected guard.
     * @return The selected guard.
     */
    public GuardModel getSelectedGuard() {
        return this.selectedGuard;
    }

    /**
     * This method changes the selected guard to the one passed in.
     * @param selectedGuard - The selected guard.
     */
    public void setSelectedGuard(GuardModel selectedGuard) {
        this.selectedGuard = selectedGuard;
    }


    // Additional Methods

    /**
     * This method creates an alert that only stays open for a specified amount of time with a
     * given title, content, and a time.
     * @param title     - A passed in Title
     * @param content   - The passed in content text
     * @param time      - The passed in time spent open.
     */
    public void createTimedAlert(String title, String content, Double time) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.show();

        // Specifies the timeline in which the alert will stay open
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(time),
                ae -> alert.hide()));
        timeline.play();
    }

    /**
     * This method creates an alert with a specified title and content.
     * @param title     - A passed in title
     * @param content   - A passed in content text
     */
    public void createAlert(String title, String content) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
