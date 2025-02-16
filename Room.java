abstract class Room {
    private String nameOrcode;
    private String building;
    private String accessLevel;


    // Constructor
    public Room(String nameOrCode, String building,String accessLevel) {
        this.nameOrcode = nameOrCode;
        this.building = building;
        this.accessLevel = accessLevel;
    }

    public String toString() {
        return "Room: " + nameOrcode + " in " + building +
                ", Access Level: " + accessLevel;
    }}
