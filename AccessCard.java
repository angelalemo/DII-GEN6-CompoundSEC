
public interface AccessCard {
    String canAccess();
}

class Owner implements AccessCard {
    @Override
    public String canAccess() {
        String role = "owner";
        return role;}
}
class Tenant implements AccessCard {
    @Override
    public String canAccess() {
        String role = "tenant";
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
class Chef implements AccessCard {
    @Override
    public String canAccess() {
        String role = "chef";
        return role;}
}
