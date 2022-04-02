import java.io.IOException;

public interface ChampionshipManager {


    void  newDriver(String name, int age, String location, String teamName, int[] position, int raceCount);//newDriver method
    void driverDelete(String teamname);                                                                   //driverDelete method
    void driverChange(String team, int age, String name, String location, int[] position, int rCount);   //driverChange method
    boolean validation(String name, String teamname);                                                   //validation method
    boolean deletevalidation(String teamname);                                                         //deleteValidation method
    void save();                                                                                      //save


}
