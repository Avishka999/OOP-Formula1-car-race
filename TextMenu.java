import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class TextMenu {

    Scanner s1= new Scanner(System.in);
    Formula1ChampionshipManager f1championshipManager= new Formula1ChampionshipManager();

    public TextMenu() {
        try {
            f1championshipManager.dataRetrieve();
        } catch (IOException e) {
        }
        menu();
    }

    public void menu(){
        menuloop:
        while (true){
            menuList();
            System.out.println("ENTER");
            String number = s1.nextLine();
try {


            switch (number) {

                case "0":
                    addDriver(); //call the function to add a driver
                    break;
                case "1":
                    deleteDriver(); //call the function to delete a driver
                    break;
                case "2":
                    changeDriver(); //call the function to change the driver for the team
                    break;
                case "3":
                    driverState();//call the function to get driver state
                    break;
                case "4":
                    print();//call the function to get points table
                    break;
                case "5":
                    addRace(); //call the function to add a race manually
                    break;
                case "6":
                    save(); // save the details
                    break;
                case "x":
                    System.out.println("THANK YOU......");
                    break menuloop;


                default:
                    System.out.println("****Try Again****");//if the details are not valid try again
                    break;
            }


            }
            catch (Exception e){
               System.out.println("something wrong try again");
                }
        }
    }

    private void save() {
        f1championshipManager.save();
    }

    private void addRace() {  //list to store the drivers according to the finishing position
        System.out.println("ENTER THE YEAR ");
        int year = s1.nextInt();
        s1.nextLine();
        System.out.println("ENTER THE MONTH");
        int month= s1.nextInt();
        s1.nextLine();
        System.out.println("ENTER THE TIME");
        int day= s1.nextInt();
        s1.nextLine();

        if (year<2100 && month<13 && day<32 ){
            LocalDate localDate=LocalDate.of(year,month,day);
            LocalDate now = LocalDate.now();
            if (localDate.compareTo(now)<=0){
                f1championshipManager.newRace(year,month,day);


            }else {
                System.out.println(" DATE IS INVALID");
            }
        }

    }

    private void driverState() {
        System.out.println("ENTER DRIVER TEAM");
        String team=s1.nextLine();
        f1championshipManager.driverState(team);
    }

    private void print() {
        f1championshipManager.print();
    }

    private void changeDriver() {
        int[] position =new int[10];
        System.out.println("ENTER  EXISTING CONSTRUCTOR TEAM NAME");
        String team = s1.nextLine();
        System.out.println("ENTER NEW DRIVER NAME ");
        String name = s1.nextLine();
        System.out.println("ENTER NEW DRIVER AGE ");
        int age= s1.nextInt();
        s1.nextLine();
        System.out.println("DRIVER NEW LOCATION");
        String location= s1.nextLine();
        System.out.println("ENTER NEW  DRIVER POSITIONS");
        for (int i = 1; i < 11; i++) {
            switch (i){
                case 1:
                    System.out.println("NUMBER OF "+i+"'KLT POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 2 :
                    System.out.println("NUMBER OF "+i+"'GTX POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 3:
                    System.out.println("NUMBER OF "+i+"'MMM POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 4:
                    System.out.println("NUMBER OF "+i+"'GHJ POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    System.out.println("NUMBER OF "+i+"'JK POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;


            }
        }
        System.out.println("TOTAL RACE COUNT ");
        int rCount = s1.nextInt();
        s1.nextLine();

        f1championshipManager.driverChange(team,age,name,location,position,rCount);     //validate the given inputs

    }

    private void deleteDriver() {
        System.out.println("ENTER CONSTRUCTOR TEAM NAME");
        String team= s1.nextLine();


        f1championshipManager.driverDelete(team); //if the details are valid delete new driver

    }

    private void addDriver() { //add driver method

        int[] position =new int[10];



        System.out.println("ENTER DRIVER NAME ");
        String name = s1.nextLine();
        System.out.println("ENTER DRIVER AGE ");
        int age = s1.nextInt();
        s1.nextLine();
        System.out.println("DRIVER LOCATION");
        String location= s1.nextLine();
        System.out.println("ENTER DRIVER TEAM");
        String teamName= s1.nextLine();
        System.out.println("ENTER DRIVER POSITIONS");

        for (int i = 1; i < 11; i++) {
            switch (i){
                case 1:
                    System.out.println("NUMBER OF "+i+"'KLT POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 2 :
                    System.out.println("NUMBER OF "+i+"'GTX POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 3:
                    System.out.println("NUMBER OF "+i+"'MMM POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 4:
                    System.out.println("NUMBER OF "+i+"'GHJ POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    System.out.println("NUMBER OF "+i+"'JK POSITIONS ");
                    position[i-1]= s1.nextInt();
                    s1.nextLine();
                    break;


            }
        }
        System.out.println("TOTAL RACE COUNT ");
        int rCount = s1.nextInt();
        s1.nextLine();

        f1championshipManager.newDriver(name,age,location,teamName,position,rCount);

    }

    private void menuList() {               //display the menu to user

        System.out.println("----------------------------------------------------------------------------MENU-----------------------------------------------------------------------------");
        System.out.println("ADD NEW DRIVER                       : ENTER 0");
        System.out.println("DELETE EXISTING DRIVER AND TEAM      : ENTER 1");
        System.out.println("CHANGE DRIVER EXISTING TEAM          : ENTER 2");
        System.out.println("DRIVER STATISTICS                    : ENTER 3");
        System.out.println("DRIVER TABLE                         : ENTER 4");
        System.out.println("ADD NEW RACE                         : ENTER 5");
        System.out.println("SAVE                                 : ENTER 6");





    }
}
