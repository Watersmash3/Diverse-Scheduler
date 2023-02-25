package employeeDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * The Controller for the employee database
 */
public class employeeDatabaseController implements Initializable {
    @FXML
    private TableView<GuardModel> tableData;
    @FXML
    private TableColumn<GuardModel, Integer> idNumber;
    @FXML
    private TableColumn<GuardModel, String> name;
    @FXML
    private TableColumn<GuardModel, Integer> age;
    @FXML
    private TableColumn<GuardModel, String> dateEmployed;
    @FXML
    private TableColumn<GuardModel, Boolean> basicClearance;
    @FXML
    private TableColumn<GuardModel, Boolean> topSecretClearance;
    @FXML
    private TableColumn<GuardModel, Boolean> nonScreener;
    @FXML
    private TableColumn<GuardModel, Boolean> handWander;
    @FXML
    private TableColumn<GuardModel, Boolean> fullScreener;
    @FXML
    private TableColumn<GuardModel, String> location;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    private Stage secondaryStage;
    private employeeModificationController secondaryController;
    private Pane mainPane;

    private GuardModel selectedGuard;

    /**
     * Selects the guard from the table data
     */
    public void select() {
        try {
            GuardModel guardModel = tableData.getSelectionModel().getSelectedItem();
            idLabel.setText("ID: " + guardModel.getIdNumber());
            nameLabel.setText("Name: " + guardModel.getName());
            selectedGuard = guardModel;
        } catch (NullPointerException e) {

        }
    }

    /**
     * Helper method to load all the guards into an observable list from the guards folder
     * which holds all guard information
     * @return Observable List of Guards
     */
    public void load() {
        ObservableList<GuardModel> guardsModel = FXCollections.observableArrayList();
        File file = new File("Data/Guards");
        File[] dir = file.listFiles();
        try {
            if (dir != null) {
                for (File guardFile : dir) {
                    Properties guardProps = new Properties();
                    guardProps.load(new FileInputStream(guardFile));
                    GuardModel g = new GuardModel(Integer.parseInt(guardProps.getProperty("idNumber")),
                            guardProps.getProperty("name"),
                            Integer.parseInt(guardProps.getProperty("age")),
                            guardProps.getProperty("dateEmployed"),
                            Boolean.valueOf(guardProps.getProperty("basicClearance")),
                            Boolean.valueOf(guardProps.getProperty("topSecretClearance")),
                            Boolean.valueOf(guardProps.getProperty("nonScreener")),
                            Boolean.valueOf(guardProps.getProperty("handWander")),
                            Boolean.valueOf(guardProps.getProperty("fullScreener")),
                            guardProps.getProperty("location")
                            );
                    guardsModel.add(g);
                    if (selectedGuard == null) {
                        idLabel.setText("ID: " + g.getIdNumber());
                        nameLabel.setText("Name: " + g.getName());
                        selectedGuard = g;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            // TODO
        } catch (IOException e) {
            System.out.println("Error");
            // TODO
        }

        tableData.setItems(guardsModel);
    }

    /**
     * Initializes the Cell Values for the table and sets the data of the table.
     * @param url Defualt passed in URL
     * @param resourceBundle passed in resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idNumber.setCellValueFactory(new PropertyValueFactory<>("IdNumber"));
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        dateEmployed.setCellValueFactory(new PropertyValueFactory<>("DateEmployed"));
        basicClearance.setCellValueFactory(new PropertyValueFactory<>("BasicClearance"));
        topSecretClearance.setCellValueFactory(new PropertyValueFactory<>("TopSecretClearance"));
        nonScreener.setCellValueFactory(new PropertyValueFactory<>("NonScreener"));
        handWander.setCellValueFactory(new PropertyValueFactory<>("HandWander"));
        fullScreener.setCellValueFactory(new PropertyValueFactory<>("FullScreener"));
        location.setCellValueFactory(new PropertyValueFactory<>("Location"));

        this.load();
    }

    /**
     * Getter for the selected guard
     * @return the selected guard
     */
    public GuardModel getSelectedGuard() {
        return this.selectedGuard;
    }

    /**
     * Sets the selectedGuard variable to the passed in guard
     * @param selectedGuard the passed in guard
     */
    public void setSelectedGuard(GuardModel selectedGuard) {
        this.selectedGuard = selectedGuard;
    }

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
     * Takes a file and returns a guardModel from the file
     * @param file the passed in properties file containing the guard data
     * @return the guardModel from the file
     */
    public GuardModel parseGuardModel(File file) {
        GuardModel g = null;
        try {
            Properties guardProps = new Properties();
            guardProps.load(new FileInputStream(file));
            g = new GuardModel(Integer.parseInt(guardProps.getProperty("idNumber")),
                    guardProps.getProperty("name"),
                    Integer.parseInt(guardProps.getProperty("age")),
                    guardProps.getProperty("dateEmployed"),
                    Boolean.valueOf(guardProps.getProperty("basicClearance")),
                    Boolean.valueOf(guardProps.getProperty("topSecretClearance")),
                    Boolean.valueOf(guardProps.getProperty("nonScreener")),
                    Boolean.valueOf(guardProps.getProperty("handWander")),
                    Boolean.valueOf(guardProps.getProperty("fullScreener")),
                    guardProps.getProperty("location")
            );
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return g;
    }

    /**
     * The opener for the modify method to change data
     */
    public void modify() {
        if (!secondaryController.getState().equals("modify")) {
            secondaryController.changeState();
            if (secondaryStage.isShowing()) {
                secondaryStage.hide();
            } else {
                secondaryStage.show();
                secondaryController.load(this.selectedGuard);
            }
        } else {
            if (secondaryStage.isShowing()) {
                secondaryStage.hide();
            } else {
                secondaryStage.show();
                secondaryController.load(this.selectedGuard);
            }
        }

    }

    /**
     * Removes and Deletes the selected file
     */
    public void remove() {
        File file = new File("Data/Guards");
        File[] dir = file.listFiles();
        try {
            if (dir != null) {
                for (File guardFile : dir) {
                    Properties guardProps = new Properties();
                    try (FileInputStream in = new FileInputStream(guardFile)) {
                        guardProps.load(in);
                    }
                    if (Integer.parseInt(guardProps.getProperty("idNumber")) == this.selectedGuard.getIdNumber()) {
                        file = guardFile;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error1");
            // TODO
        } catch (IOException e) {
            System.out.println("Error");
            // TODO
        }
        try {
            Files.delete(file.toPath());
            this.selectedGuard = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.load();
    }

    /**
     * Sets the main pane of the program
     * @param root the passed in pane
     */
    public void setMainGrid(Pane root) {
        this.mainPane = root;
    }

    /**
     * Setter of the secondary Stage
     * @param secondaryStage the passed in stage
     */
    public void setOtherStage(Stage secondaryStage) {
        this.secondaryStage = secondaryStage;
    }

    /**
     * Setter of the other controller
     * @param employeeModificationController the passed in controller
     */
    public void setOtherController(employeeModificationController employeeModificationController) {
        this.secondaryController = employeeModificationController;
    }

    public void hideModifier() {
        secondaryStage.hide();
    }
}
