class CustomerCard extends Card {
    private String roomOrHall;


    public CustomerCard(String username, String id, String roomOrHall, AccessCard accessCard) {
        super(username, id, accessCard);
        this.roomOrHall = roomOrHall;
    }

    public CustomerCard(){
        super();
        this.roomOrHall = "";
    }


    public void setRoomOrHall(String roomOrHall) {
        this.roomOrHall = roomOrHall;
    }

    public void deleteCard(){
        super.deleteCard();
        roomOrHall = null;
    }
    public String getCardDetails() {
        return super.toString() + ", Room/Hall: " + roomOrHall;
    }
}

