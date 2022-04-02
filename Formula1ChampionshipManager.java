import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager{
    Scanner s1=new Scanner(System.in);
    private int  noOfDrivers = Formula1Driver.driverCount;
    private int cars=noOfDrivers;
    public ArrayList<Formula1Driver> f1Driver=new ArrayList<Formula1Driver>(); //arraylist to store drivers
    public ArrayList<Race> fRace=new ArrayList<Race>();          //main arraylist to store races

    public Formula1ChampionshipManager() {

   }

    @Override
    public void  newDriver(String name, int age, String location, String teamName, int[] position, int raceCount){  // new driver add and check validation
    boolean validation= validation(name,teamName);
    if (validation){
        Formula1Driver formula1Driver=new Formula1Driver(name,age,location,teamName,position,raceCount);
        f1Driver.add(formula1Driver);
    }else {
        System.out.println("****Try Again****"); //if the details are not valid try again
        }
    }
    @Override
    public void driverDelete(String teamname){ // (driver delete method)

        boolean validation= deletevalidation(teamname);
        if (validation){
            for (Formula1Driver driver:f1Driver
                 ) {
                if (driver.getConstructorTeam().toUpperCase().equals(teamname.toUpperCase())){
                    f1Driver.remove(driver);
                    Formula1Driver.driverCount--;
                    System.out.println("SUCCESSFULLY REMOVED"); // driver deleted successfully
                    break;

                }
            }

        }
    }
    @Override
    public void driverChange(String team,int age,String name,String location,int [] position,int rCount){
        boolean validation = deletevalidation(team);
        for (Formula1Driver driver:f1Driver) {
            if (validation) {
                driver.setDriverName(name);
                driver.setDriverLocation(location);
                driver.setPosition(position);
                driver.setNumberOfRace(rCount);
            }
            }




    }
    public void driverState(String team ) {

        boolean validation= deletevalidation(team);
        if (validation){
            for (Formula1Driver driver:f1Driver
                 ) {
                if (driver.getConstructorTeam().toUpperCase().equals(team.toUpperCase())){
                    System.out.println("****************************************************************************************************************************************");
                    System.out.println(driver);
                    System.out.println("****************************************************************************************************************************************");
                }
            }
        }
    }


    @Override
    public boolean validation(String name, String teamname) {

        for (Formula1Driver i :f1Driver) {
        if (i.getDriverName().toUpperCase().equals(name.toUpperCase())){
            System.out.println("DRIVER ALREADY EXISTS");
            return false;
        }else if (i.getConstructorTeam().toUpperCase().equals(teamname.toUpperCase())){
            System.out.println("DRIVER CONSTRUCTOR TEAM ALREADY EXISTS");
            return false;
        }
        }
        return true;
    }
    @Override // driver delete validation
    public boolean deletevalidation(String teamname) {

        for (Formula1Driver i :f1Driver) {
            if (i.getConstructorTeam().toUpperCase().equals(teamname.toUpperCase())){

                return true;
            }
            }
        return false;
        }

    @Override
    public void save() {
        try {
            FileOutputStream driver = new FileOutputStream("driver.txt");
            FileOutputStream race = new FileOutputStream("race.txt");
            ObjectOutputStream dOut = new ObjectOutputStream(driver);
            ObjectOutputStream rOut = new ObjectOutputStream(race);
            for (Formula1Driver f:f1Driver
                 ) {
                dOut.writeObject(f);
            }
            for (Race r: fRace
                 ) {
                rOut.writeObject(r);

            }


            dOut.close();
            rOut.close();
            driver.close();
            race.close();
            System.out.printf("SAVED\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public  void dataRetrieve() throws IOException {

        FileInputStream driverin = new FileInputStream("driver.txt");
        FileInputStream racein = new FileInputStream("race.txt");
        ObjectInputStream din = new ObjectInputStream(driverin);
        ObjectInputStream rin = new ObjectInputStream(racein);
        while (true) {
            try {
                Formula1Driver f1 = (Formula1Driver) din.readObject();
                f1Driver.add(f1);

            } catch (ClassNotFoundException e) {
                break;
            }}
            while (true) {
                try {
                    Race r1 = (Race) rin.readObject();
                    fRace.add(r1);
                } catch (ClassNotFoundException e) {
                    break;
                }
            }

        din.close();
        rin.close();
        driverin.close();
        racein.close();

        System.out.println("done");

    }
    public void print() {
        int n=1;
        Collections.sort(f1Driver);
        for (Formula1Driver d:f1Driver
             ) {
            System.out.println(n+"POSITION>>>>>>>");
            n++;
            System.out.println(d);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }



    public void newRace(int year, int month, int day) {
        for (Formula1Driver f:f1Driver
             ) {
            System.out.println("ENTER TEAM "+f.getConstructorTeam().toUpperCase()+" WIN  POSITIOM ");
            int position=s1.nextInt();
            s1.nextLine();
            if(f1Driver.size()<=position-1){
            Race race=new Race(year,month,day,f.getConstructorTeam(),position);
            fRace.add(race);
                if (position<11) {
                    f.setPosition(position-1);
            }

            }else {
                System.out.println("POSITION IS GREATER THAN DRIVER COUNT");
            }


        }


    }

}
