class StaffRoom extends Room {
    private boolean restricted;

    public StaffRoom(String nameOrCode, String building, AccessStrategy accessStrategy) {
        super(nameOrCode, building, accessStrategy);
        this.restricted = true;
    }
    

    public String toString() {
        return super.toString() + ", Restricted: " + restricted;
    }
}
