class EmployeeCard extends Card {
    private String role;

    // Constructor
    public EmployeeCard(String username, String id, String role, AccessCard accessCard) {
        super(username, id, accessCard);
        this.role = role;
    }

    public EmployeeCard(){
        super();
        this.role = "";
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void deleteCard(){
        super.deleteCard();
        role = null;
    }

    public String getCardDetails() {
        return super.toString() + ", Role: " + role;
    }
}