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
        if (!isValidAddress(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
        if (!isValidBirthdate(birthdate)) {
            throw new IllegalArgumentException("Invalid birthdate: " + birthdate);
        }
        
        this.driverID = driverID;
        this.name = name;
        this.experienceYears = experienceYears;
        this.licenseType = licenseType;
        this.address = address;
        this.birthdate = birthdate;
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

    private boolean isValidAddress(String address) {
        String[] parts = address.split("\\|");

        if (parts.length != 5) {
            return false;
        }

        String streetNum = parts[0];
        String streetName = parts[1];
        String city = parts[2];
        String state = parts[3];
        String country = parts[4];

        if (streetNum.isEmpty()) {
            return false;
        }

        //ensuring streetNum is numeric
        for (int i = 0; i < streetNum.size(0; i++)) { 
            if (!Character.isDigit(streetNum.charAt(i))) {
                return false;
            }
        }
        //ensuring streetName, city, state and country are not empty
        if (streetName.isEmpty() || city.isEmpty() || state.isEmpty() || country.isEmpty()) {
            return false;
        }
        return true;
    }
    private boolean isValidBirthdate(String birthdate) {
        //length should be 10 - DD-MM-YYYY
        if (birthdate == null || birthdate.length() != 10) {
            return false
        }
        //dashes should be at index 2 and 5
        if (birthdate.charAt(2) != '-' ||birthdate.charAt(5) != '-') {
            return false;
        }
        for (int i = 0; i < birthdate.length(); i++) {
            if (i == 2 || i == 5) {
                continue;
            }
            else if (!Character.isDigit(birthdate.charAt(i))) {
                return false;
            }
        }

        int day = Integer.parseInt(birthdate.substring(0, 2));
        int month = Integer.parseInt(birthdate.substring(3,5));
        int year = Integer.parseInt(birthdate.substring(6, 10));

        if (day < 1 || day > 31) {  return false; }
        if (month < 1 || month > 12) {  return false; }
        if (year < 1990 || year > 2025) {   return false;}

        return true;

    }
}
