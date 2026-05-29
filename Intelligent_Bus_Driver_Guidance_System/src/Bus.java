public class Bus {

    private String busID;
    private int capacity;
    private double fuelLevel;
    private String fuelType;

    public Bus(String busID, int capacity, double fuelLevel, String fuelType) {
        if (!isValidBusId(busID)) {
            throw new IllegalArgumentException("Invalid busId: " + busId);
        }
        this.busID = busID;
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
        this.fuelType = fuelType;
    }

    private boolean isValidBusId(String busId) {

        if(busId == null || busId.length() != 8) {
            return false;
        }

        for (int i = 0; i < busId.length(); i++) {
            if (!Character.isDigit(busId.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
