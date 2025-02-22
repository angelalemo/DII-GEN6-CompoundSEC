import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {
        Room vacantRoom = new GuestRoom("101", "Building A", new VacantRoomAccess(), "Mark","0843677079");
        System.out.println(vacantRoom.toString());
    }
}
