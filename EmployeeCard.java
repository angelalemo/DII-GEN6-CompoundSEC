import java.time.LocalDateTime;

class EmployeeCard extends Card {
    private String role;
    LocalDateTime now = LocalDateTime.now();

    // Constructor
    public EmployeeCard(String username, String number, String role, AccessCard accessCard) {
        super(username, number, accessCard);
        this.role = role;
    }

    public EmployeeCard(){
        super();
        this.role = "";
    }

    @Override
    public String getnumber() {
        return super.getnumber();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void deleteCard(){
        super.deleteCard();
        role = null;
    }

    public void getCardDetails() {
        super.getCardDetails();
        System.out.println("Role: "+role);
    }
}