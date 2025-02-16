abstract class Room {
    private String nameOrcode;
    private String building;
    private int accessLevel;


    // Constructor
    public Room(String nameOrCode, String building,int accessLevel) {
        this.nameOrcode = nameOrCode;
        this.building = building;
        this.accessLevel = accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setNameOrcode(String nameOrcode) {
        this.nameOrcode = nameOrcode;
    }

    public void Deletecard(){
        nameOrcode = null;
        building = null;
        accessLevel = Integer.parseInt(null);
    }

    public String toString() {
        return "Room: " + nameOrcode + " in " + building +
                ", Access Level: " + accessLevel;
    }}
