
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDateTime;


public class main {
    static CustomerCard[][] Guest = new CustomerCard[5][20];
    static CustomerCard[] Tenet = new CustomerCard[10];
    static CustomerCard[][] Follower = new CustomerCard[10][200];
    static Room [][] Guestroom = new GuestRoom [5][20];
    static Room [] meetingroom = new MeetingRoom [10];
    static Room NotfoundRoom = new StaffRoom("Notfound","Notfound",new StaffRoomAccess());
    static LocalDateTime now = LocalDateTime.now();

    static Card findslotcard (int x,int y){
        if(x == 1){for (int i = 0 ; i< 5 ;i++){
            for (int j = 0; j< 20;j++){
                if(!Objects.equals(Guest[i][j].getAccessCard(), new Owner())){
                    return  Guest[i][j];
                }}}
        }else if (x == 2)
            for (int j = 0; j< 10;j++){
                if(!Objects.equals(Tenet[j].getAccessCard(), new Owner())){
                    return  Tenet[j];}
            }else if (x == 3){
            for (int i = 0 ; i< 10 ;i++){
                for (int j = 0; j< 200;j++){
                    if(!Objects.equals(Follower[y-1][j].getAccessCard(), new Follower())){
                        return  Follower[y-1][j];
                    }}}}
        return NotfoundCard;
    }

    static void customer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        String name = input.nextLine();
        System.out.println("=============================================================================================================");
        String RoomorHall = "";
        Boolean owner = null;
        while (true) {
            System.out.println("1.Room");
            System.out.println("2.MeetingRoom");
            System.out.println("=============================================================================================================");
            System.out.print("Room Type: ");
            int roh = input.nextInt();
            if (roh == 1) {
                RoomorHall = "room";
                break;
            } else if (roh == 2) {
                RoomorHall = "meetingroom";
                while (true) {
                    System.out.println("1.Owner");
                    System.out.println("2.Follower");
                    System.out.println("=============================================================================================================");
                    int OoF = input.nextInt();
                    if (OoF == 1) {
                        owner = true;
                        break;
                    } else if (OoF == 2) {
                        owner = false;
                        break;
                    }
                }
                break;
            } else {
                System.out.println("The input is invalid.");
            }
        }
        Scanner get = new Scanner(System.in);
        Scanner get1 = new Scanner(System.in);
        String number;
        while (true) {
            System.out.print("Room number: ");
            number = get.nextLine();
            if(number.length() < 4){
                break;
            }
        }
        if (RoomorHall.equals("room")) {
            String fl = number.substring(0, 1);
            int floor = Integer.parseInt(fl);
            int room = 0;
            if (number.length() == 2){String ro = number.substring(1, 2);
                room = Integer.parseInt(ro);
            } else if (number.length() == 3) {String ro = number.substring(1, 3);
                room = Integer.parseInt(ro);
            }
            System.out.print("Your ID: ");
            String ID = get1.nextLine();
            String roomnumber = "GR"+number;
            Guest[floor-1][room-1] =new CustomerCard(name,roomnumber , RoomorHall, new Owner(),ID);
            Guestroom[floor-1][room-1] = new GuestRoom(roomnumber,ID,new ReservedRoomAccess(),name);
        } else {
            if (owner) {
                int room = Integer.parseInt(number);
                System.out.print("Your ID: ");
                String ID = get.nextLine();
                String roomnumber = "MR"+number;
                Tenet[room-1] = new CustomerCard(name,roomnumber , RoomorHall, new Owner(),ID);
                System.out.println();
                System.out.print("Number of followers : ");
                int numfollower = get.nextInt();
                meetingroom[room-1] = new MeetingRoom(roomnumber ,ID ,new RentedPlaceAccess() ,name ,numfollower);
                for (int i =0 ; i<200;i++){
                    Follower[room-1][i].setID(ID);
                }
            } else {
                int room = Integer.parseInt(number);
                Card slotcard = findslotcard(3,room);
                slotcard = new CustomerCard(name, number , RoomorHall, new Follower());
            }
        }
    }

    static int[][] numID = new int[4][3];
    static int Employeenum = 0;

    static String GenID(int n) {
        Employeenum = ((numID[n - 1][0]) * 100) + ((numID[n - 1][1]) * 10) + (numID[n - 1][2]);
        String x = String.valueOf(numID[n - 1][0]) + String.valueOf(numID[n - 1][1]) + String.valueOf(numID[n - 1][2]);

        numID[n - 1][2]++;
        for (int i = 2; i >= 1; i--) {
            if (numID[n - 1][i] == 10) {
                numID[n - 1][i - 1]--;
                numID[n - 1][i] = 0;
            }
        }
        return x;
    }

    static Card[][] Employeelist = new EmployeeCard[4][1000];

    static void employee() {
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        String name = input.nextLine();
        System.out.println("=============================================================================================================");
        String role = "";
        String ID = "";
        int roh = 0;
        while (true) {
            System.out.println("1.Staff");
            System.out.println("2.Housekeeper");
            System.out.println("3.Security");
            System.out.println("4.Manager");
            System.out.println("=============================================================================================================");
            System.out.print("Work Type: ");
            roh = input.nextInt();
            if ((roh == 1) || (roh == 2) || (roh == 3) || (roh == 4)) {
                break;
            } else {
                System.out.println("The input is invalid.");
            }
        }
        switch (roh) {
            case 1:
                System.out.print("Role name: ");
                role = input.nextLine();
                input.nextLine();
                ID = "ST" + GenID(roh);
                Employeelist[roh-1][Employeenum] = new EmployeeCard(name, ID, role, new Staff());
                break;
            case 2:
                System.out.print("Role name: ");
                role = input.nextLine();
                input.nextLine();
                ID = "HO" + GenID(roh);
                Employeelist[roh-1][Employeenum] = new EmployeeCard(name, ID, role, new Housekeeper());
                break;
            case 3:
                System.out.print("Role name: ");
                role = input.nextLine();
                input.nextLine();
                ID = "SE" + GenID(roh);
                Employeelist[roh-1][Employeenum] = new EmployeeCard(name, ID, role, new Security());
                break;
            case 4:
                System.out.print("Role name: ");
                role = input.nextLine();
                input.nextLine();
                ID = "MA" + GenID(roh);
                Employeelist[roh-1][Employeenum] = new EmployeeCard(name, ID, role, new Manager());
                break;

        }
    }

    static void addCard() {
        for (int i = 0; i < 4; i++) {
            numID[i][2] = 1;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Customer Card");
        System.out.println("2.Employee Card");
        System.out.println("3.Return to Card Management");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1) {
            customer();
        } else if (menu == 2) {
            employee();
        } else if (menu == 3) {
            cardmenu();
        }
    }

    static Card NotfoundCard = new EmployeeCard("Notfound", "Notfound", "Notfound", new Staff());

    static Card checkCard(String x) {
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j <20;j++ ){
            if (Objects.equals(x, Guest[i][j].getdecryptID())) {
                Guest[i][j].encryptID();
                return Guest[i][j];
            }}
        }
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(x, Tenet[i].getdecryptID())) {
                Tenet[i].encryptID();
                return Tenet[i];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 200; j++) {
                if (Objects.equals(x, Follower[i][j].getdecryptID())) {
                    Follower[i][j].encryptID();
                    return Follower[i][j];
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1000; j++) {
                if (Objects.equals(x, Employeelist[i][j].getnumber())) {
                    return Employeelist[i][j];
                }
            }
        }
        return NotfoundCard;
    }

    static boolean customeroremployee(String x) {
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j <20;j++ ){
                if (Objects.equals(x, Guest[i][j].getnumber())) {
                    return true;
                }}
        }
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(x, Tenet[i].getnumber())) {
                return true;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 200; j++) {
                if (Objects.equals(x, Follower[i][j].getnumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    static void modcustomer(CustomerCard x) {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to modify?");
        System.out.println("1.Modify Username");
        System.out.println("2.Modify Room Number");
        System.out.println("3.New ID");
        System.out.println("4.Modify Access");
        System.out.println("5.Delete Card");
        System.out.println("=============================================================================================================");
        int mod = input.nextInt();
        String change;
        String card = x.getnumber();
        switch (mod) {
            case 1:
                System.out.print("New Username: ");
                change = input.nextLine();
                x.setUsername(change);

                System.out.println("Modify Username complete");
                break;
            case 2:
                while (true) {
                    System.out.println("1.Room");
                    System.out.println("2.Meeting Room");
                    System.out.println("=============================================================================================================");
                    int rom = input.nextInt();
                    System.out.print("New Room Number");
                    String num = input.nextLine();
                    if (rom == 1) {
                        x.setRoomOrHall("room");
                        x.setNumber(STR."GR\{num}");
                        x.setAccessCard(new Owner());
                        System.out.println("Modify Room Number complete");
                        break;
                    } else if (rom == 2) {
                        x.setRoomOrHall("meeting room");
                        while (true) {
                            System.out.println("1.Owner");
                            System.out.println("2.Follower");
                            int oof = input.nextInt();
                            if (oof == 1) {
                                x.setNumber(STR."MR\{num}");
                                x.setAccessCard(new Owner());
                                System.out.println("Modify Room Number complete");
                                break;
                            } else if (oof == 2) {
                                x.setNumber(STR."MR\{num}");
                                x.setAccessCard(new Follower());
                                System.out.println("Modify Room Number complete");
                                break;
                            }
                        }
                    }
                    break;
                }
                break;
            case 3:
                System.out.print("New ID: ");
                change = input.nextLine();
                x.setID(change);
                System.out.println("New ID complete");
                break;
            case 4:
                System.out.print("Are you sure you want to delete this card?(Yes/yes to delete)");
                String delete = input.nextLine();
                if (Objects.equals(delete, "yes") || Objects.equals(delete, "Yes")) {
                    x.deleteCard();
                    System.out.println("Modify Delete Card complete");
                }
                break;
        }
    }

    static void modemployee(EmployeeCard x) {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to modify?");
        System.out.println("1.Modify Username");
        System.out.println("2.Modify Role");
        System.out.println("3.Delete Card");
        System.out.println("=============================================================================================================");
        int mod = input.nextInt();
        String change;
        if (mod == 1) {
            System.out.print("New Username: ");
            change = input.nextLine();
            x.setUsername(change);
            System.out.println("Modify Username complete");
        } else if (mod == 2) {
            String role = "";
            String ID = "";
            int roh = 0;
            while (true) {
                System.out.println("1.Staff");
                System.out.println("2.Housekeeper");
                System.out.println("3.Security");
                System.out.println("4.Manager");
                System.out.println("=============================================================================================================");
                System.out.print("New Work Type: ");
                roh = input.nextInt();
                if ((roh == 1) || (roh == 2) || (roh == 3) || (roh == 4)) {
                    break;
                } else {
                    System.out.println("The input is invalid.");
                }
            }
            switch (roh) {
                case 1:
                    System.out.print("Role name: ");
                    role = input.nextLine();
                    input.nextLine();
                    ID = STR."ST\{GenID(roh).substring(2)}";
                    x.setRole(role);
                    x.setNumber(ID);
                    x.setAccessCard(new Staff());
                    System.out.println("Modify Role complete");
                    break;
                case 2:
                    System.out.print("Role name: ");
                    role = input.nextLine();
                    input.nextLine();
                    ID = STR."HO\{GenID(roh).substring(2)}";
                    x.setRole(role);
                    x.setNumber(ID);
                    x.setAccessCard(new Housekeeper());
                    System.out.println("Modify Role complete");
                    break;
                case 3:
                    System.out.print("Role name: ");
                    role = input.nextLine();
                    input.nextLine();
                    ID = STR."SE\{GenID(roh).substring(2)}";
                    x.setRole(role);
                    x.setNumber(ID);
                    x.setAccessCard(new Security());
                    System.out.println("Modify Role complete");
                    break;
                case 4:
                    System.out.print("Role name: ");
                    role = input.nextLine();
                    input.nextLine();
                    ID = STR."MA\{GenID(roh).substring(2)}";
                    x.setRole(role);
                    x.setNumber(ID);
                    x.setAccessCard(new Manager());
                    System.out.println("Modify Role complete");
                    break;
            }
        } else if (mod == 3) {
            System.out.print("Are you sure you want to delete this card?(Yes/yes to delete)");
            String delete = input.nextLine();
            if (Objects.equals(delete, "yes") || Objects.equals(delete, "Yes")) {
                x.deleteCard();
                System.out.println("Modify Delete Card complete");
            }
        }
    }

    static void modifyCard() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the card ID you want to modify: ");
        String ID = input.nextLine();
        System.out.println(ID);
        System.out.println("=============================================================================================================");
        Card Modcard = checkCard(ID);
        if (Objects.equals(Modcard.getnumber(), "Notfound")) {
            System.out.println("Card ID not found matching the entered value.");
        } else {
            if (customeroremployee(ID)) {
                modcustomer((CustomerCard) Modcard);
            } else {
                modemployee((EmployeeCard) Modcard);
            }
        }

    }

    public static void cardmenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Add Card");
        System.out.println("2.Modify/Delete Card");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1) {
            addCard();
        } else if (menu == 2) {
            modifyCard();
        }
    }

    public static Room checkRoom(String x){
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j <20;j++ ){
                if (Objects.equals(x, Guestroom[i][j].getNameOrCode())) {
                    return Guestroom[i][j];
                }}
        }
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(x, meetingroom[i].getNameOrCode())) {
                return meetingroom[i];
            }
        }
        return NotfoundRoom;
    }
    public static boolean checkGuestorMeeting(String x){
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j <20;j++ ){
                if (Objects.equals(x, Guestroom[i][j].getNameOrCode())) {
                    return true;
                }}
        }
        return false;
    }

    public static void modGusetroom(GuestRoom x){
        Scanner input = new Scanner(System.in);
        System.out.println("1.Change to a vacant room");
        System.out.println("2.Change to a reserved room");
        System.out.println("3.Changed to a common room");
        System.out.println("=============================================================================================================");
        String Change = input.nextLine();
        if (Objects.equals(Change, "1")){
            x.setAccessStrategy(new VacantRoomAccess());
        } else if (Objects.equals(Change, "2")) {
            x.setAccessStrategy(new ReservedRoomAccess());
        } else if (Objects.equals(Change, "3")) {
            x.setAccessStrategy(new WelfareRoomAccess());
        } else {
            System.out.println("The input is invalid.");
        }
    }
    public static void modMeetingroom(MeetingRoom x){
        Scanner input = new Scanner(System.in);
            System.out.println("1.Change to a vacant room");
            System.out.println("2.Change to a rented room");
            System.out.println("3.Changed to a common room");
            System.out.println("=============================================================================================================");
            String Change = input.nextLine();
        if (Objects.equals(Change, "1")){
            x.setAccessStrategy(new VacantRoomAccess());
        } else if (Objects.equals(Change, "2")) {
            x.setAccessStrategy(new RentedPlaceAccess());
        } else if (Objects.equals(Change, "3")) {
            x.setAccessStrategy(new WelfareRoomAccess());
        } else {
            System.out.println("The input is invalid.");
        }
    }
    public static void changeAccess(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the room ID you want to change access: ");
        String ID = input.nextLine();
        System.out.println(ID);
        System.out.println("=============================================================================================================");
        Room Modroom = checkRoom(ID);
        if (Objects.equals(Modroom.getNameOrCode(), "Notfound")) {
            System.out.println("Room number not found matching the entered value.");
        } else {
            if (checkGuestorMeeting(ID)) {
                modGusetroom((GuestRoom) Modroom);
            } else {
                modMeetingroom((MeetingRoom) Modroom);
            }
        }
    }

    static void Usageinformation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name or code of the room you want to view usage information: ");
        String ID = input.nextLine();
        System.out.println(ID);
        System.out.println("=============================================================================================================");
        Room mod = checkRoom(ID);
        if (Objects.equals(mod.getNameOrCode(), "Notfound")) {
            System.out.println("Room not found matching the entered value.");
        } else {
            mod.getUsageinfo();
        }

    }
    public static void roommenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Change room status");
        System.out.println("2.Get room detail");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1) {
            changeAccess();
        } else if (menu == 2) {
            modifyCard();
        }
    }

    static Card checkemc(String x) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1000; j++) {
                if (Objects.equals(x, Employeelist[i][j].getnumber())) {
                    return Employeelist[i][j];
                }
            }
        }
        return NotfoundCard;
    }

    public static void checkroomentry(){
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.print("Enter in the ID of the card: ");
        String ID = input.nextLine();
        System.out.print("Specify the name or ID of the room you want to enter: ");
        String Room = input.nextLine();
        Card employeeCard = checkemc(ID);
        CustomerCard customerCard = (CustomerCard) checkCard(ID);
        Room room = checkRoom(Room);
        String use ;
        if(room.canAccess(employeeCard.canAccess())){
            use = STR."\{employeeCard.getUsername()} \{employeeCard.getNumber()} \{now.toString()} Access Approval";
            room.importUsageinfo(use);
            System.out.println("Access Approval");
            room.getUsageinfo();
        }
        else if (room.canAccess(customerCard.canAccess())) {
            if (Objects.equals(customerCard.getdecryptID(), room.getID())){
                use = STR."\{customerCard.getUsername()} \{customerCard.getNumber()} \{now.toString()} Access Approval";
                room.importUsageinfo(use);
                System.out.println("Access Approval");
                room.getUsageinfo();
                customerCard.encryptID();
            }else {
                System.out.println("Access Denied");
        }}else {
            System.out.println("Access Denied");
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            numID[i][2] = 1;
            for (int j = 0; j < 1000; j++) {
                Employeelist[i][j] = new EmployeeCard();
            }
        }
        for (int i = 0; i < 5; i++){
        for (int j = 0; j < 20; j++) {
            Guest[i][j] = new CustomerCard();
            String x = STR."GR\{i}\{j}";
            Guestroom[i][j] = new GuestRoom(x,new VacantRoomAccess());
        }}
        for (int i = 0; i < 10; i++) {
            Tenet[i] = new CustomerCard();
            String x = STR."MR\{i}";
            meetingroom[i] = new MeetingRoom(x,new VacantRoomAccess());
            for (int j = 0; j < 200; j++) {
                Follower[i][j] = new CustomerCard();
            }
        }
        CustomerCard gr;
        Guest[0][1] = new CustomerCard("mark","GR01","room",new Owner(),"767988");
        Guestroom[0][1] = new GuestRoom("GR01","767988",new ReservedRoomAccess(),"mark");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("=============================================================================================================");
            System.out.println("1.Card Management");
            System.out.println("2.Room Management");
            System.out.println("3.Check");
            System.out.println("=============================================================================================================");
            int menu = input.nextInt();
            if (menu == 1) {
                cardmenu();
            } else if (menu == 2){
                roommenu();
            } else if (menu == 3) {
                checkroomentry();
            }
        }
    }
}
