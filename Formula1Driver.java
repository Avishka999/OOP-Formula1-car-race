import java.io.Serializable;
import java.util.Arrays;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver>, Serializable {
    public static int  driverCount;
    private String constructorTeam;

    private int driverPoint;
    private  int numberOfRace;
    private int position[]= new int[10];
    private int positionPoint[]={25,18,15,12,10,8,6,4,2,1};

    public Formula1Driver() {
        super();

    }

    public int getNumberOfRace() {
        return numberOfRace;
    }

    public void setNumberOfRace(int numberOfRace) {
        this.numberOfRace = numberOfRace;
    }

    public int getDriverPoint() {
        return driverPoint;
    }

    public Formula1Driver(String name,int age,String location,String teamName,int [] position,int raceCount){
        super(name,location,age);
        driverCount();
        this.constructorTeam=teamName;
        this.numberOfRace= raceCount;
        this.position=position;
        totalPoint();




    }

    public String getConstructorTeam() {
        return constructorTeam;
    }

    public void setConstructorTeam(String constructorTeam) {
        this.constructorTeam = constructorTeam;
    }

    private void driverCount(){
    driverCount++;
    }



    public void setPosition(int[] position) {
        this.position = position;
        totalPoint();


    }
    public void setPosition(int position) {
        this.position[position]=this.position[position]+1;
        totalPoint();


    }
    private void totalPoint(){
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total= total+(position[i]*positionPoint[i]);
        }
        this.driverPoint=total;
    }

    @Override
    public String toString() { // use toString method ((((https://www.javatpoint.com/understanding-toString()-method))))
        return super.toString()+
                "constructorTeam='" + constructorTeam + '\'' +
                ", driverPoint=" + driverPoint +
                ", numberOfRace=" + numberOfRace +
                ", position list =" + Arrays.toString(position) ;
    }

    @Override
    public int compareTo(Formula1Driver i) {
        if (driverPoint==i.driverPoint){                           //if points are equal sort by date
         if (position[0]>i.position[0]){
             return -1;

         }else {
             return 1;
         }
        }else if (driverPoint>i.driverPoint){        //sort points  wise
            return -1;
        }else {
        return 1;}
    }
}
