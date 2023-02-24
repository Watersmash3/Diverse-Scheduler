package employeeDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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

    public void select() {

    }

    /**
     * Helper method to load all the guards into an observable list from the guards folder
     * which holds all guard information
     * @return Observable List of Guards
     */
    public ObservableList<GuardModel> load() {
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
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            // TODO
        } catch (IOException e) {
            System.out.println("Error");
            // TODO
        }

        return guardsModel;
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

        tableData.setItems(load());
    }
}
