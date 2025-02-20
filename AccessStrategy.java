public interface AccessStrategy {
    boolean canAccess(String role);
}

// Concrete Strategy for Vacant Room
class VacantRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("staff");
    }
}

// Concrete Strategy for Reserved Room
class ReservedRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("owner") || role.equalsIgnoreCase("staff");
    }
}

// Concrete Strategy for Rented Place
class RentedPlaceAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("owner") ||
                role.equalsIgnoreCase("tenant") ||
                role.equalsIgnoreCase("staff");
    }
}

// Concrete Strategy for Damaged Room
class LevelRoomAccess implements AccessStrategy {
    private int Level;

    public LevelRoomAccess(int requiredAccessLevel) {
        this.Level = requiredAccessLevel;
    }

    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("staff");
    }
}
