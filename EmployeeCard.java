class EmployeeCard extends Card {
    private String role;

    // Constructor
    public EmployeeCard(String username, String id, String role) {
        int accessLevel = 3;
        super(username, id);
        this.role = role;
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