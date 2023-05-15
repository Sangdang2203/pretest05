package data;

import java.util.Scanner;

public abstract class Product {

    public String ID;
    public String name;
    public double price;
    private int next;
    private int max;
    private MobilePhone[] mList;

    public Product() {
        this.ID = "";
        this.name = "";
        this.price = 1.0f;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void accept() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter product ID: ");
            this.ID = sc.nextLine();
            while (ID.isEmpty()) {
                System.out.println("Product ID not null !!!");
                System.out.print("Enter product ID: ");
                this.ID = sc.nextLine();
            }

            System.out.print("Enter Product name: ");
            this.name = sc.nextLine();
            while (name.isEmpty()) {
                System.out.println("Product name not null !!!");
                System.out.print("Enter Product name: ");
                this.name = sc.nextLine();
            }

            System.out.print("Enter price: ");
            this.price = sc.nextDouble();
            while (price <= 0) {
                System.out.println("Price must be great than 0 !!!");
                System.out.print("Enter price: ");
                this.price = sc.nextDouble();
                sc.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public abstract void printInfo();

//    private boolean checkExistProduct(String ID) {
//        for (int i = 0; i < next; i++) {
//            if (mList[i].getID().toLowerCase().equals(ID.toLowerCase())) {
//                return true;
//            }
//        }
//        return false;
//    }

}
