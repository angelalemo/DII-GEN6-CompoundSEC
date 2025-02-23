abstract class Card {
    private String username;
    private String id;
    private AccessCard accessCard;

    public Card(String username, String id, AccessCard accessCard) {
        this.username = username;
        this.id = id;
        this.accessCard = accessCard;
    }
    public Card(){
        this.username = "";
        this.id = "";
    }


    public String canAccess() {
        return accessCard.canAccess();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public String getId() {
        return id;
    }

    public String getDetails() {
        return "Card Holder: " + username + ", ID: " + id;
    }


    public void deleteCard(){
        username = null;
        id = null;
        accessCard = null;
    }
    
}
