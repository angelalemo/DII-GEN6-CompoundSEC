class StaffRoom extends Room {
    private boolean restricted;

    public StaffRoom(String nameOrCode, String ID, AccessStrategy accessStrategy) {
        super(nameOrCode, ID, accessStrategy);
        this.restricted = true;
    }
    

    public String toString() {
        return super.toString() + ", Restricted: " + restricted;
    }
}
