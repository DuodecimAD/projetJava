package Controller;

import Model.Driver;
import java.util.ArrayList;

public class Controller_Driver {
    public final ArrayList<Driver> list_drivers = new ArrayList<>();
    private Driver current_driver;

    public Controller_Driver() {

        list_drivers.add(new Driver(0,"JP", "Belmondo", 15, "cemetery"));
        list_drivers.add(new Driver(1,"Louis", "de Funes", 20, "cemetery too"));
        list_drivers.add(new Driver(2,"Jean", "Gabin", 25, "same"));
        list_drivers.add(new Driver(3,"Chuck", "Noris", 30, "i don't know, if not, soon"));
        list_drivers.add(new Driver(4,"Sean", "Connery", 35, "sadly ..."));

        getLastDriver();
    }

    public void Driver_Delete(){
        list_drivers.remove(current_driver);

        for (int i = 0; i < list_drivers.size(); i++) {
            list_drivers.get(i).setDriver_id(i);
        }
        getLastDriver();
    }
    public int getDriverCurrentIndex(){
        return list_drivers.indexOf(current_driver);
    }
    public void goPreviousDriver(){
        int next_index = getDriverCurrentIndex()-1;
        System.out.println(next_index);
        if(next_index >= 0){
            current_driver = list_drivers.get(next_index);
        }else{
            System.out.println(goPreviousDriverError());
        }
    }
    public String goPreviousDriverError(){
        return "You are on the first Driver.";
    }
    public void goNextDriver(){
        int next_index = getDriverCurrentIndex()+1;

        if(next_index < list_drivers.size()){
            current_driver = list_drivers.get(next_index);
        }else{
            System.out.println(goNextDriverError());
        }
    }
    public String goNextDriverError(){
        return "You are on the last Driver.";
    }
    public void getFirstDriver() {
        current_driver = list_drivers.get(0);
    }
    public void getLastDriver() {
       current_driver = list_drivers.get(list_drivers.size()-1);
    }
    public Driver getCurrentDriver() {
        return current_driver;
    }
    public void setCurrent_driver(Driver current_driver) {
        this.current_driver = current_driver;
    }
    public String Driver_display_name(int i){
        return list_drivers.get(i).getDriver_first_name()+" "+list_drivers.get(i).getDriver_last_name();
    }
    public int Driver_length(){
        return list_drivers.size();
    }
}