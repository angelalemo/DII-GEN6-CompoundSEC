class MeetingRoom extends Room {
    private String renterName;
    private String renterContact;

    public MeetingRoom(String nameOrCode, String building, int accessLevel, String renterName, String renterContact) {
        super(nameOrCode, building, accessLevel);
        this.renterName = renterName;
        this.renterContact = renterContact;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getRenterContact() {
        return renterContact;
    }

    public void setRenterContact(String renterContact) {
        this.renterContact = renterContact;
    }

    public String toString() {
        return super.toString() + ", Renter Name: " + renterName + ", Renter Contact: " + renterContact;
    }
}
