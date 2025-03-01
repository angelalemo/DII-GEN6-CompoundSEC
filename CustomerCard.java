import java.time.LocalDateTime;
import java.util.Base64;

class CustomerCard extends Card {
    private String roomOrHall;
    LocalDateTime now = LocalDateTime.now();
    private String ID ;


    public CustomerCard(String username, String number, String roomOrHall, AccessCard accessCard) {
        super(username, number, accessCard);
        this.roomOrHall = roomOrHall;
        this.ID = "1";
    }
    public CustomerCard(String username, String number, String roomOrHall, AccessCard accessCard,String ID) {
        super(username, number, accessCard);
        this.roomOrHall = roomOrHall;
        this.ID = ID;
        encryptID();
    }

    public CustomerCard(){
        super();
        this.roomOrHall = "";
        this.ID = "";
        encryptID();
    }

    public void setID(String id) {
        this.ID = id;
        encryptID();
    }

    public String getID(){
        return ID;
    }

    public String getdecryptID(){
        decryptID();
        return ID;
    }

    public void setRoomOrHall(String roomOrHall) {
        this.roomOrHall = roomOrHall;
    }

    public void deleteCard(){
        super.deleteCard();
        roomOrHall = null;
        ID = null;
    }
    public String getCardDetails() {
        return super.toString() + ", Room/Hall: " + roomOrHall;
    }

    public void encryptID() {
        if (ID != null) {
            String encryptedID = Base64.getEncoder().encodeToString((ID + now.toString()).getBytes());
            this.ID = encryptedID;
        }
    }

    public void decryptID() {
        if (ID != null) {
                String decryptedData = new String(Base64.getDecoder().decode(ID));
                // Remove the timestamp from the decrypted data
                this.ID = decryptedData.substring(0, decryptedData.length() - now.toString().length());
            } else {
                System.out.println("Invalid encrypted data");
            }
        }

    public void encryptID(String x) {
        if (ID != null) {
            String encryptedID = Base64.getEncoder().encodeToString((x + now.toString()).getBytes());
            this.ID = encryptedID;
        }
    }
}

