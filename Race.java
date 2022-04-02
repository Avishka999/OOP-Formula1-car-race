import java.io.Serializable;
import java.time.LocalDate;


public class Race implements Serializable {
    LocalDate localDate;
    String teamName;
    int position;

    public Race(int year,int month,int day,String teamName,int  position) {
       this.localDate = LocalDate.of(year,month,day);
       this.position=position;
       this.teamName=teamName;



    }


}
