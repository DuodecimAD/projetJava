/*
 * 
 */
package Model;

/**
 * The Class Truck.
 */
public class Truck {

    /** The truck id. */
    private int truck_id;
    
    /** The truck name. */
    private String truck_name;
    
    /** The truck km total. */
    private String truck_matricule;
    
    /** The truck current fuel. */
    private int truck_year;
    
    /** The truck brand. */
    private String truck_brand;

    /**
     * Instantiates a new truck.
     *
     * @param truck_name the truck name
     * @param truck_matricule the truck km total
     * @param truck_year the truck current fuel
     * @param truck_brand the truck brand
     */
    public Truck(int truck_id, String truck_name, String truck_matricule, int truck_year, String truck_brand) {
        this.truck_id = truck_id;
        this.truck_name = truck_name;
        this.truck_matricule = truck_matricule;
        this.truck_year = truck_year;
        this.truck_brand = truck_brand;

    }


    /**
     * Gets the truck id.
     *
     * @return the truck id
     */
    public int getTruck_id() {
        return truck_id;
    }

    public void setTruck_id(int truck_id) {
        this.truck_id = truck_id;
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
    public String getTruck_matricule() {
        return truck_matricule;
    }

    /**
     * Sets the truck km total.
     *
     * @param truck_matricule the new truck km total
     */
    public void setTruck_matricule(String truck_matricule) {
        this.truck_matricule = truck_matricule;
    }

    /**
     * Gets the truck current fuel.
     *
     * @return the truck current fuel
     */
    public int getTruck_year() {
        return truck_year;
    }

    /**
     * Sets the truck current fuel.
     *
     * @param truck_year the new truck current fuel
     */
    public void setTruck_year(int truck_year) {
        this.truck_year = truck_year;
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
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return  "\n    id_truck = " + truck_id +
                ",\n    name_truck = " + truck_name +
                ",\n    km_total = " + truck_matricule +
                ",\n    current_fuel = " + truck_year +
                ",\n    brand = " + truck_brand +
                "\n";
    }
}
