abstract class Room {
    private String nameOrCode;
    private String building;
    private String accessibleTime;
    private String accessLevel;

    // Constructor
    public Room(String nameOrCode, String building, String accessibleTime, String accessLevel) {
        this.nameOrCode = nameOrCode;
        this.building = building;
        this.accessibleTime = accessibleTime;
        this.accessLevel = accessLevel;
    }

    // Getters and Setters
    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAccessibleTime() {
        return accessibleTime;
    }

    public void setAccessibleTime(String accessibleTime) {
        this.accessibleTime = accessibleTime;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String toString() {
        return "Room: " + nameOrCode + " in " + building +
                ", Accessible Time: " + accessibleTime +
                ", Access Level: " + accessLevel;
    }
}