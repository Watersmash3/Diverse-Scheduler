package employeeDatabase;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This model defines the data that each Guard will have.
 */
public class GuardModel {

    private SimpleIntegerProperty idNumber;
    private SimpleStringProperty name;
    private SimpleIntegerProperty age;
    private SimpleStringProperty dateEmployed;
    private SimpleBooleanProperty basicClearance;
    private SimpleBooleanProperty topSecretClearance;
    private SimpleBooleanProperty nonScreener;
    private SimpleBooleanProperty handWander;
    private SimpleBooleanProperty fullScreener;
    private SimpleStringProperty location;

    /**
     * The constructor for the guard model.
     * @param idNumber            - The guards ID number
     * @param name                - The guards name
     * @param age                 - The guards age
     * @param dateEmployed        - The guards date of employment
     * @param basicClearance      - Whether or not the guard has basic clearance
     * @param topSecretClearance  - Whether or not the guard has Top Secret clearance
     * @param nonScreener         - Whether or not the guard has screening certification
     * @param handWander          - Whether or not the guard has hand wanding certification
     * @param fullScreener        - Whether or not the guard has full screening certification
     * @param location            - The guards location
     */
    public GuardModel(Integer idNumber, String name,
                      Integer age, String dateEmployed,
                      Boolean basicClearance, Boolean
                              topSecretClearance, Boolean nonScreener,
                      Boolean handWander, Boolean fullScreener,
                      String location) {
        this.idNumber = new SimpleIntegerProperty(idNumber);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.dateEmployed = new SimpleStringProperty(dateEmployed);
        this.basicClearance = new SimpleBooleanProperty(basicClearance);
        this.topSecretClearance = new SimpleBooleanProperty(topSecretClearance);
        this.nonScreener = new SimpleBooleanProperty(nonScreener);
        this.handWander = new SimpleBooleanProperty(handWander);
        this.fullScreener = new SimpleBooleanProperty(fullScreener);
        this.location = new SimpleStringProperty(location);
    }

    /**
     * Getter for the guards ID Number
     * @return the guards ID Number
     */
    public int getIdNumber() {
        return idNumber.get();
    }

    /**
     * Setter for the guards ID Number
     * @param idNumber the guards ID Number
     */
    public void setIdNumber(int idNumber) {
        this.idNumber.set(idNumber);
    }

    /**
     * Getter for the guards Nmae
     * @return the guards name
     */
    public String getName() {
        return name.get();
    }

    /**
     * Setter for the guards name
     * @param name the guards name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Getter for the guards age
     * @return the guards age
     */
    public int getAge() {
        return age.get();
    }

    /**
     * Setter for the guards age
     * @param age the guards age
     */
    public void setAge(int age) {
        this.age.set(age);
    }

    /**
     * Getter for the guards employment date
     * @return the guards employment date
     */
    public String getDateEmployed() {
        return dateEmployed.get();
    }

    /**
     * Setter for the guards date of employment
     * @param dateEmployed the guards date of employment
     */
    public void setDateEmployed(String dateEmployed) {
        this.dateEmployed.set(dateEmployed);
    }

    /**
     * Getter for the guards basic clearance
     * @return the guards basic clearance
     */
    public boolean isBasicClearance() {
        return basicClearance.get();
    }

    /**
     * Setter for the guards basic clearance
     * @param basicClearance the guards basic clearance
     */
    public void setBasicClearance(boolean basicClearance) {
        this.basicClearance.set(basicClearance);
    }

    /**
     * Getter for the guards top secret clearance
     * @return the guards top secret clearance
     */
    public boolean isTopSecretClearance() {
        return topSecretClearance.get();
    }

    /**
     * Setter for the guards top secret clearance
     * @param topSecretClearance the clearance level
     */
    public void setTopSecretClearance(boolean topSecretClearance) {
        this.topSecretClearance.set(topSecretClearance);
    }

    /**
     * Getter for the guards non screening privileges
     * @return non screening privileges
     */
    public boolean isNonScreener() {
        return nonScreener.get();
    }

    /**
     * Setter for the guards non screening privileges
     * @param nonScreener non screening privileges
     */
    public void setNonScreener(boolean nonScreener) {
        this.nonScreener.set(nonScreener);
    }

    /**
     * Getter for the guards
     * @return
     */
    public boolean isHandWander() {
        return handWander.get();
    }

    /**
     * Setter for the guards hand wanding privileges
     * @param handWander the guards hand wanding privileges
     */
    public void setHandWander(boolean handWander) {
        this.handWander.set(handWander);
    }

    /**
     * Getter for the guards full screening privileges
     * @return the guards screening privileges
     */
    public boolean isFullScreener() {
        return fullScreener.get();
    }

    /**
     * Setter for the guards full screener certification
     * @param fullScreener the guards full screener certification level
     */
    public void setFullScreener(boolean fullScreener) {
        this.fullScreener.set(fullScreener);
    }

    /**
     * Getter for the guards location
     * @return the guards location
     */
    public String getLocation() {
        return location.get();
    }

    /**
     * Setter for the guards location
     * @param location the guards location
     */
    public void setLocation(String location) {
        this.location.set(location);
    }
}