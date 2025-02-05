class StaffRoom extends Room {
    private boolean restricted;

    public StaffRoom(String nameOrCode, String building, String accessibleTime,
                     String accessLevel, boolean restricted) {
        super(nameOrCode, building, accessibleTime, accessLevel);
        this.restricted = restricted;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public String toString() {
        return super.toString() + ", Restricted: " + restricted;
    }
}
