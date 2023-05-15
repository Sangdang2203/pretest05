package data;

import java.util.Scanner;

public class MobilePhone extends Product{
    public String brand;
    public int year;
    public int qoh;  /*Quantity on hand*/

    public MobilePhone() {
        super();
        this.brand = "Iphone";
        this.year = 2000;
        this.qoh = 1;
    }

    @Override
    public void accept() {
        Scanner sc = new Scanner(System.in);
        super.accept();
        try {
            System.out.print("Enter Brand: ");
            String brand = sc.nextLine();
            while (!brand.equals("Iphone") && !brand.equals("Samsung") && !brand.equals("Motorala") && !brand.equals("Nokia")) {
                System.out.println("Brand only accept: Iphone; Samsung; Motorala; Nokia");
                System.out.print("Enter Brand: ");
                brand = sc.nextLine();
            }
            this.brand = brand;

            System.out.print("Enter Year: ");
            int year = sc.nextInt();
            while (year < 2000) {
                System.out.println("Year must be from 2000 until now !!!");
                System.out.print("Enter Year: ");
                year = sc.nextInt();
                sc.nextLine();
            }
            this.year = year;

            System.out.print("Enter Quantity: ");
            int qoh = sc.nextInt();
            while (qoh <= 0 || qoh > 30) {
                System.out.println("Quantity must be in range 0-30 !");
                System.out.print("Enter Quantity: ");
                qoh = sc.nextInt();
                sc.nextLine();
            }
            this.qoh = qoh;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    @Override
    public void printInfo() {
        System.out.printf("ID: %s\n", getID());
        System.out.printf("Name: %s\n", getName());
        System.out.printf("Brand: %s\n", brand);
        System.out.printf("Price: %f\n", getPrice());
        System.out.printf("Year: %d\n", year);
        System.out.printf("Quantity of hand: %d\n", qoh);
        System.out.printf("Amount: %f\n", getPrice() * qoh);
    }

    @Override
    public String toString() {
        return "\nID: " + getID() 
                + "\nName: " + getName().toUpperCase()
                + "\nBrand: " + brand         
                + "\nYear: " + year
                + "\nPrice: " + getPrice() + " USD/piece"
                + "\nQuantity on hand: " + qoh + " pieces"
                + "\nAmount: " + getPrice() * qoh + " USD";               
    }

}
