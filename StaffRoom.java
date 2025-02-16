class StaffRoom extends Room {
    private boolean restricted;

    public StaffRoom(String nameOrCode, String building, int accessLevel) {
        super(nameOrCode, building, accessLevel);
        this.restricted = true;
    }

    public void deleteRoom(){
        super.deleteRoom();
        restricted = false;
    }

    public String toString() {
        return super.toString() + ", Restricted: " + restricted;
    }
}
