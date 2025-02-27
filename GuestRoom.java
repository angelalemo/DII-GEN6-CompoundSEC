import java.util.Objects;

class GuestRoom extends Room {
    private String guestName;


    public GuestRoom(String nameOrCode, String ID, AccessStrategy accessStrategy, String guestName) {
        super(nameOrCode, ID, accessStrategy);
        this.guestName = guestName;

    }
    public GuestRoom(String nameOrCode, AccessStrategy accessStrategy){
        super(nameOrCode,accessStrategy);
        setNameOrCode(nameOrCode);
        this.guestName = " ";
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public void setAccessStrategy(AccessStrategy accessStrategy) {
        super.setAccessStrategy(accessStrategy);
        if (Objects.equals(accessStrategy, new VacantRoomAccess())){
            this.guestName = "";
        }
    }

    public String toString() {
        return super.toString() + ", Guest Name: " + guestName;
    }
}