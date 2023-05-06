package Controller;

import Model.Travel;
import Model.Truck;
import java.util.ArrayList;
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
        list_travels.add(new Travel(0,0, 1, 59, "19/03/2023"));
        list_travels.add(new Travel(1,1, 2, 25, "19/03/2023"));
        list_travels.add(new Travel(2,2, 3, 67, "19/03/2023"));
        list_travels.add(new Travel(3,3, 4, 91, "19/03/2023"));
        list_travels.add(new Travel(4,4, 0, 27, "20/03/2023"));
        list_travels.add(new Travel(5,0, 0, 68, "20/03/2023"));
        list_travels.add(new Travel(6,1, 1, 55, "20/03/2023"));
        list_travels.add(new Travel(7,2, 2, 82, "20/03/2023"));

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



    public int getTravelCurrentIndex(){ return list_travels.indexOf(current_travel); }
    public void goPreviousTravel(){
        int next_index = getTravelCurrentIndex()-1;
        System.out.println(next_index);
        if(next_index >= 0){
            current_travel = list_travels.get(next_index);
        }else{
            System.out.println(goPreviousDriverError());
        }
    }
    public String goPreviousDriverError(){
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
        for (int i = 0; i < list_travels.size(); i++) {
                travels[list_travels.get(i).getDriver_fk()]++;
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

        for (int i = 0; i < list_travels.size(); i++) {
            if (list_travels.get(i).getTravel_km() > highest_km){
                highest_km = list_travels.get(i).getTravel_km();
                top_truck = list_travels.get(i).getDriver_fk();
            }
        }

        return "Truck " + c_truck.Truck_display_name(top_truck) + " has the longest single Travel with " + highest_km + " km.";

    }

    /**
     * Total driver.
     *
     * @param c_driver the c driver
     */
    public String Total_Driver(Controller_Driver c_driver){

        int nbDrivers = c_driver.Driver_length();
        int nbTravels = list_travels.size();
        int km_byDriver[] = new int[nbDrivers];
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < nbTravels; i++) {
            km_byDriver[list_travels.get(i).getDriver_fk()] += list_travels.get(i).getTravel_km();
        }

        int max = 0;
        for (int i = 0; i < nbDrivers; i++) {
            if (km_byDriver[i] > max){
                max = km_byDriver[i];
            }
        }

        int index = -1;
        for (int i = 0; i < nbDrivers; i++) {
            if (km_byDriver[i] == max){
                index = i;
            }
        }


        return "Driver " + c_driver.Driver_display_name(index) + " drove the most with " + km_byDriver[index] + " km.";

    }

    /**
     * Total truck.
     *
     * @param c_truck the c truck
     */
    public String Total_Truck(Controller_Truck c_truck){
    	
        int nbTrucks = c_truck.Truck_length();
        int nbTravels = list_travels.size();
        int km_byTruck[] = new int[nbTrucks];
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < nbTravels; i++) {
            km_byTruck[list_travels.get(i).getDriver_fk()] += list_travels.get(i).getTravel_km();
        }

        int max = 0;
        for (int i = 0; i < nbTrucks; i++) {
            if (km_byTruck[i] > max){
                max = km_byTruck[i];
            }
        }

        int index = -1;
        for (int i = 0; i < nbTrucks; i++) {
            if (km_byTruck[i] == max){
                index = i;
            }
        }


        return "Truck " + c_truck.Truck_display_name(index) + " has been driven the most with " + km_byTruck[index] + " km.";

    }

    public int Travel_length(){
        return list_travels.size();
    }
}
