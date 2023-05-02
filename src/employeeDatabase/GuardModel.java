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

    /**
     * The constructor for the guard model.
     * @param idNumber            - The guards ID number
     * @param name                - The guards name
     * @param age                 - The guards age
     * @param lastFour            - The guards last four of their Social Security Number
     * @param dateOfBirth         - The guards Date of Birth
     * @param dateEmployed        - The guards date of employment
     * @param basicClearance      - Whether or not the guard has basic clearance
     * @param topSecretClearance  - Whether or not the guard has Top Secret clearance
     * @param nonScreener         - Whether or not the guard has screening certification
     * @param handWander          - Whether or not the guard has hand wanding certification
     * @param fullScreener        - Whether or not the guard has full screening certification
     * @param address             - The guards address
     * @param city                - The guards City
     * @param zip                 - The guards zip code
     */
    public GuardModel(Integer idNumber, String name, Integer age,
                      Integer lastFour, String dateOfBirth, String dateOfEmployment,
                      Boolean basicClearance, Boolean topSecretClearance,
                      Boolean nonScreener, Boolean handWander, Boolean fullScreener,
                      String address, String city, Integer zip) {
        this.idNumber = new SimpleIntegerProperty(idNumber);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.lastFour = new SimpleIntegerProperty(lastFour);
        this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
        this.dateOfEmployment = new SimpleStringProperty(dateOfEmployment);
        this.basicClearance = new SimpleBooleanProperty(basicClearance);
        this.topSecretClearance = new SimpleBooleanProperty(topSecretClearance);
        this.nonScreener = new SimpleBooleanProperty(nonScreener);
        this.handWander = new SimpleBooleanProperty(handWander);
        this.fullScreener = new SimpleBooleanProperty(fullScreener);
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.zip = new SimpleIntegerProperty(zip);
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
     * Getter for the guards last four of their social security number
     * @return the guards last four of their social security number
     */
    public int getLastFour() {
        return lastFour.get();
    }

    /**
     * Setter for the guards last four
     * @param lastFour the last four
     */
    public void setLastFour(int lastFour) {
        this.lastFour.set(lastFour);
    }

    /**
     * Getter for the guards date of birth
     * @return the guards date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth.get();
    }

    /**
     * Setter for the guards date of birth
     * @param dateOfBirth the guards date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    /**
     * Getter for the guards date of employment
     * @return the guards date of employment
     */
    public String getDateOfEmployment() {
        return dateOfEmployment.get();
    }

    /**
     * Setter for the guards date of employment
     * @param dateOfEmployment the guards date of employment
     */
    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment.set(dateOfEmployment);
    }

    /**
     * Getter for the guards address
     * @return the guards address
     */
    public String getAddress() {
        return address.get();
    }

    /**
     * Setter for the guards address
     * @param address the guards address
     */
    public void setAddress(String address) {
        this.address.set(address);
    }

    /**
     * Getter for the guards city
     * @return the guards city
     */
    public String getCity() {
        return city.get();
    }

    /**
     * Setter for the guards city
     * @param city the guards city
     */
    public void setCity(String city) {
        this.city.set(city);
    }

    /**
     * Getter for the guards zip code
     * @return the guards zip code
     */
    public int getZip() {
        return zip.get();
    }

    /**
     * Setter for the guards zip code
     * @param zip the guards zip code
     */
    public void setZip(int zip) {
        this.zip.set(zip);
    }
}