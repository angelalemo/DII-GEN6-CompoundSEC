abstract class Room {
    private String nameOrCode;
    private String ID;
    private AccessStrategy accessStrategy;

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

    public void setAccessStrategy(AccessStrategy accessStrategy) {
        this.accessStrategy = accessStrategy;
    }

    public boolean canAccess(String role) {
        return accessStrategy.canAccess(role);
    }

    @Override
    public String toString() {
        return "Room: " + nameOrCode;
    }
}
