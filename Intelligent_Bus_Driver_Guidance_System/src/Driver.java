public class Driver {
    
    private String driverID;
    private String name;
    private int experienceYears;
    private String licenseType;
    private String address;
    private String birthdate;

    // Constructor for driver
    public Driver(String driverID, String name, int experienceYears, String licenseType, String address, String birthdate) {
        if(!isValidDriverId(driverID)) {
            throw new IllegalArgumentException("Invalid driver Id: " + driverId);
        }
        this.driverID = driverID;
        this.name = name;
        this.experienceYears = experienceYears;
        this.licenseType = licenseType;
        this.address = address;
        this.birthdate = birthdate;
    }
    public String getId() {
        return driverID;
    }

    private boolean isValidDriverId(String id) {

        //checking driver id length (10 characters)
        if (id == null || id.length() != 10) {
            return false;
        }
        //checking first 2 characters are digits 2-9
        char c1 = id.charAt(0);
        char c2 = id.charAt(1);
        if (!Character.isDigit(c1) || c1 < '2' || c1 > '9' ||
            !Character.isDigit(c2) || c2 < '2' || c2 > '9') {
            return false;
        }
        //checking for 2 special characters between positions 3 and 8
        String middle = id.substring(2, 8);
        int specCharCount = 0;
        for (int i = 0; i < 6; i++) {
            char ch = middle.charAt(i);
            if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) {
                specCharCount++;
            }
        }
        if (specCharCount < 2) {
            return false;
        }
        
        //check last 2 characters uppercase letters
        char c3 = id.charAt(8);
        char c4 = id.charAt(9);
        if (!Character.isUpperCase(c3) || !Character.isUpperCase(c4)) {
            return false;
        }
        
        //returning true since no rules broken
        return true;
    }
}
