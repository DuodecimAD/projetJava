package Controller;

import Model.Truck;
import java.util.LinkedHashMap;


public class Controller_Truck {
    public final LinkedHashMap<Integer, Truck> map_trucks = new LinkedHashMap<>();
    private Truck current_truck;

    public Controller_Truck() {
        map_trucks.put(0, new Truck(0,"Volvo", "FHL16", 2007, "Volvo"));
        map_trucks.put(1, new Truck(1,"Scanio", "RY730", 2015, "Scania"));
        map_trucks.put(2, new Truck(2,"Actro", "HQS89", 2019, "Mercedes-Benz"));
        map_trucks.put(3, new Truck(3,"Mano", "TGX25", 2020, "MAN"));
        map_trucks.put(4, new Truck(4,"Reno", "POI23", 2021, "Renault"));

        getLastTruck();
    }

    public int getTruckCurrentIndex(){
        return current_truck.getTruck_id();
    }
    public void Truck_Delete(){
        map_trucks.remove(current_truck.getTruck_id());
        getLastTruck();
    }
    public void goPreviousTruck(){
        int currentKey = current_truck.getTruck_id();
        int previousKey = -1;

        for (Integer key : map_trucks.keySet()) {
            if (key == currentKey) {
                break;
            }
            previousKey = key;
        }

        if (previousKey != -1) {
           current_truck = map_trucks.get(previousKey);
        } else {
            goPreviousTruckError();
        }
    }
    public String goPreviousTruckError(){
        return "You are on the first Truck.";
    }
    public void goNextTruck(){
        int currentKey = current_truck.getTruck_id();
        boolean found = false;
        int nextKey = -1;

        for (Integer key : map_trucks.keySet()) {
            if (found) {
                nextKey = key;
                break;
            }

            if (key == currentKey) {
                found = true;
            }
        }

        if (found && nextKey != -1) {
            current_truck = map_trucks.get(nextKey);
        } else {
            goPreviousTruckError();
        }
    }
    public String goNextTruckError(){
        return "You are on the last Truck.";
    }
    public void getFirstTruck() {
        for (int key : map_trucks.keySet()) {
            current_truck = map_trucks.get(key);
            return;
        }
    }
    public int getFirstTruckIndex() {
        int firstKey = -1;
        for (int key : map_trucks.keySet()) {
            firstKey = key;
            break;
        }
        return firstKey;
    }
    public void getLastTruck() {
        int lastKey = -1;

        for (int key : map_trucks.keySet()) {
            lastKey = key;

        }
        current_truck = map_trucks.get(lastKey);
    }
    public int getLastTruckIndex() {
        int lastKey = -1;

        for (int key : map_trucks.keySet()) {
            lastKey = key;
        }
        return lastKey;
    }
    public Truck getCurrentTruck() {
        return current_truck;
    }
    public void setCurrent_truck(Truck current_truck) {
        this.current_truck = current_truck;
    }
    public String Truck_display_name(int i){
        try {
            return map_trucks.get(i).getTruck_name();
        }catch (Exception e){
            System.out.println("error controllerTruck118 : "+e);
            return "Deleted";
        }
    }
    public int Truck_length(){
        return map_trucks.size();
    }
}