/*
 * 
 */
package Controller;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller_Main.
 */
public class Controller_Main {
    
    /** The c truck. */
    Controller_Truck c_truck = new Controller_Truck();
    
    /** The c driver. */
    Controller_Driver c_driver = new Controller_Driver();
    
    /** The c travel. */
    Controller_Travel c_travel = new Controller_Travel();

    /**
     * Menu.
     */
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        do
        {
        	System.out.println("\u001B[36m");
            System.out.println("*****************");
            System.out.println("*** Main Menu ***");
            System.out.println("*****************");
            System.out.print("\u001B[0m");
            System.out.println("1. Drivers");
            System.out.println("2. Trucks");
            System.out.println("3. Travels");
            System.out.println("4. Stats");
            System.out.println("9. Exit");
            System.out.println("Your choice ? : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> c_driver.menu();
                case 2 -> c_truck.menu();
               // case 3 -> c_travel.menu(c_driver, c_truck);
               // case 4 -> c_travel.stats(c_driver, c_truck);
                case 9 -> {
                	System.out.println("Bye :D");
                	scanner.close();
                }
                default -> System.out.println("\u001B[31m" + "wrong choice, please try again" + "\u001B[0m");
            }
        }while(choix !=9);
    }
}
