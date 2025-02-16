class CustomerCard extends Card {
    private String roomOrHall;


    public CustomerCard(String username, String id, String roomOrHall) {
        int accessLevel = 2;
        super(username, id);
        this.roomOrHall = roomOrHall;
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

