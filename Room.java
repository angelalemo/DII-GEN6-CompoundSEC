abstract class Room {
    private String nameOrCode;
    private String building;
    private int accessLevel;


    // Constructor
    public Room(String nameOrCode, String building,int accessLevel) {
        this.nameOrCode = nameOrCode;
        this.building = building;
        this.accessLevel = accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public void deleteRoom(){
        nameOrCode = null;
        building = null;
        accessLevel = Integer.parseInt(null);
    }

    public String toString() {
        return "Room: " + nameOrCode + " in " + building +
                ", Access Level: " + accessLevel;
    }}
