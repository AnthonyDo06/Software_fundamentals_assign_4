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
                if (buses.get(i).capacity < updatedBus.capacity) {
                    throw new IllegalArgumentException("Capacity cannot be increased");
                }
                else {
                    buses.get(i).capacity = updatedBus.capacity;
                }
                buses.get(i).fuelLevel = updatedBus.fuelLevel;
                buses.get(i).fuelType = updatedBus.fuelType;
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
