package Controller;

import Model.Driver;
import Model.Travel;
import Model.Truck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * The Class Controller_Travel.
 */
public class Controller_Travel {
    
    /** The list travels. */

    public final ArrayList<Travel> list_travels = new ArrayList<>();
    private Travel current_travel;

    public Controller_Travel() {
        list_travels.add(new Travel(0,0, 1, 63, "19/03/2023"));
        list_travels.add(new Travel(1,1, 2, 25, "19/03/2023"));
        list_travels.add(new Travel(2,2, 3, 67, "19/03/2023"));
        list_travels.add(new Travel(3,3, 4, 91, "19/03/2023"));
        list_travels.add(new Travel(4,4, 0, 27, "20/03/2023"));
        list_travels.add(new Travel(5,0, 0, 68, "20/03/2023"));
        list_travels.add(new Travel(6,1, 1, 55, "20/03/2023"));
        list_travels.add(new Travel(7,2, 2, 82, "20/03/2023"));

        getLastTravel();
    }


//                        case 1 -> Travel_Create(c_driver,c_truck);
//                        case 2 -> Travel_Update(c_driver,c_truck);
//                        case 3 -> {
//                            list_travels[pos_current].setIs_deleted(true);
//                            pos_count--;
//                            Travel_Checklist();
//                            pos_current = pos_last;
//                        }
//                        case 4 -> Travel_Next();
//                        case 5 -> Travel_Previous();
//                        case 6 -> pos_current = pos_first;
//                        case 7 -> pos_current = pos_last;
//                        case 8 -> Travel_Select(c_driver,c_truck);


    public Travel getCurrentTravel() {
        return current_travel;
    }
    public void setCurrent_travel(Travel current_travel) {
        this.current_travel = current_travel;
    }
    public int getTravelCurrentIndex(){
        return list_travels.indexOf(current_travel);
    }
    public void goPreviousTravel(){
        int next_index = getTravelCurrentIndex()-1;
        System.out.println(next_index);
        if(next_index >= 0){
            current_travel = list_travels.get(next_index);
        }else{
            System.out.println(goPreviousTravelError());
        }
    }

    public String goPreviousTravelError(){
        return "You are on the first Travel.";
    }
    public void goNextTravel(){

        int next_index = getTravelCurrentIndex()+1;

        if(next_index < list_travels.size()){
            current_travel = list_travels.get(next_index);
        }else{
            System.out.println(goNextTravelError());
        }
    }
    public String goNextTravelError(){
        return "You are on the last Travel.";
    }
    public void getFirstTravel() {
        current_travel = list_travels.get(0);
    }
    public void getLastTravel() {
        current_travel = list_travels.get(list_travels.size()-1);
    }

    public void Travel_Delete(){
        list_travels.remove(current_travel);

        for (int i = 0; i < list_travels.size(); i++) {
            list_travels.get(i).setTravel_id(i);
        }

        //System.out.println(list_drivers.get(0).getTravel_id());
        getLastTravel();

    }

   public String List_truck_by_driver(Controller_Driver c_driver, Controller_Truck c_truck, int driver_selected){

       String drove[] = new String[c_truck.Truck_length()];
        int count = 0;


        String string = "You have selected Driver "+ c_driver.Driver_display_name(driver_selected) + " and he drove ";
        for (int i = 0; i < list_travels.size(); i++) {
            if(list_travels.get(i).getDriver_fk() == driver_selected){

                boolean exists = false;

                if(count > 0){
                    for (int j = 0; j < count; j++) {
                        if(Objects.equals(drove[j], c_truck.Truck_display_name(list_travels.get(i).getTruck_fk()))) {
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists) {
                    drove[count] = c_truck.Truck_display_name(list_travels.get(i).getTruck_fk());
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
        for (int i = 0; i < list_travels.size(); i++) {
            if(list_travels.get(i).getTruck_fk() == truck_selected) {

                boolean exists = false;

                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        if (Objects.equals(driven[j], c_driver.Driver_display_name(list_travels.get(i).getDriver_fk()))) {
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists) {
                    driven[count] = c_driver.Driver_display_name(list_travels.get(i).getDriver_fk());
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

    /**
     * Travels by driver.
     *
     * @param c_driver the c driver
     */
    public String Travels_byDriver(Controller_Driver c_driver){

        // nb drivers
        int drivers = c_driver.Driver_length();

        // nb trucks used by each driver
        int travels[] = new int[drivers];


        try {
            for (int i = 0; i < list_travels.size(); i++) {
                travels[list_travels.get(i).getDriver_fk()]++;
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

    /**
     * Travels by truck.
     *
     * @param c_truck the c truck
     */
    public String Travels_byTruck(Controller_Truck c_truck){

        // nb drivers
        int trucks = 0;
        for (int i = 0; i < list_travels.size(); i++) {
            if(list_travels.get(i).getTruck_fk() > trucks){
                trucks = list_travels.get(i).getTruck_fk();
            }
        }
        trucks = trucks+1;

        // nb trucks used by each driver
        int travels[] = new int[trucks];
        for (int i = 0; i < list_travels.size(); i++) {
            travels[list_travels.get(i).getTruck_fk()]++;
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

    /**
     * Top s driver.
     *
     * @param c_driver the c driver
     */
    public String Top_sDriver(Controller_Driver c_driver){
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < list_travels.size(); i++) {
            if (list_travels.get(i).getTravel_km() > highest_km){
                highest_km = list_travels.get(i).getTravel_km();
                top_driver = list_travels.get(i).getDriver_fk();
            }
        }

        return "Driver " + c_driver.Driver_display_name(top_driver) + " has the longest single Travel with " + highest_km + " km.";

    }

    /**
     * Top s truck.
     *
     * @param c_truck the c truck
     */
    public String Top_sTruck(Controller_Truck c_truck){
        int highest_km = 0;
        int top_truck = -1;

        try {
            for (int i = 0; i < list_travels.size(); i++) {
                if (list_travels.get(i).getTravel_km() > highest_km){
                    highest_km = list_travels.get(i).getTravel_km();
                    top_truck = list_travels.get(i).getDriver_fk();
                }
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }


        return "Truck " + c_truck.Truck_display_name(top_truck) + " has the longest single Travel with " + highest_km + " km.";

    }

    /**
     * Total driver.
     *
     * @param c_driver the c driver
     */
    public String Total_Driver(Controller_Driver c_driver){

        HashMap<Integer, Integer> highest_km = new HashMap<>();

        // Initialize the distance for each driver to 0
        for (int key : c_driver.map_drivers.keySet()) {
            highest_km.put(key, 0);
        }

        // Iterate over the travels and update the distance for each driver
        for (Travel travel : list_travels) {
            Driver driver = c_driver.map_drivers.get(travel.getDriver_fk());
            int distance = travel.getTravel_km();

            // Update the distance for the driver
            if (driver != null) {
                highest_km.put(driver.getDriver_id(), highest_km.get(driver.getDriver_id()) + distance);
            }
        }

        int totalDistance = 0;
        int best_Driver = -1;
        // Print the total distance traveled by each driver
        for (int key : c_driver.map_drivers.keySet()) {
            if (highest_km.get(key) > totalDistance) {
                totalDistance = highest_km.get(key);
                best_Driver = key;
            }
        }

        System.out.println(highest_km);

        return "Driver " + c_driver.Driver_display_name(best_Driver) + " drove the most with " + totalDistance + " km.";

    }

    /**
     * Total truck.
     *
     * @param c_truck the c truck
     */
    public String Total_Truck(Controller_Truck c_truck){

        HashMap<Integer, Integer> km_byTruck = new HashMap<>();

        // Initialize the distance for each driver to 0
        for (int key : c_truck.map_trucks.keySet()) {
            km_byTruck.put(key, 0);
        }

        // Iterate over the travels and update the distance for each driver
        for (Travel travel : list_travels) {
            Truck truck = c_truck.map_trucks.get(travel.getTruck_fk());
            int distance = travel.getTravel_km();

            // Update the distance for the driver
            if (truck != null) {
                km_byTruck.put(truck.getTruck_id(), km_byTruck.get(truck.getTruck_id()) + distance);
            }
        }

        int totalDistance = 0;
        int best_Truck = -1;
        // Print the total distance traveled by each driver
        for (int key : c_truck.map_trucks.keySet()) {
            if (km_byTruck.get(key) > totalDistance) {
                totalDistance = km_byTruck.get(key);
                best_Truck = key;
            }
        }

        System.out.println(km_byTruck);



        return "Truck " + c_truck.Truck_display_name(best_Truck) +
                " has been driven the most with " + totalDistance + " km.";

    }

    public int Travel_length(){
        return list_travels.size();
    }
}
