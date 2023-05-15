package app;

import data.MobilePhone;
import java.util.Scanner;

public class MobilePhoneTest {

    private int next;
    private int max;
    private MobilePhone[] mList;

    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the maximum of mobilephone list: ");
            max = sc.nextInt();
            try {
                if (max > 0) {
                    mList = new MobilePhone[max];
                    break;
                } else {
                    System.out.println("Invalid input. "
                            + "The maximum of MobilePhone list must be great than 0 !!!\n");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public MobilePhoneTest() {
        input();
        next = 0;
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        if (next >= max) {
            System.out.println("Mobilephone list was full !\n");
        } else {
            mList[next++] = new MobilePhone();
            mList[next - 1].accept();           
            System.out.println("Add new mobilephone successfully.\n");
        }
    }

    public void display() {
        if (next > 0) {
            System.out.println("-- List of Mobilephone --");
            for (int i = 0; i < next; i++) {
                System.out.println(mList[i]);
            }
        } else {
            System.out.println("Don't have any information to display !!!\n");
        }
    }

    public void displayTop1() {
        
    }

    public void display(String mBrand) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Brand: ");
            String brand = sc.nextLine();
            for (int i = 0; i < next; i++) {
                if (mList[i].getBrand().equals(brand)) {
                    System.out.print("-- Information of Mobile Phone --");
                    System.out.println(mList[i]);
                    return;
                }
            }
            System.out.printf("Brand %s not found !!!", brand);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void remove(String mID) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter MobilePhone ID: ");
            String ID = sc.nextLine();
            int index = -1;
            for (int i = 0; i < next; i++) {
                if (mList[i].getID().equals(ID)) {
                    index = i;
                }
            }
            if (index != -1) {
                for (int i = index; i < next - 1; i++) {
                    mList[i].setID(mList[i + 1].getID());
                    mList[i].setName(mList[i + 1].getName());
                    mList[i].setPrice(mList[i + 1].getPrice());
                    mList[i].setBrand(mList[i + 1].getBrand());
                    mList[i].setYear(mList[i + 1].getYear());
                    mList[i].setQoh(mList[i + 1].getQoh());
                }
                mList[--next] = null;
                System.out.println("Delete successfully.\n");
            } else {
                System.out.printf("Mobilephone ID: %s not found !!!\n", ID);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void menu() {
        System.out.println("\n__ Manage Mobilephone List __");
        System.out.println("1. Add new Mobile Phone");
        System.out.println("2. Display list of Mobile Phone");
        System.out.println("3. Display Top 1 Mobile Phone");
        System.out.println("4. Search Mobile Phone by brand name");
        System.out.println("5. Remove Mobile Phone by ID");
        System.out.println("6. Exit Program.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobilePhoneTest dao = new MobilePhoneTest();
        while (true) {
            dao.menu();
            System.out.print("\nEnter yout choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add new Mobile Phone");
                    dao.add();
                    break;
                case 2:
                    System.out.println("2. Display list of Mobile Phone");
                    dao.display();
                    break;
                case 3:
                    System.out.println("3. Display Top 1 Mobile Phone");
                    dao.displayTop1();
                    break;
                case 4:
                    System.out.println("4. Search Mobile Phone by brand name");
                    dao.display("Iphone");
                    break;
                case 5:
                    System.out.println("5. Remove Mobile Phone by ID");
                    dao.remove("");
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. "
                            + "Please enter your choice again (in range 1-6) !!!");
                    break;
            }
        }
    }   
}
