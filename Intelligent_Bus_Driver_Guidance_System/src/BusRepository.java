import java.util.ArrayList;
import java.util.List;

public class BusRepository {
    //ArrayList of buses
    private List<Bus> buses = new ArrayList<>();

    public boolean add(Bus bus) {
        for (Bus b : buses) {
            if (b.getBusId().equals(bus.getBusId())) {
                throw new IllegelArgumentException("busId already exists: " + bus.getBusId());
            }
        }
        buses.add(bus);
        return true;
    }

    public boolean update(String id, Bus updatedBus) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).busID.equals(id)) {
                buses.set(i, updatedBus);
                return true;
            }
        }
        return false;
    }
    public Bus retrieve(String id) {
        for (Bus bus : buses) {
            if (bus.busID == id) {
                return bus;
            }
        }
        return null;
    }

    public int count() {
        return buses.size();
    }
}
