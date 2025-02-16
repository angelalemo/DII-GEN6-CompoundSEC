abstract class Card {
    private String username;
    private String id;
    private int accessLevel;


    public Card(String username, String id) {
        this.username = username;
        this.id = id;
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

    public void Deletecard(){
        username = null;
        id = null;
        accessLevel = Integer.parseInt(null);
    }

    public abstract String getCardDetails();

}
