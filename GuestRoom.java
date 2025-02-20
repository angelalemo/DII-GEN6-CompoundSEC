class GuestRoom extends Room {
    private String guestName;
    private String contactInfo;

    public GuestRoom(String nameOrCode, String building, AccessStrategy accessStrategy, String guestName, String contactInfo) {
        super(nameOrCode, building, accessStrategy);
        this.guestName = guestName;
        this.contactInfo = contactInfo;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String toString() {
        return super.toString() + ", Guest Name: " + guestName + ", Contact Info: " + contactInfo;
    }
}