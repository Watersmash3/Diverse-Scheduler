package employeeDatabase;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Properties;

/**
 * The employee modification controller
 */
public class employeeModificationController {
    @FXML private Label guardID;
    @FXML private TextField guardIDField;
    @FXML private Label guardName;
    @FXML private TextField guardNameField;
    @FXML private Label guardAge;
    @FXML private TextField guardAgeField;
    @FXML private Label guardLastFour;
    @FXML private TextField guardLastFourField;
    @FXML private Label guardDOE;
    @FXML private TextField guardDOEField;
    @FXML private Label guardDOB;
    @FXML private TextField guardDOBField;
    @FXML private Label guardBasic;
    @FXML private CheckBox guardBasicField;
    @FXML private Label guardTopSecret;
    @FXML private CheckBox guardTopSecretField;
    @FXML private Label guardNonScreener;
    @FXML private CheckBox guardNonScreenerField;
    @FXML private Label guardHandWander;
    @FXML private CheckBox guardHandWanderField;
    @FXML private Label guardFullScreener;
    @FXML private CheckBox guardFullScreenerField;
    @FXML private Label guardAddress;
    @FXML private TextField guardAddressField;
    @FXML private Label guardCity;
    @FXML private TextField guardCityField;
    @FXML private Label guardZip;
    @FXML private TextField guardZipField;
    @FXML private Button applyButton;

    private Stage primaryStage;
    private employeeDatabaseController primaryController;
    private GuardModel selectedGuard;
    private String state = "modify";

    /**
     * The apply method, which takes the data from the different fields and sets them to the file
     */
    public void apply() {
        File file = null;
        if (state.equals("modify")) {
            file = new File("Data/Guards");
            File[] dir = file.listFiles();
            try {
                if (dir != null) {
                    for (File guardFile : dir) {
                        Properties guardProps = new Properties();
                        guardProps.load(new FileInputStream(guardFile));
                        if (Integer.parseInt(guardProps.getProperty("idNumber")) == this.selectedGuard.getIdNumber()) {
                            file = guardFile;
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
        } else {
            String str = String.valueOf(this.guardNameField.getText());
            file = new File("Data/Guards/" +  str.replaceAll(" ", "_").toLowerCase() + ".properties");
            primaryController.hideModifier();
        }
        try (PrintWriter out = new PrintWriter(file)) {
            out.print("idNumber=" + this.guardIDField.getText() + "\n");
            out.print("seniority=" + 0 + "\n");
            out.print("name=" + this.guardNameField.getText() + "\n");
            out.print("age=" + this.guardAgeField.getText() + "\n");
            out.print("lastFour=" + this.guardLastFourField.getText() + "\n");
            out.print("dateOfBirth=" + this.guardDOBField.getText() + "\n");
            out.print("dateOfEmployment=" + this.guardDOEField.getText() + "\n");
            out.print("basicClearance=" + this.guardBasicField.isSelected() + "\n");
            out.print("topSecretClearance=" + this.guardTopSecretField.isSelected() + "\n");
            out.print("nonScreener=" + this.guardNonScreenerField.isSelected() + "\n");
            out.print("handWander=" + this.guardHandWanderField.isSelected() + "\n");
            out.print("fullScreener=" + this.guardFullScreenerField.isSelected() + "\n");
            out.print("address=" + this.guardAddressField.getText() + "\n");
            out.print("city=" + this.guardCityField.getText() + "\n");
            out.print("zip=" + this.guardZipField.getText() + "\n");
        } catch (FileNotFoundException e) {

        }
        this.selectedGuard = null;
        primaryController.load();
        this.load(primaryController.parseGuardModel(file));
    }

    /**
     * Closes the modification window
     */
    public void cancel() {
        primaryController.modify();
    }

    /**
     * Takes the passed in guardModel and sets all the pertinent data of the modifier window
     * @param guardModel the passed in guardModel
     */
    public void load(GuardModel guardModel) {
        guardID.setText(String.valueOf(guardModel.getIdNumber()));
        guardIDField.setText(String.valueOf(guardModel.getIdNumber()));
        guardName.setText(guardModel.getName());
        guardNameField.setText(guardModel.getName());
        guardAge.setText(String.valueOf(guardModel.getAge()));
        guardAgeField.setText(String.valueOf(guardModel.getAge()));
        guardLastFour.setText(String.valueOf(guardModel.getLastFour()));
        guardLastFourField.setText(String.valueOf(guardModel.getLastFour()));
        guardDOE.setText(guardModel.getDateOfEmployment());
        guardDOEField.setText(guardModel.getDateOfEmployment());
        guardDOB.setText(guardModel.getDateOfBirth());
        guardDOBField.setText(guardModel.getDateOfBirth());
        guardBasic.setText(String.valueOf(guardModel.isBasicClearance()));
        guardBasicField.setSelected(guardModel.isBasicClearance());
        guardTopSecret.setText(String.valueOf(guardModel.isTopSecretClearance()));
        guardTopSecretField.setSelected(guardModel.isTopSecretClearance());
        guardNonScreener.setText(String.valueOf(guardModel.isNonScreener()));
        guardNonScreenerField.setSelected(guardModel.isNonScreener());
        guardHandWander.setText(String.valueOf(guardModel.isHandWander()));
        guardHandWanderField.setSelected(guardModel.isHandWander());
        guardFullScreener.setText(String.valueOf(guardModel.isFullScreener()));
        guardFullScreenerField.setSelected(guardModel.isFullScreener());
        guardAddress.setText(String.valueOf(guardModel.getAddress()));
        guardAddressField.setText(String.valueOf(guardModel.getAddress()));
        guardCity.setText(guardModel.getCity());
        guardCityField.setText(guardModel.getCity());
        guardZip.setText(String.valueOf(guardModel.getZip()));
        guardZipField.setText(String.valueOf(guardModel.getZip()));
        this.selectedGuard = guardModel;
    }

    /**
     * Changes the state and sets the proper visibilities
     */
    public void changeState() {
        if (state.equals("modify")) {
            guardID.setVisible(false);
            guardName.setVisible(false);
            guardAge.setVisible(false);
            guardLastFour.setVisible(false);
            guardDOE.setVisible(false);
            guardDOB.setVisible(false);
            guardBasic.setVisible(false);
            guardTopSecret.setVisible(false);
            guardNonScreener.setVisible(false);
            guardHandWander.setVisible(false);
            guardFullScreener.setVisible(false);
            guardAddress.setVisible(false);
            guardCity.setVisible(false);
            guardZip.setVisible(false);
            applyButton.setText("Add Guard");
            state = "add";
        } else {
            guardID.setVisible(true);
            guardName.setVisible(true);
            guardAge.setVisible(true);
            guardLastFour.setVisible(true);
            guardDOE.setVisible(true);
            guardDOB.setVisible(true);
            guardBasic.setVisible(true);
            guardTopSecret.setVisible(true);
            guardNonScreener.setVisible(true);
            guardHandWander.setVisible(true);
            guardFullScreener.setVisible(true);
            guardAddress.setVisible(true);
            guardCity.setVisible(true);
            guardZip.setVisible(true);
            applyButton.setText("Update Guard");
            state = "modify";
        }
    }

    /**
     * Setter of the primary Stage
     * @param primaryStage the passed in stage
     */
    public void setMainStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Setter of the primary Controller
     * @param employeeDatabaseController the passed in controller
     */
    public void setMainController(employeeDatabaseController employeeDatabaseController) {
        this.primaryController = employeeDatabaseController;
    }

    /**
     * Returns the state of the controller
     * @return the current state
     */
    public String getState() {
        return this.state;
    }

    public void clearFields() {
        guardIDField.setText("");
        guardNameField.setText("");
        guardAgeField.setText("");
        guardLastFour.setText("");
        guardDOE.setText("");
        guardDOB.setText("");
        guardBasicField.setSelected(false);
        guardTopSecretField.setSelected(false);
        guardNonScreenerField.setSelected(false);
        guardHandWanderField.setSelected(false);
        guardFullScreenerField.setSelected(false);
        guardAddress.setText("");
        guardCity.setText("");
        guardZip.setText("");
    }
}