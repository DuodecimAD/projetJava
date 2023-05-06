package Controller;

import Model.Truck;
import java.util.ArrayList;

public class Controller_Truck {
    public final ArrayList<Truck> list_trucks = new ArrayList<>();
    private Truck current_truck;

    public Controller_Truck() {

        list_trucks.add(new Truck(0,"Volvo", "FHL16", 2007, "Volvo"));
        list_trucks.add(new Truck(1,"Scanio", "RY730", 2015, "Scania"));
        list_trucks.add(new Truck(2,"Actro", "HQS89", 2019, "Mercedes-Benz"));
        list_trucks.add(new Truck(3,"Mano", "TGX25", 2020, "MAN"));
        list_trucks.add(new Truck(4,"Reno", "POI23", 2021, "Renault"));

        getLastTruck();
    }

    public void Truck_Delete(){
        list_trucks.remove(current_truck);

        for (int i = 0; i < list_trucks.size(); i++) {
            list_trucks.get(i).setTruck_id(i);
        }
        getLastTruck();
    }
    public int getTruckCurrentIndex(){
        return list_trucks.indexOf(current_truck);
    }
    public void goPreviousTruck(){
        int next_index = getTruckCurrentIndex()-1;
        System.out.println(next_index);
        if(next_index >= 0){
            current_truck = list_trucks.get(next_index);
        }else{
            System.out.println(goPreviousTruckError());
        }
    }
    public String goPreviousTruckError(){
        return "You are on the first Truck.";
    }
    public void goNextTruck(){
        int next_index = getTruckCurrentIndex()+1;

        if(next_index < list_trucks.size()){
            current_truck = list_trucks.get(next_index);
        }else{
            System.out.println(goNextTruckError());
        }
    }
    public String goNextTruckError(){
        return "You are on the last Truck.";
    }
    public void getFirstTruck() {
        current_truck = list_trucks.get(0);
    }
    public void getLastTruck() {
        current_truck = list_trucks.get(list_trucks.size()-1);
    }
    public Truck getCurrentTruck() {
        return current_truck;
    }
    public void setCurrent_truck(Truck current_truck) {
        this.current_truck = current_truck;
    }
    public String Truck_display_name(int i){
        return list_trucks.get(i).getTruck_name();
    }
    public int Truck_length(){
        return list_trucks.size();
    }
}