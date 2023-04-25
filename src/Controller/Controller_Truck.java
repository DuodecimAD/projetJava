/*
 * 
 */
package Controller;

import Model.Truck;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller_Truck.
 */
public class Controller_Truck {

    /** The List trucks. */
    private Truck List_Trucks[] = new Truck[100];
    
    /** The pos current. */
    private int pos_current;
    
    /** The pos first. */
    private int pos_first;
    
    /** The pos last. */
    private int pos_last;
    
    /** The pos count. */
    private int pos_count;

    /**
     * Instantiates a new controller truck.
     */
    public Controller_Truck() {
        Truck truck1 = new Truck("Max", 0, 200, "Volvo");
        List_Trucks[0] = truck1;
        Truck truck2 = new Truck("Bebe", 10, 200, "Peugeot");
        List_Trucks[1] = truck2;
        Truck truck3 = new Truck("Toto", 100, 200, "Citroen");
        List_Trucks[2] = truck3;
        Truck truck4 = new Truck("Lala", 1000, 200, "chevrolet");
        List_Trucks[3] = truck4;
        Truck truck5 = new Truck("Newt", 10000, 200, "mercedes");
        List_Trucks[4] = truck5;

        pos_current = 4;
        pos_last = 4;
        pos_first = 0;
        pos_count = 5;
    }

    /**
     * Menu.
     */
    public void menu(){
    	
        int choix;
        Scanner scanner = new Scanner(System.in);

        do
        {
            if (pos_count>0)
            {
                do
                {
                    System.out.println("\u001B[95m");
                    System.out.println(List_Trucks[pos_current]);
                    System.out.println("\u001B[36m");
                    System.out.println("******************");
                    System.out.println("*** Menu Truck ***");
                    System.out.println("******************");
                    System.out.print("\u001B[0m");
                    System.out.println("1. New");
                    System.out.println("2. Update");
                    System.out.println("3. Delete");
                    System.out.println("4. Next");
                    System.out.println("5. Previous");
                    System.out.println("6. First");
                    System.out.println("7. Last");
                    System.out.println("8. Select Truck");
                    System.out.println("9. Back to Main menu..");
                    System.out.println("Your choice ? : ");
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1 -> {
                            if (Truck.getTruck_key() > 99) {
                                System.out.println("Limit 100 Reached");
                            } else {
                                Truck_Create();
                            }
                        }
                        case 2 -> Truck_Update();
                        case 3 -> {
                            List_Trucks[pos_current].setIs_deleted(true);
                            pos_count--;
                            Truck_Checklist();
                            pos_current = pos_last;
                        }
                        case 4 -> Truck_Next();
                        case 5 -> Truck_previous();
                        case 6 -> pos_current = pos_first;
                        case 7 -> pos_current = pos_last;
                        case 8 -> Truck_Select();
                        case 9 -> System.out.println("Back to main menu..");
                        default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
                    }
                }while(choix<0||choix>9);
            }
            else
            {
                do
                {
                    System.out.println("\u001B[95m");
                    System.out.println("No Truck in List");
                    System.out.println("\u001B[36m");
                    System.out.println("******************");
                    System.out.println("*** Truck Menu ***");
                    System.out.println("******************");
                    System.out.print("\u001B[0m");
                    System.out.println("1. New");
                    System.out.println("9. Back to Main menu..");
                    System.out.println("Your choice ? : ");
                    choix=scanner.nextInt();

                    switch (choix) {
                        case 1 -> Truck_Create();
                        case 9 -> System.out.println("Back to main menu..");
                        default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
                    }
                }while(pos_count==0);
            }
        }while(choix!=9);
    }

    /**
     * Truck create.
     */
    public void Truck_Create(){
    	
        Scanner scanner = new Scanner(System.in);

        pos_current = Truck.getTruck_key();


        System.out.println("Please enter the Truck's name : ");
        String name = scanner.nextLine();
        System.out.println("Please enter the Truck's km : ");
        int km_total = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the current amount of fuel : ");
        int fuel = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the Truck's brand : ");
        String brand = scanner.nextLine();

        List_Trucks[Truck.getTruck_key()] = new Truck(name,km_total,fuel,brand);

        if(pos_count==0){
            pos_first=pos_current;
        }
        pos_count++;
        pos_last = pos_current;
    }

    /**
     * Truck update.
     */
    public void Truck_Update(){
    	
        Scanner scanner = new Scanner(System.in);
        int choix;
        do
        {
            System.out.println("\u001B[95m");
            System.out.println(List_Trucks[pos_current]);
            System.out.println("\u001B[36m");
            System.out.println("****************************");
            System.out.println("What do you want to Update ?");
            System.out.println("****************************");
            System.out.print("\u001B[0m");
            System.out.println("1.Truck's name");
            System.out.println("2.Truck's km");
            System.out.println("3.Truck's fuel");
            System.out.println("4.Truck's brand");
            System.out.println("9. Back to Truck menu..");
            System.out.println("Your choice ? : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.println("What's the new Truck's name : ");
                    String name = scanner.nextLine();
                    List_Trucks[pos_current].setTruck_name(name);
                }
                case 2 -> {
                    System.out.println("What's the new Truck's km : ");
                    int km = scanner.nextInt();
                    scanner.nextLine();
                    List_Trucks[pos_current].setTruck_km_total(km);
                }
                case 3 -> {
                    System.out.println("What's the new Truck's fuel : ");
                    int fuel = scanner.nextInt();
                    scanner.nextLine();
                    List_Trucks[pos_current].setTruck_current_fuel(fuel);
                }
                case 4 -> {
                    System.out.println("What's the new Truck's brand : ");
                    String brand = scanner.nextLine();
                    List_Trucks[pos_current].setTruck_brand(brand);
                }
                case 9 -> System.out.println("Back to main menu..");
                default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
            }
        }while(choix !=9);

    }

    /**
     * Truck checklist.
     */
    public void Truck_Checklist(){

        if(pos_count!=0) {

            int i = 0;

            while (List_Trucks[i].isIs_deleted()) {
                i++;
            }
            pos_first = i;

            i = Truck.getTruck_key() - 1;
            while (List_Trucks[i].isIs_deleted()) {
                i--;
            }
            pos_last = i;
        }
    }

    /**
     * Truck next.
     */
    public void Truck_Next(){
    	
        if(pos_current==pos_last){
            System.out.println("You are already on the last item");
        }else{
            do{
                pos_current++;
            }while (List_Trucks[pos_current].isIs_deleted());
        }
    }

    /**
     * Truck previous.
     */
    public void Truck_previous(){
    	
        if(pos_current==pos_first){
            System.out.println("You are already on the first item");
        }else{
            do{
                pos_current--;
            }while (List_Trucks[pos_current].isIs_deleted());
        }
    }

    /**
     * Truck select.
     *
     * @return the int
     */
    public int Truck_Select(){
    	
        int choix;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\u001B[36m");
            System.out.println("************");
            System.out.println("Select Truck");
            System.out.println("************");
            System.out.print("\u001B[0m");
            while(counter!=pos_last+1){
                if(!List_Trucks[counter].isIs_deleted()){
                    System.out.println(
                            "Truck "+ List_Trucks[counter].getTruck_id() +
                            " : " +List_Trucks[counter].getTruck_name());
                }
                counter++;
            }
            System.out.println("Please enter your choice : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            if(choix>pos_last||choix<pos_first|| List_Trucks[choix].isIs_deleted()){
                System.out.print("\u001B[31m");
                System.out.println("Error, please choose a number from the menu");
                System.out.print("\u001B[0m");
            }
        }while(choix>pos_last||choix<pos_first|| List_Trucks[choix].isIs_deleted());

        pos_current= choix;
        return choix;
    }

    /**
     * Truck display name.
     *
     * @param i the i
     * @return the string
     */
    public String Truck_display_name(int i){
    	
        return List_Trucks[i].getTruck_name();
    }

    /**
     * Truck length.
     *
     * @return the int
     */
    public int Truck_length(){
    	
        return pos_count;
    }
}
