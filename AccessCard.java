
public interface AccessCard {
    String canAccess();
}

class Owner implements AccessCard {
    @Override
    public String canAccess() {
        String role = "owner";
        return role;}
}
class Follower implements AccessCard {
    @Override
    public String canAccess() {
        String role = "followers";
        return role;}
}
class Housekeeper implements AccessCard {
    @Override
    public String canAccess() {
        String role = "housekeeper";
        return role;}
}
class Staff implements AccessCard {
    @Override
    public String canAccess() {
        String role = "staff";
        return role;}
}
class Security implements AccessCard {
    @Override
    public String canAccess() {
        String role = "security";
        return role;}
}
class Manager implements AccessCard {
    @Override
    public String canAccess() {
        String role = "manager";
        return role;}
}

