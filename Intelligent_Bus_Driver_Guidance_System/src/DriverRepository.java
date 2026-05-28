import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    //ArrayList of drivers
    private List<Driver> drivers = new ArrayList<>();



    public void add(Driver driver) {
        drivers.add(driver);
    }

    public boolean update(String id, Driver updatedDriver) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId() == id) {
                drivers.set(i, updatedDriver);
                return true;
            }
        }
        return false;
    }

    public Driver retrieve(int id) {
        for (Driver driver : drivers) {
            if (driver.getId() == id) {
                return driver;
            }
        }
        return null;
    }

    public int count() {
        return drivers.size();
    }


}
