class CustomerCard extends Card {
    private String roomOrHall;


    public CustomerCard(String username, String id, String roomOrHall) {
        int accessLevel = 2;
        super(username, id);
        this.roomOrHall = roomOrHall;
    }

    public String getRoomOrHall() {
        return roomOrHall;
    }

    public void setRoomOrHall(String roomOrHall) {
        this.roomOrHall = roomOrHall;
    }

    @Override
    public String getCardDetails() {
        return "Customer Card - Username: " + getUsername() +
                ", ID: " + getId() +
                ", Access Level: " + getAccessLevel() +
                ", Room/Hall: " + roomOrHall;
    }
}

