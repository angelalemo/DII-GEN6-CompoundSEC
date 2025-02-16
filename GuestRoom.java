class GuestRoom extends Room {
    private String guestName;
    private String contactInfo;

    public GuestRoom(String nameOrCode, String building, int accessLevel, String guestName, String contactInfo) {
        super(nameOrCode, building, accessLevel);
        this.guestName = guestName;
        this.contactInfo = contactInfo;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String toString() {
        return super.toString() + ", Guest Name: " + guestName + ", Contact Info: " + contactInfo;
    }
}