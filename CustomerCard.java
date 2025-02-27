import java.time.LocalDateTime;

class CustomerCard extends Card {
    private String roomOrHall;
    LocalDateTime now = LocalDateTime.now();
    private String ID ;

    public CustomerCard(String username, String number, String roomOrHall, AccessCard accessCard) {
        super(username, number, accessCard);
        this.roomOrHall = roomOrHall;
    }
    public CustomerCard(String username, String number, String roomOrHall, AccessCard accessCard,String ID) {
        super(username, number, accessCard);
        this.roomOrHall = roomOrHall;
        this.ID = ID;
    }

    public CustomerCard(){
        super();
        this.roomOrHall = "";
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getID(){
        return ID;
    }

    public void setRoomOrHall(String roomOrHall) {
        this.roomOrHall = roomOrHall;
    }

    public void deleteCard(){
        super.deleteCard();
        roomOrHall = null;
        ID = null;
    }
    public String getCardDetails() {
        return super.toString() + ", Room/Hall: " + roomOrHall;
    }
}

