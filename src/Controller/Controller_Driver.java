/*
 * 
 */
package Controller;

import Model.Driver;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class Controller_Driver.
 */
public class Controller_Driver {

    /** The List drivers. */
    public final ArrayList<Driver> list_drivers = new ArrayList<>();

    private Driver current_driver;
    //private View_Driver view_driver;



    /**
     * Instantiates a new controller driver.
     */
    public Controller_Driver() {

        list_drivers.add(new Driver(0,"JP", "Belmondo", 15, "cemetery"));
        list_drivers.add(new Driver(1,"Louis", "de Funes", 20, "cemetery too"));
        list_drivers.add(new Driver(2,"Jean", "Gabin", 25, "same"));
        list_drivers.add(new Driver(3,"Chuck", "Noris", 30, "i don't know, if not, soon"));
        list_drivers.add(new Driver(4,"Sean", "Connery", 35, "sadly ..."));

        getLastDriver();


    }

    /**
     * Menu.
     */
    public void menu(){

        int choix;
        Scanner scanner = new Scanner(System.in);

        do
        {
            if (list_drivers.size() > 0)
            {
                do
                {
                    System.out.println("\u001B[95m");
                    System.out.println(current_driver);
                    System.out.println("\u001B[36m");
                    System.out.println("*******************");
                    System.out.println("*** Menu Driver ***");
                    System.out.println("*******************");
                    System.out.print("\u001B[0m");
                    System.out.println("1. New");
                    System.out.println("2. Update");
                    System.out.println("3. Delete");
                    System.out.println("4. Previous");
                    System.out.println("5. Next");
                    System.out.println("6. First");
                    System.out.println("7. Last");
                    System.out.println("8. Select Driver");
                    System.out.println("9. Back to Main menu..");
                    System.out.println("Your choice ? : ");
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1 -> Driver_Create();
                        case 2 -> Driver_Update();
                        case 3 -> Driver_Delete();
                        case 4 -> goPreviousDriver();
                        case 5 -> goNextDriver();
                        case 6 -> getFirstDriver();
                        case 7 -> getLastDriver();
                        case 8 -> Driver_Select();
                        case 9 -> System.out.println("Back to main menu");
                        default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
                    }
                }while(choix<0||choix>9);
            }
            else
            {
                do
                {
                    System.out.println("\u001B[95m");
                    System.out.println("No Driver in List");
                    System.out.println("\u001B[36m");
                    System.out.println("*******************");
                    System.out.println("*** Driver Menu ***");
                    System.out.println("*******************");
                    System.out.print("\u001B[0m");
                    System.out.println("1. New");
                    System.out.println("9. Back to Main menu..");
                    System.out.println("Your choice ? : ");
                    choix=scanner.nextInt();

                    switch (choix) {
                        case 1 -> Driver_Create();
                        case 9 -> System.out.println("Back to main menu..");
                        default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
                    }
                }while(list_drivers.size()==0);
            }
        }while(choix!=9);
    }

    /**
     * Driver create.
     */
    public void Driver_Create(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the Driver's First name : ");
        String first_name = scanner.nextLine();
        System.out.println("Please enter the Driver's Last Name : ");
        String last_name = scanner.nextLine();
        System.out.println("Please enter the Driver's age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the Driver's address : ");
        String address = scanner.nextLine();
        int key = list_drivers.size();

        list_drivers.add(new Driver(key,first_name,last_name,age,address));
        getLastDriver();
    }

    /**
     * Driver update.
     */
    public void Driver_Update(){

        Scanner scanner = new Scanner(System.in);
        int choix;
        do
        {
            System.out.println("\u001B[94m");
            System.out.println(current_driver);
            System.out.println("\u001B[36m");
            System.out.println("****************************");
            System.out.println("What do you want to Update ?");
            System.out.println("****************************");
            System.out.print("\u001B[0m");
            System.out.println("1.Driver's first name");
            System.out.println("2.Driver's last name");
            System.out.println("3.Driver's age");
            System.out.println("4.Driver's address");
            System.out.println("9. Back to Driver menu..");
            System.out.println("Your choice ? : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.println("What's the new Driver's first name : ");
                    String first_name = scanner.nextLine();
                    current_driver.setDriver_first_name(first_name);
                }
                case 2 -> {
                    System.out.println("What's the new Driver's last name : ");
                    String last_name = scanner.nextLine();
                    current_driver.setDriver_last_name(last_name);
                }
                case 3 -> {
                    System.out.println("What's the new Driver's age : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    current_driver.setDriver_age(age);
                }
                case 4 -> {
                    System.out.println("What's the new Driver's address : ");
                    String address = scanner.nextLine();
                    current_driver.setDriver_address(address);
                }
                case 9 -> System.out.println("Back to Driver menu..");
                default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
            }
        }while(choix !=9);

    }

    /**
     * Driver checklist.
     */
    public void Driver_Delete(){

        list_drivers.remove(current_driver);

        for (int i = 0; i < list_drivers.size(); i++) {
            list_drivers.get(i).setDriver_id(i);
        }

        getLastDriver();

    }

    public int getCurrentIndex(){
        return list_drivers.indexOf(current_driver);
    }

    /**
     * Driver previous.
     */
    public void goPreviousDriver(){
        int next_index = getCurrentIndex()-1;
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


    /**
     * Driver next.
     */
    public void goNextDriver(){
        int next_index = getCurrentIndex()+1;

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

    /**
     * Driver select.
     */
    public void Driver_Select(){

        int choix;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\u001B[36m");
            System.out.println("*************");
            System.out.println("Select Driver");
            System.out.println("*************");
            System.out.print("\u001B[0m");
            for (Driver driver : list_drivers) {
                System.out.println("Driver "+
                    list_drivers.indexOf(driver)+" : "+
                    driver.getDriver_first_name() +" "+
                    driver.getDriver_last_name()
                );
            }
            System.out.println("Please enter your choice : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            if(choix < 0 || choix >= list_drivers.size()){
                System.out.print("\u001B[31m");
                System.out.println("Error, please choose a number from the menu");
                System.out.print("\u001B[0m");
            }
        }while(choix < 0 || choix >= list_drivers.size());

        current_driver = list_drivers.get(choix);
    }

    /**
     * Driver display name.
     *
     * @param i the i
     * @return the string
     */
    public String Driver_display_name(int i){

        return list_drivers.get(i).getDriver_first_name()+" "+list_drivers.get(i).getDriver_last_name();
    }

    /**
     * Driver length.
     *
     * @return the int
     */
    public int Driver_length(){

        return list_drivers.size();
    }


}
