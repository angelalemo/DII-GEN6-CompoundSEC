class EmployeeCard extends Card {
    private String role;

    // Constructor
    public EmployeeCard(String username, String id, String accessLevel, String role) {
        super(username, id, accessLevel);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getCardDetails() {
        return "Employee Card - Username: " + getUsername() +
                ", ID: " + getId() +
                ", Access Level: " + getAccessLevel() +
                ", Role: " + role;
    }
}
