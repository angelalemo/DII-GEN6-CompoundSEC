class GuestRoom extends Room {
    private String guestName;
    private String contactInfo;

    public GuestRoom(String nameOrCode, String building, int accessLevel, String guestName, String contactInfo) {
        super(nameOrCode, building, accessLevel);
        this.guestName = guestName;
        this.contactInfo = contactInfo;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void deleteRoom(){
        super.deleteRoom();
        guestName = null;
        contactInfo = null;
    }

    public String toString() {
        return super.toString() + ", Guest Name: " + guestName + ", Contact Info: " + contactInfo;
    }
}