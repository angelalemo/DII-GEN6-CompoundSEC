
import java.util.Objects;
import java.util.Scanner;


public class main {
    static Card [] Guest = new CustomerCard[100];
    static Card [] Tenet = new CustomerCard[20];
    static Card [][] Follower = new CustomerCard[20][200];
    static int Followernumber = 0;


    static void customer(){
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        String name = input.nextLine();
        System.out.println("=============================================================================================================");
        String RoomorHall = "";
        Boolean owner = null;
        while (true){
        System.out.println("1.Room");
        System.out.println("2.MeetingRoom");
        System.out.println("=============================================================================================================");
        System.out.print("Room Type: ");
        int roh = input.nextInt();
        if (roh == 1){
            RoomorHall = "room";
            break;
        }else if (roh == 2) {
            RoomorHall = "meetingroom";
            while (true){
                System.out.println("1.Owner");
                System.out.println("2.Follower");
                System.out.println("=============================================================================================================");
                int OoF = input.nextInt();
                if (OoF == 1){
                    owner = true;
                    break;
                }else if (OoF == 2) {
                    owner = false;
                    break;}}
            break;}else {System.out.println("The input is invalid.");}}
        System.out.print("Numbers: ");
        int number = input.nextInt();
        String ID = "";
        if (RoomorHall.equals("room")){
            ID = "RO"+number;
            Guest[number] = new CustomerCard(name,ID,RoomorHall, new Owner());
        } else{
            if (owner){ID = "MO"+number;
                Tenet[number] = new CustomerCard(name,ID,RoomorHall, new Owner());}
            else {ID = "MF"+number;
                Follower[number][Followernumber] = new CustomerCard(name,ID,RoomorHall, new Follower());Followernumber++;}
        }
    }

    static int [][] numID = new int[4][3];
    static int Employeenum = 0;
    static String GenID(int n){
        Employeenum = ((numID[n-1][0])*100)+((numID[n-1][1])*10)+(numID[n-1][2]);
        String x = String.valueOf(numID[n-1][0])+String.valueOf(numID[n-1][1])+String.valueOf(numID[n-1][2]);

        numID[n-1][2]++;
        for(int i = 2; i>=1;i--){
            if (numID[n-1][i] == 10) {
                numID[n-1][i-1] --;
                numID[n-1][i] = 0;
            }
        }
        return x;
    }

    static Card [][] Employeelist = new EmployeeCard[4][1000];
    static void employee(){
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        String name = input.nextLine();
        System.out.println("=============================================================================================================");
        String role = "";
        String ID = "";
        int roh = 0;
        while (true){
            System.out.println("1.Staff");
            System.out.println("2.Housekeeper");
            System.out.println("3.Security");
            System.out.println("4.Manager");
            System.out.println("=============================================================================================================");
            System.out.print("Work Type: ");
            roh = input.nextInt();
        if((roh == 1)||(roh == 2)||(roh == 3)||(roh == 4)){
            break;
        }else {System.out.println("The input is invalid.");}}
        switch (roh) {
                case 1: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "ST"+GenID(roh);
                        Employeelist[roh][Employeenum] = new EmployeeCard(name,ID,role,new Staff());
                        break;
                case 2: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "HO"+GenID(roh);
                        Employeelist[roh][Employeenum] = new EmployeeCard(name,ID,role,new Housekeeper());
                        break;
                case 3: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "SE"+GenID(roh);
                        Employeelist[roh][Employeenum] = new EmployeeCard(name,ID,role,new Security());
                        break;
                case 4: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "MA"+GenID(roh);
                        Employeelist[roh][Employeenum] = new EmployeeCard(name,ID,role,new Manager());
                        break;
    }}

    static void addCard(){
        for (int i = 0; i<4;i++){numID[i][2] = 1;}
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Customer Card");
        System.out.println("2.Employee Card");
        System.out.println("3.Return to Card Management");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1){
            customer();
        } else if (menu == 2) {
            employee();
        } else if (menu == 3) {
            cardmenu();
        }
    }

    static Card Notfound = new EmployeeCard("Notfound","Notfound","Notfound",new Staff());
    static Card check(String x) {
        for (int i = 0; i < 100; i++) {
            if (Objects.equals(x, Guest[i].getId())) {
                return Guest[i];
            }}
        for (int i = 0; i < 20; i++) {
            if (Objects.equals(x, Tenet[i].getId())) {
                return Tenet[i];
            }}
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++){
            if (Objects.equals(x, Follower[i][j].getId())) {
                return Follower[i][j];
            }}}
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1000; j++){
                if (Objects.equals(x, Employeelist[i][j].getId())) {
                    return Employeelist[i][j];
                }}}
        return Notfound ;
    }
    static boolean customeroremployee(String x) {
        for (int i = 0; i < 100; i++) {
            if (Objects.equals(x, Guest[i].getId())) {
                return true;
            }}
        for (int i = 0; i < 20; i++) {
            if (Objects.equals(x, Tenet[i].getId())) {
                return true;
            }}
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++){
                if (Objects.equals(x, Follower[i][j].getId())) {
                    return true;
                }}}
        return false ;
    }

    static void modcustomer(CustomerCard x ){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to modify?");
        System.out.println("1.Modify Username");
        System.out.println("2.Modify Room Number");
        System.out.println("3.Delete Card");
        System.out.println("=============================================================================================================");
        int mod = input.nextInt();
        String change;
        switch (mod) {
            case 1: System.out.print("New Username: ");
                change = input.nextLine();
                x.setUsername(change);
                System.out.println("Modify Username complete");
                break;
            case 2: while(true){
                System.out.println("1.Room");
                System.out.println("2.Meeting Room");
                System.out.println("=============================================================================================================");
                int rom = input.nextInt();
                System.out.print("New Room Number");
                String num = input.nextLine();
                if(rom == 1){x.setRoomOrHall("room");x.setId("RO"+num);x.setAccessCard(new Owner());
                    System.out.println("Modify Room Number complete");
                    break;}
                else if (rom == 2) {x.setRoomOrHall("meeting room");
                    while (true){
                    System.out.println("1.Owner");
                    System.out.println("2.Follower");
                    int oof = input.nextInt();
                    if(oof == 1){x.setId("MO"+num);x.setAccessCard(new Owner());System.out.println("Modify Room Number complete");break;}
                    else if (oof == 2) {x.setId("MF"+num);x.setAccessCard(new Follower());System.out.println("Modify Room Number complete");break;}}}
                    break;}break;
            case 3: System.out.print("Are you sure you want to delete this card?(Yes/yes to delete)");
                String delete = input.nextLine();
                if(Objects.equals(delete, "yes") ||Objects.equals(delete, "Yes")){
                    x.deleteCard();
                    System.out.println("Modify Delete Card complete");
                }
                break;
    }}

    static void modemployee(EmployeeCard x ){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to modify?");
        System.out.println("1.Modify Username");
        System.out.println("2.Modify Role");
        System.out.println("3.Delete Card");
        System.out.println("=============================================================================================================");
        int mod = input.nextInt();
        String change;
        if(mod == 1) {
                System.out.print("New Username: ");
                change = input.nextLine();
                x.setUsername(change);
                System.out.println("Modify Username complete");}
        else if (mod == 2) {
                String role = "";
                String ID = "";
                int roh = 0;
                while (true){
                    System.out.println("1.Staff");
                    System.out.println("2.Housekeeper");
                    System.out.println("3.Security");
                    System.out.println("4.Manager");
                    System.out.println("=============================================================================================================");
                    System.out.print("New Work Type: ");
                    roh = input.nextInt();
                    if((roh == 1)||(roh == 2)||(roh == 3)||(roh == 4)){
                        break;
                    }else {System.out.println("The input is invalid.");}}
                switch (roh) {
                    case 1: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "ST"+GenID(roh).substring(2);
                        x.setRole(role);
                        x.setId(ID);
                        x.setAccessCard(new Staff());
                        System.out.println("Modify Role complete");
                        break;
                    case 2: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "HO"+GenID(roh).substring(2);
                        x.setRole(role);
                        x.setId(ID);
                        x.setAccessCard(new Housekeeper());
                        System.out.println("Modify Role complete");
                        break;
                    case 3: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "SE"+GenID(roh).substring(2);
                        x.setRole(role);
                        x.setId(ID);
                        x.setAccessCard(new Security());
                        System.out.println("Modify Role complete");
                        break;
                    case 4: System.out.print("Role name: ");
                        role = input.nextLine();input.nextLine();
                        ID = "MA"+GenID(roh).substring(2);
                        x.setRole(role);
                        x.setId(ID);
                        x.setAccessCard(new Manager());
                        System.out.println("Modify Role complete");
                        break;
                        }}
        else if (mod == 3){System.out.print("Are you sure you want to delete this card?(Yes/yes to delete)");
                String delete = input.nextLine();
                if(Objects.equals(delete, "yes") ||Objects.equals(delete, "Yes")){
                    x.deleteCard();
                    System.out.println("Modify Delete Card complete");
                }
        }}
    static void modifyCard(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the card ID you want to modify: ");
        String ID = input.nextLine();
        System.out.println(ID);
        System.out.println("=============================================================================================================");
        Card Modcard = check(ID);
        if(Objects.equals(Modcard.getId(), "Notfound")){
            System.out.println("Card ID not found matching the entered value.");
        }else {
            if(customeroremployee(ID)){
            modcustomer((CustomerCard) Modcard);
            }else {modemployee((EmployeeCard) Modcard);}
        }

    }

    public static void cardmenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Add Card");
        System.out.println("2.Modify/Delete Card");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1){
            addCard();
        } else if (menu == 2) {
            modifyCard();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4;i++){numID[i][2] = 1;
            for (int j = 0;j < 1000;j++){Employeelist[i][j] = new EmployeeCard();}}
        for (int i = 0;i < 100;i++){Guest[i] = new CustomerCard();}
        for (int i = 0;i < 20;i++){
            Tenet[i] = new CustomerCard();
            for (int j = 0;j < 200;j++){Follower[i][j] = new CustomerCard();}}
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
            }
        }
    }
}
