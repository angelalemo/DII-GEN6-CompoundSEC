
public interface AccessCard {
    boolean canAccess(String role);
}

class Owner implements AccessCard {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("staff");
    }
}