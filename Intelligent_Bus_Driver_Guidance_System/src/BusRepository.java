import java.util.ArrayList;
import java.util.List;

public class BusRepository {
    //ArrayList of buses
    private List<Bus> buses = new ArrayList<>();

    public void add(Bus bus) {
        buses.add(bus);
    }

    public boolean update(String id, Bus updatedBus) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getId() == id) {
                buses.set(i, updatedBus);
                return true;
            }
        }
        return false;
    }
    public Bus retrieve(String id) {
        for (Bus bus : buses) {
            if (bus.getId() == id) {
                return bus;
            }
        }
        return null;
    }

    public int count() {
        return buses.size();
    }
}
