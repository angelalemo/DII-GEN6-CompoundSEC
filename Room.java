abstract class Room {
    private String nameOrcode;
    private String building;
    private String accessibleTime;
    private String accessLevel;


    // Constructor
    public Room(String nameOrCode, String building, String accessibleTime, String accessLevel) {
        this.nameOrcode = nameOrCode;
        this.building = building;
        this.accessibleTime = accessibleTime;
        this.accessLevel = accessLevel;
    }

    public String toString() {
        return "Room: " + nameOrcode + " in " + building +
                ", Accessible Time: " + accessibleTime +
                ", Access Level: " + accessLevel;
    }}
