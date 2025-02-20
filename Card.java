abstract class Card {
    private String username;
    private String id;
    private AccessCard accessCard;

    public Card(String username, String id, AccessCard accessStrategy) {
        this.username = username;
        this.id = id;
        this.accessCard = accessStrategy;
    }

    public boolean canAccess(String area) {
        return accessCard.canAccess(area);
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
