package Controller;

import Model.Driver;
import Model.Travel;
import Model.Truck;

import java.util.*;

/**
 * The Class Controller_Travel.
 */
public class Controller_Travel {
    public final LinkedHashMap<Integer, Travel> map_travels = new LinkedHashMap<>();
    private Travel current_travel;

    public Controller_Travel() {
        map_travels.put(0, new Travel(0,0, 1, 63, "19/03/2023"));
        map_travels.put(1, new Travel(1,1, 2, 25, "19/03/2023"));
        map_travels.put(2, new Travel(2,2, 3, 67, "19/03/2023"));
        map_travels.put(3, new Travel(3,3, 4, 91, "19/03/2023"));
        map_travels.put(4, new Travel(4,4, 0, 27, "20/03/2023"));
        map_travels.put(5, new Travel(5,0, 0, 68, "20/03/2023"));
        map_travels.put(6, new Travel(6,1, 1, 55, "20/03/2023"));
        map_travels.put(7, new Travel(7,2, 2, 82, "20/03/2023"));

        getLastTravel();
    }

    public int getTravelCurrentIndex(){
        return current_travel.getTravel_id();
    }
    public Travel getCurrentTravel() {
        return current_travel;
    }
    public void setCurrent_travel(Travel current_travel) {
        this.current_travel = current_travel;
    }
    public void goPreviousTravel(){
        int currentKey = current_travel.getTravel_id();
        int previousKey = -1;

        for (Integer key : map_travels.keySet()) {
            if (key == currentKey) {
                break;
            }
            previousKey = key;
        }

        if (previousKey != -1) {
            current_travel = map_travels.get(previousKey);
        }
    }
    public String goPreviousTravelError(){
        return "You are on the first Travel.";
    }
    public void goNextTravel(){
        int currentKey = current_travel.getTravel_id();
        boolean found = false;
        int nextKey = -1;

        for (Integer key : map_travels.keySet()) {
            if(found){
                nextKey = key;
                break;
            }

            if (key == currentKey) {
                found = true;
            }
        }

        if (found && nextKey != -1) {
            current_travel = map_travels.get(nextKey);
        }
    }
    public String goNextTravelError(){
        return "You are on the last Travel.";
    }

    public void getFirstTravel() {
        for (int key : map_travels.keySet()) {
            current_travel = map_travels.get(key);
            return;
        }
    }
    public int getFirstTravelIndex() {
        int firstKey = -1;

        for (int key : map_travels.keySet()) {
            firstKey = key;
            break;
        }
        return firstKey;
    }
    public void getLastTravel() {
        int lastKey = -1;

        for (int key : map_travels.keySet()) {
            lastKey = key;
        }
        current_travel = map_travels.get(lastKey);
    }
    public int getLastDriverIndex() {
        int lastKey = -1;

        for (int key : map_travels.keySet()) {
            lastKey = key;
        }
        return lastKey;
    }
    public void Travel_Delete(){
        map_travels.remove(current_travel.getTravel_id());
        getLastTravel();
    }
   public String List_truck_by_driver(Controller_Driver c_driver, Controller_Truck c_truck, int driver_selected){

       String drove[] = new String[c_truck.Truck_length()];
        int count = 0;

        String string = "You have selected Driver "+ c_driver.Driver_display_name(driver_selected) + " and he drove ";
        for (int i = 0; i < map_travels.size(); i++) {
            if(map_travels.get(i).getDriver_fk() == driver_selected){

                boolean exists = false;

                if(count > 0){
                    for (int j = 0; j < count; j++) {
                        if(Objects.equals(drove[j], c_truck.Truck_display_name(map_travels.get(i).getTruck_fk()))) {
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists) {
                    drove[count] = c_truck.Truck_display_name(map_travels.get(i).getTruck_fk());
                    count++;
                }

            }
        }

        if(count == 1){
            string += count + " Truck : ";
            string += drove[0] + ".";
        }else {
            string += count + " Trucks : ";
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    string += drove[i] + ".";
                }else if(i == count-2){
                    string += drove[i] + " and ";
                }else {
                    string += drove[i] + ", ";
                }
            }
        }
        return string;
    }
    public String List_driver_used_truck(Controller_Driver c_driver, Controller_Truck c_truck, int truck_selected){

        String driven[] = new String[c_driver.Driver_length()];
        int count = 0;


        String string = "You have selected Truck "+ c_truck.Truck_display_name(truck_selected) + " and it Had been driven by ";
        for (int i = 0; i < map_travels.size(); i++) {
            if(map_travels.get(i).getTruck_fk() == truck_selected) {

                boolean exists = false;

                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        if (Objects.equals(driven[j], c_driver.Driver_display_name(map_travels.get(i).getDriver_fk()))) {
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists) {
                    driven[count] = c_driver.Driver_display_name(map_travels.get(i).getDriver_fk());
                    count++;
                }
            }
        }

        if(count == 1){
            string += count + " Driver : ";
            string += driven[0] + ".";
        }else {
            string += count + " Drivers : ";
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    string += driven[i] + ".";
                }else if(i == count-2){
                    string += driven[i] + " and ";
                }else {
                    string += driven[i] + ", ";
                }
            }
        }
        return string;
    }
    public String Travels_byDriver(Controller_Driver c_driver){

        // nb drivers
        int drivers = c_driver.Driver_length();

        // nb trucks used by each driver
        int travels[] = new int[drivers];


        try {
            for (int i = 0; i < map_travels.size(); i++) {
                travels[map_travels.get(i).getDriver_fk()]++;
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }

        // find max
        int max = 0;
        for (int i = 0; i < drivers; i++) {
            if( travels[i] > max){
                max = travels[i];
            }
        }

        // find ex-aequo
        int count = 0;
        for (int i = 0; i < drivers; i++) {
            if( travels[i] == max){
                count++;
            }
        }


        if (count == 1){
            for (int i = 0; i < drivers; i++) {
                if( travels[i] == max){
                    return "Driver " + c_driver.Driver_display_name(travels[i]) + " drove " + max + " Trucks.";
                }
            }
        } else {
            String names[] = new String[count];

            for (int i = 0, num = 0; i < drivers; i++) {
                if( travels[i] == max){
                    names[num] = c_driver.Driver_display_name(i);
                    num++;
                }
            }

            String string = "Drivers ";
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    string += names[i] + " ";
                }else if(i == count-2){
                    string += names[i] + " and ";
                }else {
                    string += names[i] + ", ";
                }
            }
            string += "drove " + max + " Trucks.";
            return string;
        }
        return "error";
    }
    public String Travels_byTruck(Controller_Truck c_truck){
        // nb drivers
        int trucks = 0;
        for (int i = 0; i < map_travels.size(); i++) {
            if(map_travels.get(i).getTruck_fk() > trucks){
                trucks = map_travels.get(i).getTruck_fk();
            }
        }
        trucks = trucks+1;

        // nb trucks used by each driver
        int travels[] = new int[trucks];
        for (int i = 0; i < map_travels.size(); i++) {
            travels[map_travels.get(i).getTruck_fk()]++;
        }

        // find max
        int max = 0;
        for (int i = 0; i < trucks; i++) {
            if( travels[i] > max){
                max = travels[i];
            }
        }

        // find ex-aequo
        int count = 0;
        for (int i = 0; i < trucks; i++) {
            if( travels[i] == max){
                count++;
            }
        }

        if (count == 1){
            for (int i = 0; i < trucks; i++) {
                if( travels[i] == max){
                    return "Truck " + c_truck.Truck_display_name(travels[i]) + " has been driven by " + max + " Drivers.";
                }
            }
        } else {
            String names[] = new String[count];

            for (int i = 0, num = 0; i < trucks; i++) {
                if( travels[i] == max){
                    names[num] = c_truck.Truck_display_name(i);
                    num++;
                }
            }

            String string = "Truck ";
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    string += names[i] + " ";
                }else if(i == count-2){
                    string += names[i] + " and ";
                }else {
                    string += names[i] + ", ";
                }
            }
            string += "have been driven by " + max + " Drivers.";
            return string;
        }
    return "error";
    }
    public String Top_sDriver(Controller_Driver c_driver){
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < map_travels.size(); i++) {
            if (map_travels.get(i).getTravel_km() > highest_km){
                highest_km = map_travels.get(i).getTravel_km();
                top_driver = map_travels.get(i).getDriver_fk();
            }
        }
        return "Driver " + c_driver.Driver_display_name(top_driver) + " has the longest single Travel with " + highest_km + " km.";
    }
    public String Top_sTruck(Controller_Truck c_truck){
        int highest_km = 0;
        int top_truck = -1;

        try {
            for (int i = 0; i < map_travels.size(); i++) {
                if (map_travels.get(i).getTravel_km() > highest_km){
                    highest_km = map_travels.get(i).getTravel_km();
                    top_truck = map_travels.get(i).getDriver_fk();
                }
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
        return "Truck " + c_truck.Truck_display_name(top_truck) + " has the longest single Travel with " + highest_km + " km.";
    }
    public String Total_Driver(Controller_Driver c_driver){

        HashMap<Integer, Integer> highest_km = new HashMap<>();

        for (int key : c_driver.map_drivers.keySet()) {
            highest_km.put(key, 0);
        }

        for (int key : map_travels.keySet()) {
            Driver driver = c_driver.map_drivers.get(map_travels.get(key).getDriver_fk());
            int distance = map_travels.get(key).getTravel_km();

            if (driver != null) {
                highest_km.put(driver.getDriver_id(), highest_km.get(driver.getDriver_id()) + distance);
            }
        }

        int totalDistance = 0;
        int best_Driver = -1;

        for (int key : c_driver.map_drivers.keySet()) {
            if (highest_km.get(key) > totalDistance) {
                totalDistance = highest_km.get(key);
                best_Driver = key;
            }
        }
        return "Driver " + c_driver.Driver_display_name(best_Driver) + " drove the most with " + totalDistance + " km.";
    }

    /**
     * Total truck.
     *
     * @param c_truck the c truck
     */
    public String Total_Truck(Controller_Truck c_truck){

        HashMap<Integer, Integer> km_byTruck = new HashMap<>();


        for (int key : c_truck.map_trucks.keySet()) {
            km_byTruck.put(key, 0);
        }

        for (int key : map_travels.keySet()) {
            Truck truck = c_truck.map_trucks.get(map_travels.get(key).getTruck_fk());
            int distance = map_travels.get(key).getTravel_km();

            if (truck != null) {
                km_byTruck.put(truck.getTruck_id(), km_byTruck.get(truck.getTruck_id()) + distance);
            }
        }

        int totalDistance = 0;
        int best_Truck = -1;

        for (int key : c_truck.map_trucks.keySet()) {
            if (km_byTruck.get(key) > totalDistance) {
                totalDistance = km_byTruck.get(key);
                best_Truck = key;
            }
        }
        return "Truck " + c_truck.Truck_display_name(best_Truck) +
                " has been driven the most with " + totalDistance + " km.";
    }

    public int Travel_length(){
        return map_travels.size();
    }
}
