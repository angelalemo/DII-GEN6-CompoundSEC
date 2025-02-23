abstract class Room {
    private String nameOrCode;
    private String building;
    private AccessStrategy accessStrategy;

    // Constructor
    public Room(String nameOrCode, String building, AccessStrategy accessStrategy) {
        this.nameOrCode = nameOrCode;
        this.building = building;
        this.accessStrategy = accessStrategy;
    }


    // Setters and Getters
    public void setAccessStrategy(AccessStrategy accessStrategy) {
        this.accessStrategy = accessStrategy;
    }

    public boolean canAccess(String role) {
        return accessStrategy.canAccess(role);
    }

    @Override
    public String toString() {
        return "Room: " + nameOrCode + " in " + building;
    }
}
