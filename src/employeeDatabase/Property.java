/*
 * Name: Patrick Saxton
 * Created: 05/02/2023
 * Modified: 05/02/2023
 */
package employeeDatabase;

/**
 * This class is meant to hold a particular data type, modify a particular data within the
 * property, and be able to know the type of data being held.
 */
public class Property {
    private Object data; // The data of the property
    private final String type; // The type of the property

    /**
     * The constructor that allows you to create a property when passing in a type parameter and
     * a data value.
     * @param type  - The type of property being created
     * @param data  - The starting value of the data
     */
    public Property(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    /**
     * The constructor that allows you to create a property when passing in just a type parameter
     * and no data value is given yet.
     * @param type  - The type of property being created
     */
    public Property(String type) {
        this(null, type);
    }

    /**
     * Retrieves the type of property that is given in the object
     * @return  - The string of the name of the property
     */
    public String getType() {
        return this.type;
    }

    /**
     * Retrieves the data stored within the property
     * @return  - The data being stored
     */
    public Object getData() {
        return data;
    }

    /**
     * Changes the data within the property
     * @param data  - The data passed in
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * This method will clear the data stored within the property
     */
    public void clearData() {
        this.data = null;
    }

    /**
     * This method returns the type of the property and the data stored within the property
     * @return - The type of data and data stored.
     */
    @Override
    public String toString() {
        return getType() + ": " + getData().toString();
    }
}
