abstract class Card {
    private String username;
    private String id;
    private int accessLevel;


    public Card(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void deleteCard(){
        username = null;
        id = null;
        accessLevel = Integer.parseInt(null);
    }

    public String getCardDetails() {
        return "Customer Card - Username: " + username +
                ", ID: " + id +
                ", Access Level: " + accessLevel;
    }
}
