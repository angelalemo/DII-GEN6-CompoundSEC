abstract class Card {
    private String username;
    private String id;
    private String accessLevel;

    // Constructor
    public Card(String username, String id, String accessLevel) {
        this.username = username;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    // Getters and Setters
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

    // Abstract method to display card details
    public abstract String getCardDetails();
}
