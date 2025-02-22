public interface AccessStrategy {
    boolean canAccess(String role);
}

// Concrete Strategy for Vacant Room
class VacantRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("housekeeper") ||
                role.equalsIgnoreCase("security") ||
                role.equalsIgnoreCase("manager");
    }
}

// Concrete Strategy for Reserved Room
class ReservedRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("owner") ||
                role.equalsIgnoreCase("housekeeper") ||
                role.equalsIgnoreCase("security") ||
                role.equalsIgnoreCase("manager");
    }
}

// Concrete Strategy for Rented Place
class RentedPlaceAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("owner") ||
                role.equalsIgnoreCase("tenant") ||
                role.equalsIgnoreCase("staff")||
                role.equalsIgnoreCase("security") ||
                role.equalsIgnoreCase("manager");
    }
}

// Concrete Strategy for Damaged Room
class StaffRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("staff")||
                role.equalsIgnoreCase("housekeeper") ||
                role.equalsIgnoreCase("security") ||
                role.equalsIgnoreCase("manager");
    }
}
class ChefRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("staff")||
                role.equalsIgnoreCase("housekeeper") ||
                role.equalsIgnoreCase("security") ||
                role.equalsIgnoreCase("chef") ||
                role.equalsIgnoreCase("manager");
    }
}
class SecurityRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("security") ||
                role.equalsIgnoreCase("manager");
    }
}
class ManagerRoomAccess implements AccessStrategy {
    @Override
    public boolean canAccess(String role) {
        return role.equalsIgnoreCase("manager");
    }
}
