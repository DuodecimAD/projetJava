/*
 * 
 */
package Controller;

import Model.Travel;

import java.util.Objects;
import java.util.Scanner;

/**
 * The Class Controller_Travel.
 */
public class Controller_Travel {
    
    /** The list travels. */
    private Travel list_Travels[] = new Travel[1000];
    
    /** The pos current. */
    private int pos_current;
    
    /** The pos first. */
    private int pos_first;
    
    /** The pos last. */
    private int pos_last;
    
    /** The pos count. */
    private int pos_count;

    /**
     * Instantiates a new controller travel.
     */
    public Controller_Travel() {
        Travel Travel1 = new Travel(0, 1, 59, "19/03/2023");
        list_Travels[0] = Travel1;
        Travel Travel2 = new Travel(1, 2, 25, "19/03/2023");
        list_Travels[1] = Travel2;
        Travel Travel3 = new Travel(2, 3, 67, "19/03/2023");
        list_Travels[2] = Travel3;
        Travel Travel4 = new Travel(3, 4, 91, "19/03/2023");
        list_Travels[3] = Travel4;
        Travel Travel5 = new Travel(4, 0, 27, "20/03/2023");
        list_Travels[4] = Travel5;
        Travel Travel6 = new Travel(0, 0, 68, "20/03/2023");
        list_Travels[5] = Travel6;
        Travel Travel7 = new Travel(1, 1, 55, "20/03/2023");
        list_Travels[6] = Travel7;
        Travel Travel8 = new Travel(2, 2, 82, "20/03/2023");
        list_Travels[7] = Travel8;


        pos_current = pos_last = 7;
        pos_first = 0;
        pos_count = 8;
    }

    /**
     * Menu.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
    public void menu(Controller_Driver c_driver, Controller_Truck c_truck){
    	
        Scanner scanner = new Scanner(System.in);
        int choix;

        do
        {
            if (pos_count>0)
            {
                do
                {
                    System.out.println("\u001B[95m");
                    System.out.println(Travel_Current(c_driver,c_truck));
                    System.out.println("\u001B[36m");
                    System.out.println("*******************");
                    System.out.println("*** Travel Menu ***");
                    System.out.println("*******************");
                    System.out.print("\u001B[0m");
                    System.out.println("1. New Travel");
                    System.out.println("2. Update Travel");
                    System.out.println("3. Delete Travel");
                    System.out.println("4. Next");
                    System.out.println("5. Previous");
                    System.out.println("6. First");
                    System.out.println("7. Last");
                    System.out.println("8. Select Travel");
                    System.out.println("9. Back to Main menu..");
                    System.out.println("Your choice ? : ");
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1 -> Travel_Create(c_driver,c_truck);
                        case 2 -> Travel_Update(c_driver,c_truck);
                        case 3 -> {
                            list_Travels[pos_current].setIs_deleted(true);
                            pos_count--;
                            Travel_Checklist();
                            pos_current = pos_last;
                        }
                        case 4 -> Travel_Next();
                        case 5 -> Travel_Previous();
                        case 6 -> pos_current = pos_first;
                        case 7 -> pos_current = pos_last;
                        case 8 -> Travel_Select(c_driver,c_truck);
                        case 9 -> System.out.println("Back to Main menu..");
                        default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
                    }
                }while(choix !=9);
            }
            else
            {
                do
                {
                    System.out.println("\u001B[95m");
                    System.out.println("No Travel in List");
                    System.out.println("\u001B[36m");
                    System.out.println("*******************");
                    System.out.println("*** Travel Menu ***");
                    System.out.println("*******************");
                    System.out.print("\u001B[0m");
                    System.out.println("1. New Travel");
                    System.out.println("9. Back to Main menu..");
                    System.out.println("Your choice ? : ");
                    choix=scanner.nextInt();

                    switch (choix) {
                        case 1 -> Travel_Create(c_driver,c_truck);
                        case 9 -> System.out.println("Back to Main menu..");
                        default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
                    }
                }while(pos_count==0);
            }
        }while(choix!=9);
    }

    /**
     * Travel current.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     * @return the string
     */
    public String Travel_Current(Controller_Driver c_driver,Controller_Truck c_truck){
    	
        return "****************************************"+
                "\nCurrent Travel {" +
                "\n    Travel number = " + list_Travels[pos_current].getTravel_id() +
                ",\n    Driver = " + c_driver.Driver_display_name(list_Travels[pos_current].getDriver_fk()) +
                ",\n    Truck = " + c_truck.Truck_display_name(list_Travels[pos_current].getTruck_fk()) +
                ",\n    Distance = " + list_Travels[pos_current].getTravel_km() +
                " km,\n    Day of travel = " + list_Travels[pos_current].getTravel_day() +
                "\n}"+
                "\n****************************************";
    }
    
    /**
     * Travel create.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
    public void Travel_Create(Controller_Driver c_driver, Controller_Truck c_truck){

        Scanner scanner = new Scanner(System.in);

        pos_current = Travel.getTravel_key();

        System.out.println("Please choose the Driver : ");
        int choice_driver = /*c_driver.Driver_Select()*/1;
        System.out.println("Please choose the Truck : ");
        int choice_truck = c_truck.Truck_Select();
        System.out.println("Please enter the travel distance in km : ");
        int choice_km = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the day of the travel DD/MM/YYYY : ");
        String choice_day = scanner.nextLine();

        list_Travels[Travel.getTravel_key()] = new Travel(choice_driver,choice_truck,choice_km,choice_day);

        if(pos_count==0){
            pos_first=pos_current;
        }
        pos_count++;
        pos_last = pos_current;
    }

    /**
     * Travel checklist.
     */
    public void Travel_Checklist(){

        if(pos_count!=0) {

            int i = 0;

            while (list_Travels[i].isIs_deleted()) {
                i++;
            }
            pos_first = i;

            i = Travel.getTravel_key() - 1;
            while (list_Travels[i].isIs_deleted()) {
                i--;
            }
            pos_last = i;
        }
    }

    /**
     * Travel next.
     */
    public void Travel_Next(){
    	
        if(pos_current==pos_last){
            System.out.println("You are already on the last item");
        }else{
            do{
                pos_current++;
            }while (list_Travels[pos_current].isIs_deleted());
        }
    }

    /**
     * Travel previous.
     */
    public void Travel_Previous(){
    	
        if(pos_current==pos_first){
            System.out.println("You are already on the first item");
        }else{
            do{
                pos_current--;
            }while (list_Travels[pos_current].isIs_deleted());
        }
    }

    /**
     * Travel select.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
    public void Travel_Select(Controller_Driver c_driver,Controller_Truck c_truck){
    	
        int choix;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\u001B[36m");
            System.out.println("*************");
            System.out.println("Select Travel");
            System.out.println("*************");
            System.out.print("\u001B[0m");
            while(counter!=pos_last+1){
                if(!list_Travels[counter].isIs_deleted()){
                    System.out.println(
                            "Travel ID = "+ list_Travels[counter].getTravel_id() +
                            " - Driver = "+ c_driver.Driver_display_name(list_Travels[counter].getDriver_fk()) +
                            " - Truck = "+  c_truck.Truck_display_name(list_Travels[counter].getTruck_fk()) +
                            " - km = "+     list_Travels[counter].getTravel_km() +
                            " - date = "+   list_Travels[counter].getTravel_day()
                    );
                }
                counter++;
            }
            System.out.println("Please enter your choice : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            if(choix>pos_last || choix<pos_first || list_Travels[choix].isIs_deleted()){
                System.out.print("\u001B[31m");
                System.out.println("Error, please choose a number from the menu");
                System.out.print("\u001B[0m");
            }
        }while(choix>pos_last || choix<pos_first || list_Travels[choix].isIs_deleted());

        pos_current= choix;
    }

    /**
     * Travel update.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
    public void Travel_Update(Controller_Driver c_driver, Controller_Truck c_truck){
    	
        int choix = 0;
        Scanner scanner = new Scanner(System.in);

        do
        {
            System.out.println("\u001B[95m");
            System.out.println(Travel_Current(c_driver,c_truck));
            System.out.println("\u001B[36m");
            System.out.println("****************************");
            System.out.println("What do you want to Update ?");
            System.out.println("****************************");
            System.out.print("\u001B[0m");
            System.out.println("1. Driver");
            System.out.println("2. Truck");
            System.out.println("3. Distance");
            System.out.println("4. Date");
            System.out.println("9. Back to Travel Menu");
            System.out.println("Your choice ? : ");
            choix=scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
               /* case 1 -> {
                    System.out.println("Please choose the Driver : ");
                    int driver = c_driver.Driver_Select();
                    list_Travels[pos_current].setDriver_fk(driver);
                }*/
                case 2 -> {
                    System.out.println("Please enter the Truck : ");
                    int truck = c_truck.Truck_Select();
                    list_Travels[pos_current].setTruck_fk(truck);
                }
                case 3 -> {
                    System.out.println("Please enter the new Distance in km : ");
                    int km = scanner.nextInt();
                    scanner.nextLine();
                    list_Travels[pos_current].setTravel_km(km);
                }
                case 4 -> {
                    System.out.println("Please enter the day of the travel DD/MM/YYYY : ");
                    String date = scanner.nextLine();
                    list_Travels[pos_current].setTravel_day(date);
                }
                case 9 -> System.out.println("Back to Travel menu..");
                default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
            }
        }while(choix !=9);
    }

    /**
     * Stats.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
    public void stats(Controller_Driver c_driver, Controller_Truck c_truck){
    	
        Scanner scanner = new Scanner(System.in);
        int choix;
        do
        {
            System.out.println("\u001B[36m");
            System.out.println("******************");
            System.out.println("*** Stats Menu ***");
            System.out.println("******************");
            System.out.print("\u001B[0m");
            System.out.println("1. List each Truck drove by a selected Driver");
            System.out.println("2. List each Driver who drove a selected Truck");
            System.out.println("3. Show Driver who drove the most different Trucks");
            System.out.println("4. Show Truck which has been driven the most by different Drivers");
            System.out.println("5. Show Driver who drove the longest single Travel");
            System.out.println("6. Show Truck which has the longest single Travel");
            System.out.println("7. Show Driver who drove the most");
            System.out.println("8. Show Truck which has been driven the most");
            System.out.println("9. Back to Main menu..");
            System.out.println("Your choice ? : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
           //     case 1 -> List_truck_by_driver(c_driver,c_truck);
                case 2 -> List_driver_used_truck(c_driver,c_truck);
                case 3 -> Travels_byDriver(c_driver);
                case 4 -> Travels_byTruck(c_truck);
                case 5 -> Top_sDriver(c_driver);
                case 6 -> Top_sTruck(c_truck);
                case 7 -> Total_Driver(c_driver);
                case 8 -> Total_Truck(c_truck);
                case 9 -> System.out.println("Back to Main menu..");
                default -> System.out.println("\u001B[31m" + "Error, please choose a number from the menu" + "\u001B[0m");
            }
        }while(choix !=9);
    }


    /**
     * List truck by driver.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
/*    public void List_truck_by_driver(Controller_Driver c_driver, Controller_Truck c_truck){

        int driver = c_driver.Driver_Select();

        String drove[] = new String[c_truck.Truck_length()];
        int count = 0;

        System.out.print("\u001B[95m");
        System.out.print("You have selected Driver "+ c_driver.Driver_display_name(driver) + " and he drove ");
        for (int i = 0; i < pos_count; i++) {
            if(!list_Travels[i].isIs_deleted() && list_Travels[i].getDriver_fk() == driver){

                boolean exists = false;

                if(count > 0){
                    for (int j = 0; j < count; j++) {
                        if(Objects.equals(drove[j], c_truck.Truck_display_name(list_Travels[i].getTruck_fk()))) {
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists) {
                    drove[count] = c_truck.Truck_display_name(list_Travels[i].getTruck_fk());
                    count++;
                }

            }
        }

        if(count == 1){
            System.out.println(count + " Truck : ");
            System.out.print(drove[0] + ".");
        }else {
            System.out.println(count + " Trucks : ");
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    System.out.print(drove[i] + ".");
                }else if(i == count-2){
                    System.out.print(drove[i] + " and ");
                }else {
                    System.out.print(drove[i] + ", ");
                }
            }
        }
        System.out.println("\u001B[0m");
    }

    /**
     * List driver used truck.
     *
     * @param c_driver the c driver
     * @param c_truck the c truck
     */
    public void List_driver_used_truck(Controller_Driver c_driver, Controller_Truck c_truck){

        int truck = c_truck.Truck_Select();

        String driven[] = new String[c_driver.Driver_length()];
        int count = 0;

        System.out.print("\u001B[95m");
        System.out.print("You have selected Truck "+ c_truck.Truck_display_name(truck) + " and it Had been driven by ");
        for (int i = 0; i < pos_count; i++) {
            if(!list_Travels[i].isIs_deleted() && list_Travels[i].getTruck_fk() == truck) {

                boolean exists = false;

                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        if (Objects.equals(driven[j], c_driver.Driver_display_name(list_Travels[i].getDriver_fk()))) {
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists) {
                    driven[count] = c_driver.Driver_display_name(list_Travels[i].getDriver_fk());
                    count++;
                }
            }
        }

        if(count == 1){
            System.out.println(count + " Driver : ");
            System.out.print(driven[0] + ".");
        }else {
            System.out.println(count + " Drivers : ");
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    System.out.print(driven[i] + ".");
                }else if(i == count-2){
                    System.out.print(driven[i] + " and ");
                }else {
                    System.out.print(driven[i] + ", ");
                }
            }
        }
        System.out.println("\u001B[0m");
    }

    /**
     * Travels by driver.
     *
     * @param c_driver the c driver
     */
    public void Travels_byDriver(Controller_Driver c_driver){

        // nb drivers
        int drivers = c_driver.Driver_length();

        // nb trucks used by each driver
        int travels[] = new int[drivers];
        for (int i = 0; i < pos_count; i++) {
                travels[list_Travels[i].getDriver_fk()]++;
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

        System.out.print("\u001B[95m");
        if (count == 1){
            for (int i = 0; i < drivers; i++) {
                if( travels[i] == max){
                    System.out.println("Driver " + c_driver.Driver_display_name(travels[i]) + " drove " + max + " Trucks, which is the most.");
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

            System.out.print("Drivers ");
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    System.out.print(names[i] + " ");
                }else if(i == count-2){
                    System.out.print(names[i] + " and ");
                }else {
                    System.out.print(names[i] + ", ");
                }
            }
            System.out.println("drove " + max + " Trucks, which is the most.");
        }
        System.out.println("\u001B[0m");
    }

    /**
     * Travels by truck.
     *
     * @param c_truck the c truck
     */
    public void Travels_byTruck(Controller_Truck c_truck){

        // nb drivers
        int trucks = 0;
        for (int i = 0; i < pos_count; i++) {
            if(list_Travels[i].getTruck_fk() > trucks){
                trucks = list_Travels[i].getTruck_fk();
            }
        }
        trucks = trucks+1;

        // nb trucks used by each driver
        int travels[] = new int[trucks];
        for (int i = 0; i < pos_count; i++) {
            travels[list_Travels[i].getTruck_fk()]++;
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

        System.out.print("\u001B[95m");
        if (count == 1){
            for (int i = 0; i < trucks; i++) {
                if( travels[i] == max){
                    System.out.println("Truck " + c_truck.Truck_display_name(travels[i]) + " has been driven by " + max + " Drivers, which is the most.");
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

            System.out.print("Trucks ");
            for (int i = 0; i < count; i++) {
                if(i == count-1){
                    System.out.print(names[i] + " ");
                }else if(i == count-2){
                    System.out.print(names[i] + " and ");
                }else {
                    System.out.print(names[i] + ", ");
                }
            }
            System.out.println("have been driven by " + max + " Drivers, which is the most.");
        }
        System.out.println("\u001B[0m");
    }

    /**
     * Top s driver.
     *
     * @param c_driver the c driver
     */
    public void Top_sDriver(Controller_Driver c_driver){
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < pos_count; i++) {
            if (list_Travels[i].getTravel_km() > highest_km){
                highest_km = list_Travels[i].getTravel_km();
                top_driver = list_Travels[i].getDriver_fk();
            }
        }
        System.out.print("\u001B[95m");
        System.out.println("Driver " + c_driver.Driver_display_name(top_driver) + " has the longest single Travel with " + highest_km + " km.");
        System.out.print("\u001B[0m");
    }

    /**
     * Top s truck.
     *
     * @param c_truck the c truck
     */
    public void Top_sTruck(Controller_Truck c_truck){
        int highest_km = 0;
        int top_truck = -1;

        for (int i = 0; i < pos_count; i++) {
            if (list_Travels[i].getTravel_km() > highest_km){
                highest_km = list_Travels[i].getTravel_km();
                top_truck = list_Travels[i].getDriver_fk();
            }
        }
        System.out.print("\u001B[95m");
        System.out.println("Truck " + c_truck.Truck_display_name(top_truck) + " has the longest single Travel with " + highest_km + " km.");
        System.out.print("\u001B[0m");
    }

    /**
     * Total driver.
     *
     * @param c_driver the c driver
     */
    public void Total_Driver(Controller_Driver c_driver){

        int nbDrivers = c_driver.Driver_length();
        int nbTravels = pos_count;
        int km_byDriver[] = new int[nbDrivers];
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < nbTravels; i++) {
            km_byDriver[list_Travels[i].getDriver_fk()] += list_Travels[i].getTravel_km();
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

        System.out.print("\u001B[95m");
        System.out.println("Driver " + c_driver.Driver_display_name(index) + " drove the most with " + km_byDriver[index] + " km.");
        System.out.print("\u001B[0m");
    }

    /**
     * Total truck.
     *
     * @param c_truck the c truck
     */
    public void Total_Truck(Controller_Truck c_truck){
    	
        int nbTrucks = c_truck.Truck_length();
        int nbTravels = pos_count;
        int km_byTruck[] = new int[nbTrucks];
        int highest_km = 0;
        int top_driver = -1;

        for (int i = 0; i < nbTravels; i++) {
            km_byTruck[list_Travels[i].getDriver_fk()] += list_Travels[i].getTravel_km();
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

        System.out.print("\u001B[95m");
        System.out.println("Truck " + c_truck.Truck_display_name(index) + " has been driven the most with " + km_byTruck[index] + " km.");
        System.out.print("\u001B[0m");
    }
}
