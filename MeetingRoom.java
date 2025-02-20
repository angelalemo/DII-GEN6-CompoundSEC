class MeetingRoom extends Room {
    private String renterName;
    private String renterContact;

    public MeetingRoom(String nameOrCode, String building, AccessStrategy accessStrategy, String renterName, String renterContact) {
        super(nameOrCode, building, accessStrategy);
        this.renterName = renterName;
        this.renterContact = renterContact;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public void setRenterContact(String renterContact) {
        this.renterContact = renterContact;
    }


    public String toString() {
        return super.toString() + ", Renter Name: " + renterName + ", Renter Contact: " + renterContact;
    }
}
