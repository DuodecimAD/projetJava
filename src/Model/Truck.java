/*
 * 
 */
package Model;

/**
 * The Class Truck.
 */
public class Truck {
    
    /** The truck key. */
    private static int truck_key = 0;
    
    /** The truck id. */
    private final int truck_id;
    
    /** The truck name. */
    private String truck_name;
    
    /** The truck km total. */
    private int truck_km_total;
    
    /** The truck current fuel. */
    private int truck_current_fuel;
    
    /** The truck brand. */
    private String truck_brand;
    
    /** The is deleted. */
    private boolean is_deleted;


    /**
     * Instantiates a new truck.
     *
     * @param truck_name the truck name
     * @param truck_km_total the truck km total
     * @param truck_current_fuel the truck current fuel
     * @param truck_brand the truck brand
     */
    public Truck(String truck_name, int truck_km_total, int truck_current_fuel, String truck_brand) {
        this.truck_id = truck_key;
        this.truck_name = truck_name;
        this.truck_km_total = truck_km_total;
        this.truck_current_fuel = truck_current_fuel;
        this.truck_brand = truck_brand;
        this.is_deleted = false;

        truck_key++;
    }

    /**
     * Gets the truck key.
     *
     * @return the truck key
     */
    public static int getTruck_key() {
        return truck_key;
    }
    
    /**
     * Gets the truck id.
     *
     * @return the truck id
     */
    public int getTruck_id() {
        return truck_id;
    }

    /**
     * Gets the truck name.
     *
     * @return the truck name
     */
    public String getTruck_name() {
        return truck_name;
    }

    /**
     * Sets the truck name.
     *
     * @param truck_name the new truck name
     */
    public void setTruck_name(String truck_name) {
        this.truck_name = truck_name;
    }

    /**
     * Gets the truck km total.
     *
     * @return the truck km total
     */
    public int getTruck_km_total() {
        return truck_km_total;
    }

    /**
     * Sets the truck km total.
     *
     * @param truck_km_total the new truck km total
     */
    public void setTruck_km_total(int truck_km_total) {
        this.truck_km_total = truck_km_total;
    }

    /**
     * Gets the truck current fuel.
     *
     * @return the truck current fuel
     */
    public int getTruck_current_fuel() {
        return truck_current_fuel;
    }

    /**
     * Sets the truck current fuel.
     *
     * @param truck_current_fuel the new truck current fuel
     */
    public void setTruck_current_fuel(int truck_current_fuel) {
        this.truck_current_fuel = truck_current_fuel;
    }

    /**
     * Gets the truck brand.
     *
     * @return the truck brand
     */
    public String getTruck_brand() {
        return truck_brand;
    }

    /**
     * Sets the truck brand.
     *
     * @param truck_brand the new truck brand
     */
    public void setTruck_brand(String truck_brand) {
        this.truck_brand = truck_brand;
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

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "****************************************"+
                "\nCurrent Truck {" +
                "\n    id_truck = " + truck_id +
                ",\n    name_truck = " + truck_name +
                ",\n    km_total = " + truck_km_total +
                ",\n    current_fuel = " + truck_current_fuel +
                ",\n    brand = " + truck_brand +
                "\n}"+
                "\n****************************************";
    }
}
