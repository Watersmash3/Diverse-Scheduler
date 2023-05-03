package employeeDatabase;

import java.time.LocalDate;

public class Guard {
    public int idNumber; // - The id Number of the guard
    public String name; // - The guard's name
    public int age; // - The age of the guard
    public int lastFour; // - The last four of the guard's social security number
    public LocalDate dateOfBirth; // - The date of birth of the guard
    public LocalDate dateOfEmployment; // - The first day of employment of the guard
    public boolean fullTime; // - Whether the guard is a full time worker
    public boolean basicClearance; // - Whether the guard has basic clearance
    public boolean topSecretClearance; // - Whether the guard has a top secret clearance
    public boolean screener; // - Whether the guard is a screener
    public boolean handWander; // - Whether the guard can do hand wanding
    public boolean fullScreener; // - Whether the guard is a full screener
    public String street; // - The guard's street
    public String city; // - The guard's city
    public String zipCode; // - The guard's zipcode

    private Guard() {

    }

    public static class GuardBuilder {
        private Guard guard = new Guard();

        public GuardBuilder setIdNumber(int idNumber) {
            guard.idNumber = idNumber;
            return this;
        }

        public GuardBuilder setName(String name) {
            guard.name = name;
            return this;
        }

        public GuardBuilder setAge(int age) {
            guard.age = age;
            return this;
        }

        public GuardBuilder setlastFour(int lastFour) {
            guard.lastFour = lastFour;
            return this;
        }

        public GuardBuilder setdateOfBirth(LocalDate dateOfBirth) {
            guard.dateOfBirth = dateOfBirth;
            return this;
        }

        public GuardBuilder setdateOfEmployment(LocalDate dateOfEmployment) {
            guard.dateOfEmployment = dateOfEmployment;
            return this;
        }

        public GuardBuilder setFullTime(boolean fullTime) {
            guard.fullTime = fullTime;
            return this;
        }

        public GuardBuilder setBasicClearance(boolean basicClearance) {
            guard.basicClearance = basicClearance;
            return this;
        }

        public GuardBuilder setTopSecretClearance(boolean topSecretClearance) {
            guard.topSecretClearance = topSecretClearance;
            return this;
        }

        public GuardBuilder setScreener(boolean screener) {
            guard.screener = screener;
            return this;
        }

        public GuardBuilder setHandWander(boolean handWander) {
            guard.handWander = handWander;
            return this;
        }

        public GuardBuilder setFullScreener(boolean fullScreener) {
            guard.fullScreener = fullScreener;
            return this;
        }

        public GuardBuilder setStreet(String street) {
            guard.street = street;
            return this;
        }

        public GuardBuilder setCity(String city) {
            guard.city = city;
            return this;
        }

        public GuardBuilder setZipCode(String zipCode) {
            guard.zipCode = zipCode;
            return this;
        }

        public Guard build() {
            return guard;
        }
    }
}