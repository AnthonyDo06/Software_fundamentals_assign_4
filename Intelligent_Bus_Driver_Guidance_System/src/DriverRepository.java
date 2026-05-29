import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    //ArrayList of drivers
    private List<Driver> drivers = new ArrayList<>();

    public void add(Driver driver) {
        drivers.add(driver);
    }


    //discuss with group and decide if experience years to be updated before applying D4 or after
    public boolean update(String id, Driver updatedDriver) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).driverId.equals(id)) {
                if(!updatedDriver.name.equals(drivers.get(i).name)) {
                    throw new IllegalArgumentException("Name cannot be modified");
                }
                drivers.get(i).experienceYears = updatedDriver.experienceYears;
                if (drivers.get(i).experienceYears <= 10) {
                    drivers.get(i).licenseType = updatedDriver.licenseType;
                }
                drivers.get(i).address = updatedDriver.address;
                drivers.get(i).birthdate = updatedDriver.birthdate;
                return true;
            }
        }
        return false;
    }


    public Driver retrieve(int id) {
        for (Driver driver : drivers) {
            if (driver.driverId == id) {
                return driver;
            }
        }
        return null;
    }

    
    public int count() {
        return drivers.size();
    }


}
