abstract class Card {
    private String username;
    private String number;
    private AccessCard accessCard;


    public Card(String username, String number, AccessCard accessCard) {
        this.username = username;
        this.number = number;
        this.accessCard = accessCard;
    }
    public Card(){
        this.username = "";
        this.number = "";
        this.accessCard = new Staff();
    }


    public String canAccess() {
        return accessCard.canAccess();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNumber(String Number) {
        this.number = Number;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public String getnumber() {
        return number;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public String getDetails() {
        return "Card Holder: " + username + ", ID: " + number;
    }


    public void deleteCard(){
        username = null;
        number = null;
        accessCard = null;
    }

}
