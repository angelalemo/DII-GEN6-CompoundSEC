abstract class Room {
    private String nameOrCode;
    private String building;
    private String accessibleTime;
    private String accessLevel;
    private int coust;

    // Constructor
    public Room(String nameOrCode, String building, String accessibleTime, String accessLevel) {
        this.nameOrCode = nameOrCode;
        this.building = building;
        this.accessibleTime = accessibleTime;
        this.accessLevel = accessLevel;
    }

    // Getters and Setters
    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAccessibleTime() {
        return accessibleTime;
    }

    public void setAccessibleTime(String accessibleTime) {
        this.accessibleTime = accessibleTime;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String toString() {
        return "Room: " + nameOrCode + " in " + building +
                ", Accessible Time: " + accessibleTime +
                ", Access Level: " + accessLevel;
    }

    static class GuestRoom extends Room {
        private String guestName;
        private String contactInfo;

        public GuestRoom(String nameOrCode, String building, String accessibleTime, String accessLevel, String guestName, String contactInfo) {
            super(nameOrCode, building, accessibleTime, accessLevel);
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

    static class StaffRoom extends Room {
        private boolean restricted;

        public StaffRoom(String nameOrCode, String building, String accessibleTime, String accessLevel, boolean restricted) {
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

    static class MeetingRoom extends Room {
        private String renterName;
        private String renterContact;

        public MeetingRoom(String nameOrCode, String building, String accessibleTime, String accessLevel, String renterName, String renterContact) {
            super(nameOrCode, building, accessibleTime, accessLevel);
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
}