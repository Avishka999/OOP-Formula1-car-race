import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String driverName;
    private String driverLocation;
    private int age;
    private String id;

    public Driver() {

    }

    public Driver(String driverName, String driverLocation, int age) {   // (constructor)
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "driverName='" + driverName + '\'' +
                        ", driverLocation='" + driverLocation + '\'' +
                        ", age=" + age;
    }


    public String getDriverLocation() { // get Diver Location
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) { // use setters and set Diver Location
        this.driverLocation = driverLocation;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setId(String id) {
        this.id = id;


    }
}