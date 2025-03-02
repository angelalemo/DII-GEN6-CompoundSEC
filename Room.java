import java.util.ArrayList;

abstract class Room {
    private String nameOrCode;
    private String ID;
    private AccessStrategy accessStrategy;
    private ArrayList<String> Usageinfo = new ArrayList<>();


    // Constructor
    public Room(String nameOrCode, String ID, AccessStrategy accessStrategy) {
        this.nameOrCode = nameOrCode;
        this.ID = ID;
        this.accessStrategy = accessStrategy;
    }
    public Room(String nameOrCode,AccessStrategy accessStrategy){
        this.nameOrCode = nameOrCode;
        this.ID = "";
        this.accessStrategy = accessStrategy;

    }

    public void setNameOrCode(String nameOrCode){
        this.nameOrCode = nameOrCode;
    }

    public String getNameOrCode() {
        return nameOrCode;
    }

    public AccessStrategy getAccessStrategy() {
        return accessStrategy;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAccessStrategy(AccessStrategy accessStrategy) {
        this.accessStrategy = accessStrategy;
    }

    public boolean canAccess(String role) {
        return accessStrategy.canAccess(role);
    }

    public void importUsageinfo(String input){
        Usageinfo.add(input);
    }

    public void getUsageinfo() {
        String combinedString = String.join(" ", Usageinfo);
        System.out.println( "Usageinfo: "+combinedString);
    }

    @Override
    public String toString() {
        return "Room: " + nameOrCode;
    }
}
