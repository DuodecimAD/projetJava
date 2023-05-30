package Controller;

import Model.Driver;
import java.util.LinkedHashMap;


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

    public int getDriverCurrentIndex(){
        return current_driver.getDriver_id();
    }
    public void Driver_Delete(){
        map_drivers.remove(current_driver.getDriver_id());
        getLastDriver();
    }
    public void goPreviousDriver(){
        int currentKey = current_driver.getDriver_id();
        int previousKey = -1;

        for (Integer key : map_drivers.keySet()) {
            if (key == currentKey) {
                break;
            }
            previousKey = key;
        }

        if (previousKey != -1) {
            current_driver = map_drivers.get(previousKey);
        }
    }
    public String goPreviousDriverError(){
        return "You are on the first Driver.";
    }
    public void goNextDriver(){
        int currentKey = current_driver.getDriver_id();
        boolean found = false;
        int nextKey = -1;

        for (Integer key : map_drivers.keySet()) {
            if(found){
                nextKey = key;
                break;
            }

            if (key == currentKey) {
                found = true;
            }
        }

        if (found && nextKey != -1) {
            current_driver = map_drivers.get(nextKey);
        }
    }
    public String goNextDriverError(){
        return "You are on the last Driver.";
    }
    public void getFirstDriver() {
        for (int key : map_drivers.keySet()) {
            current_driver = map_drivers.get(key);
            return;
        }
    }
    public int getFirstDriverIndex() {
        int firstKey = -1;
        for (int key : map_drivers.keySet()) {
            firstKey = key;
            break;
        }
        return firstKey;
    }
    public void getLastDriver() {
        int lastKey = -1;

        for (int key : map_drivers.keySet()) {
            lastKey = key;
        }
        current_driver = map_drivers.get(lastKey);
    }
    public int getLastDriverIndex() {
        int lastKey = -1;

        for (int key : map_drivers.keySet()) {
            lastKey = key;
        }
        return lastKey;
    }
    public Driver getCurrentDriver() {
        return current_driver;
    }
    public void setCurrent_driver(Driver current_driver) {
        this.current_driver = current_driver;
    }
    public String Driver_display_name(int i){

        try {
            return map_drivers.get(i).getDriver_first_name()+" "+ map_drivers.get(i).getDriver_last_name();
        }catch (Exception e){
            System.out.println("error controllerDriverL126 : "+e);
            return "Deleted";
        }
    }
    public int Driver_length(){
        return map_drivers.size();
    }
}