abstract class Card {
    private String username;
    private String id;
    private AccessCard accessCard;

    public Card(String username, String id, AccessCard accessCard) {
        this.username = username;
        this.id = id;
        this.accessCard = accessCard;
    }

    public String canAccess() {
        return accessCard.canAccess();
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
