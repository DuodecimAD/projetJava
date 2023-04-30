/*
 * 
 */
package Model;

/**
 * The Class Driver.
 */
public class Driver {
    

    /** The driver id. */
    private int driver_id;

    /** The driver first name. */
    private String driver_first_name;
    
    /** The driver last name. */
    private String driver_last_name;
    
    /** The driver age. */
    private int driver_age;
    
    /** The driver address. */
    private String driver_address;


    /**
     * Instantiates a new driver.
     *
     * @param driver_first_name the driver first name
     * @param driver_last_name the driver last name
     * @param driver_age the driver age
     * @param driver_address the driver address
     */
    public Driver(int driver_id,String driver_first_name, String driver_last_name, int driver_age, String driver_address) {
        this.driver_id = driver_id;
        this.driver_first_name = driver_first_name;
        this.driver_last_name = driver_last_name;
        this.driver_age = driver_age;
        this.driver_address = driver_address;
    }


    /**
     * Gets the driver id.
     *
     * @return the driver id
     */
    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    /**
     * Gets the driver first name.
     *
     * @return the driver first name
     */
    public String getDriver_first_name() {
        return driver_first_name;
    }

    /**
     * Sets the driver first name.
     *
     * @param driver_first_name the new driver first name
     */
    public void setDriver_first_name(String driver_first_name) {
        this.driver_first_name = driver_first_name;
    }

    /**
     * Gets the driver last name.
     *
     * @return the driver last name
     */
    public String getDriver_last_name() {
        return driver_last_name;
    }

    /**
     * Sets the driver last name.
     *
     * @param driver_last_name the new driver last name
     */
    public void setDriver_last_name(String driver_last_name) {
        this.driver_last_name = driver_last_name;
    }

    /**
     * Gets the driver age.
     *
     * @return the driver age
     */
    public int getDriver_age() {
        return driver_age;
    }

    /**
     * Sets the driver age.
     *
     * @param driver_age the new driver age
     */
    public void setDriver_age(int driver_age) {
        this.driver_age = driver_age;
    }

    /**
     * Gets the driver address.
     *
     * @return the driver address
     */
    public String getDriver_address() {
        return driver_address;
    }

    /**
     * Sets the driver address.
     *
     * @param driver_address the new driver address
     */
    public void setDriver_address(String driver_address) {
        this.driver_address = driver_address;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return
                "\nCurrent Driver :" +
                "\n\n    id_driver = " + driver_id +
                ",\n    first_name_driver = " + driver_first_name +
                ",\n    last_name_driver = " + driver_last_name +
                ",\n    age_driver = " + driver_age +
                ",\n    address_driver = " + driver_address +
                "\n";
    }
}
