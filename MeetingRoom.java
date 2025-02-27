import java.util.Objects;

class MeetingRoom extends Room {
    private String renterName;
    private int renterFollowers;

    public MeetingRoom(String nameOrcode, String ID, AccessStrategy accessStrategy, String renterName, int renterFollowers) {
        super(nameOrcode, ID, accessStrategy);
        this.renterName = renterName;
        this.renterFollowers = renterFollowers;
    }
    public MeetingRoom(String nameOrcode, AccessStrategy accessStrategy){
            super(nameOrcode,accessStrategy);
            this.renterName = " ";
            this.renterFollowers = 0;
        }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public void setRenterContact(int renterFollowers) {
        this.renterFollowers = renterFollowers;
    }

    public void setAccessStrategy(AccessStrategy accessStrategy) {
        super.setAccessStrategy(accessStrategy);
        if (Objects.equals(accessStrategy, new VacantRoomAccess())){
            this.renterName = "";
            this.renterFollowers = 0;
        }
    }


    public String toString() {
        return super.toString() + ", Renter Name: " + renterName + ", Follower: " + renterFollowers;
    }
}
