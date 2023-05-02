package employeeDatabase;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuardModelNew {
    private SimpleIntegerProperty idNumber;
    private SimpleStringProperty name;
    private SimpleIntegerProperty age;
    private SimpleIntegerProperty lastFour;
    private SimpleStringProperty dateOfBirth;
    private SimpleStringProperty dateOfEmployment;
    private SimpleBooleanProperty basicClearance;
    private SimpleBooleanProperty topSecretClearance;
    private SimpleBooleanProperty nonScreener;
    private SimpleBooleanProperty handWander;
    private SimpleBooleanProperty fullScreener;
    private SimpleStringProperty address;
    private SimpleStringProperty city;
    private SimpleIntegerProperty zip;
    ArrayList<Object> properties = new ArrayList<>();



    public void addPropertiesToList() {
        properties.add(idNumber);
        properties.add(name);
        properties.add(lastFour);
    }

//    public List<Object> getPropertiesList() {
//
//    }
}
