package Controller;

import Model.Driver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Controller_Driver {
    //public final ArrayList<Driver> map_drivers = new ArrayList<>();
    public final LinkedHashMap<Integer, Driver> map_drivers = new LinkedHashMap<>();
    private Driver current_driver;

    public Controller_Driver() {

//        list_drivers.add(new Driver(0,"JP", "Belmondo", 15, "cemetery"));
//        list_drivers.add(new Driver(1,"Louis", "de Funes", 20, "cemetery too"));
//        list_drivers.add(new Driver(2,"Jean", "Gabin", 25, "same"));
//        list_drivers.add(new Driver(3,"Chuck", "Noris", 30, "i don't know, if not, soon"));
//        list_drivers.add(new Driver(4,"Sean", "Connery", 35, "sadly ..."));

        map_drivers.put(0, new Driver(0, "JP", "Belmondo", 15, "cemetery"));
        map_drivers.put(1, new Driver(1, "Louis", "de Funes", 20, "cemetery too"));
        map_drivers.put(2, new Driver(2, "Jean", "Gabin", 25, "same"));
        map_drivers.put(3, new Driver(3, "Chuck", "Noris", 30, "i don't know, if not, soon"));
        map_drivers.put(4, new Driver(4, "Sean", "Connery", 35, "sadly ..."));

        getLastDriver();
    }

    public void Driver_Delete(){
        map_drivers.remove(current_driver.getDriver_id());



//        for (int i = 0; i < list_drivers.size(); i++) {
//            list_drivers.get(i).setDriver_id(i);
//        }

        //System.out.println(list_drivers.get(0).getDriver_id());
        getLastDriver();

    }


    public void goPreviousDriver(){
        for (int i = 1; i < map_drivers.size(); i++) {
            if(map_drivers.containsKey(current_driver.getDriver_id()-i)) {
                current_driver = map_drivers.get(current_driver.getDriver_id()-i);
            }
        }
    }
    public String goPreviousDriverError(){
        return "You are on the first Driver.";
    }
    public void goNextDriver(){
        for (int i = 1; i < map_drivers.size(); i++) {
            if(map_drivers.containsKey(current_driver.getDriver_id()+i)) {
                current_driver = map_drivers.get(current_driver.getDriver_id()+i);
            }
        }
    }
    public String goNextDriverError(){
        return "You are on the last Driver.";
    }
    public void getFirstDriver() {
        current_driver = map_drivers.get(0);
    }
    public void getLastDriver() {

        int maxKey = -1;

        for (Map.Entry<Integer, Driver> driver : map_drivers.entrySet()) {
            int key = driver.getKey();
            if (key > maxKey) {
                maxKey = key;
            }
        }
        current_driver = map_drivers.get(maxKey);

    }
    public Driver getCurrentDriver() {
        return current_driver;
    }
    public void setCurrent_driver(Driver current_driver) {
        this.current_driver = current_driver;
    }
    public String Driver_display_name(int i){
        return map_drivers.get(i).getDriver_first_name()+" "+ map_drivers.get(i).getDriver_last_name();
    }
    public int Driver_length(){
        return map_drivers.size();
    }
}