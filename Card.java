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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public abstract String getCardDetails();

}
