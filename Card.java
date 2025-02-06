abstract class Card {
    private String username;
    private String id;
    private int accessLevel;
    private static int coust;


    public Card(String username, String id, int accessLevel) {
        this.username = username;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public abstract String getCardDetails();

    static class CustomerCard extends Card {
        private String roomOrHall;


        public CustomerCard(String username, String id, String roomOrHall) {
            int accessLevel = 2;
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

    static class EmployeeCard extends Card {
        private String role;

        // Constructor
        public EmployeeCard(String username, String id, String accessLevel, String role) {
            super(username, id, accessLevel);
            this.role = role;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String getCardDetails() {
            return "Employee Card - Username: " + getUsername() +
                    ", ID: " + getId() +
                    ", Access Level: " + getAccessLevel() +
                    ", Role: " + role;
        }
    }
}
