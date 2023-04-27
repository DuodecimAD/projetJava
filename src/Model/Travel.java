/*
 * 
 */
package Model;

/**
 * The Class Travel.
 */
public class Travel {
    
    /** The travel key. */
    private static int travel_key = 0;
    
    /** The travel id. */
    private int travel_id;
    
    /** The truck fk. */
    private int truck_fk;
    
    /** The driver fk. */
    private int driver_fk;
    
    /** The travel km. */
    private int travel_km;
    
    /** The travel day. */
    private String travel_day;
    
    /** The is deleted. */
    private boolean is_deleted;


    /**
     * Instantiates a new travel.
     *
     * @param truck_fk the truck fk
     * @param driver_fk the driver fk
     * @param travel_km the travel km
     * @param travel_day the travel day
     */
    public Travel(int truck_fk, int driver_fk, int travel_km, String travel_day) {
        this.travel_id = travel_key;
        this.truck_fk = truck_fk;
        this.driver_fk = driver_fk;
        this.travel_km = travel_km;
        this.travel_day = travel_day;
        this.is_deleted = false;

        travel_key++;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "****************************************"+
                "\nCurrent Travel {" +
                "\n    Travel number = " + travel_id +
                ",\n    fk_truck = " + truck_fk +
                ",\n    fk_driver = " + driver_fk +
                ",\n    km_travel = " + travel_km +
                ",\n    day_travel = " + travel_day +
                "\n}"+
                "\n****************************************";
    }

    /**
     * Gets the travel key.
     *
     * @return the travel key
     */
    public static int getTravel_key() {
        return travel_key;
    }

    /**
     * Gets the travel id.
     *
     * @return the travel id
     */
    public int getTravel_id() {
        return travel_id;
    }

    /**
     * Gets the truck fk.
     *
     * @return the truck fk
     */
    public int getTruck_fk() {
        return truck_fk;
    }

    /**
     * Gets the driver fk.
     *
     * @return the driver fk
     */
    public int getDriver_fk() {
        return driver_fk;
    }

    /**
     * Gets the travel km.
     *
     * @return the travel km
     */
    public int getTravel_km() {
        return travel_km;
    }

    /**
     * Gets the travel day.
     *
     * @return the travel day
     */
    public String getTravel_day() {
        return travel_day;
    }

    /**
     * Sets the truck fk.
     *
     * @param truck_fk the new truck fk
     */
    public void setTruck_fk(int truck_fk) {
        this.truck_fk = truck_fk;
    }

    /**
     * Sets the driver fk.
     *
     * @param driver_fk the new driver fk
     */
    public void setDriver_fk(int driver_fk) {
        this.driver_fk = driver_fk;
    }

    /**
     * Sets the travel km.
     *
     * @param travel_km the new travel km
     */
    public void setTravel_km(int travel_km) {
        this.travel_km = travel_km;
    }

    /**
     * Sets the travel day.
     *
     * @param travel_day the new travel day
     */
    public void setTravel_day(String travel_day) {
        this.travel_day = travel_day;
    }

    /**
     * Checks if is checks if is deleted.
     *
     * @return true, if is checks if is deleted
     */
    public boolean isIs_deleted() {
        return is_deleted;
    }

    /**
     * Sets the checks if is deleted.
     *
     * @param is_deleted the new checks if is deleted
     */
    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
