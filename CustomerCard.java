class CustomerCard extends Card {
    private String roomOrHall;

    // Constructor
    public CustomerCard(String username, String id, String accessLevel, String roomOrHall) {
        super(username, id, accessLevel);
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
