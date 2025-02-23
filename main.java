import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    static Card [] Guest = new CustomerCard[100];
    static Card [] Tenet = new CustomerCard[100];
    static Card [][] Follower = new CustomerCard[10][500];
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
        System.out.println("2.Meeting Room");
        System.out.println("=============================================================================================================");
        System.out.print("Room Type: ");
        int roh = input.nextInt();
        if (roh == 1){
            RoomorHall = "room";
            break;
        }else if (roh == 2) {
            RoomorHall = "Hall";
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
        if (RoomorHall.equals("room")){Guest[number] = new CustomerCard(name,number,RoomorHall, new Owner());
        } else{
            if (owner){Tenet[number] = new CustomerCard(name,number,RoomorHall, new Owner());}
            else {Follower[number][Followernumber] = new CustomerCard(name,number,RoomorHall, new Follower());Followernumber++;}
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
                        ID = "ME"+GenID(roh);
                        Employeelist[roh][Employeenum] = new EmployeeCard(name,ID,role,new Manager());
                        break;
    }}

    static void addCard(){
        for (int i = 0; i<4;i++){numID[i][2] = 1;}
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Customer Card");
        System.out.println("2.Employee Card");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1){
            customer();
        } else if (menu == 2) {
            employee();
        }
    }

    static void modifyCard(){
        System.out.println("=============================================================================================================");
        System.out.print("");
    }

    public static void cardmenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================================================================");
        System.out.println("1.Add Card");
        System.out.println("2.modify Card");
        System.out.println("3.Delete Card");
        System.out.println("=============================================================================================================");
        int menu = input.nextInt();
        if (menu == 1){
            addCard();
        } else if (menu == 2) {
            modifyCard();
        }
    }

    public static void main(String[] args) {
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
