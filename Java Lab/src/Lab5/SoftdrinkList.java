/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class SoftdrinkList {

    private Softdrink list[];
    static Scanner sc = new Scanner(System.in);
    private int count = 0;

    public SoftdrinkList(int size) {
        if (size < 0) {
            size = 10;
        }
        list = new Softdrink[size];
    }

    void addSoftdrinkTest() {
        Softdrink obj = new Softdrink("X01", "COCA", 10, 600);
        list[count++] = obj;
        obj = new Softdrink("X02", "PEPSI", 20, 900);
        list[count++] = obj;
        obj = new Softdrink("K02", "COCA", 20, 500);
        list[count++] = obj;
        obj = new Softdrink("K09", "HENRY", 20, 500);
        list[count++] = obj;
    }

    void addSoftdrink() {
        System.out.println();
        Softdrink obj = new Softdrink();

        try {
            System.out.print("Code: ");
            obj.setCode(sc.nextLine().trim().toUpperCase());
            System.out.print("Make: ");
            obj.setMake(sc.nextLine().trim().toUpperCase());
            System.out.print("Volume: ");
            obj.setVolume(Integer.parseInt(sc.nextLine().trim().toUpperCase()));
            System.out.print("Price: ");
            obj.setPrice(Float.parseFloat(sc.nextLine().trim().toUpperCase()));
        } catch (Exception e) {
            System.out.println("Error Input. Please try again");
            return;
        }

        if (findCode(obj.getCode()) > -1) {
            System.out.println("Duplicate code.");
            return;
        }

        list[count++] = obj;
        System.out.println("Added");
    }

    int findCode(String code) {
        for (int i = 0; i < count; i++) {
            if (list[i].getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    void updateSoftdrinkByCode() {
        if (count < 1) {
            System.out.println("No item");
            return;
        }

        System.out.print("Code to update SoftDrink price: ");
        String code = sc.nextLine().trim().toUpperCase();
        if (findCode(code) == -1) {
            System.out.println("No softdrink to update");
            return;
        }
        try {
            System.out.print("Price: ");
            float price = Float.parseFloat(sc.nextLine().trim().toUpperCase());
            if (price < 0) {
                System.out.println("Error Input. Can't update");
                return;
            }
            list[findCode(code)].setPrice(price);
        } catch (Exception e) {
            System.out.println("Error Input. Can't update");
            return;
        }
        System.out.println("Updated");
    }

    void findSoftdrinkByMake() {
        if (count < 1) {
            System.out.println("No item");
            return;
        }

        String make = "";
        System.out.print("Enter manufacturers to search items: ");
        make = sc.nextLine().trim().toUpperCase();
        int isPrinted = 0;
        for (int i = 0; i < count; i++) {
            if (list[i].getMake().equals(make)) {
                list[i].printSoftdrink();
                isPrinted = 1;
            }
        }
        if (isPrinted == 0) {
            System.out.println("No items");
            return;
        }
    }

    void deleteSoftdrinkByMake() {
        if (count < 1) {
            System.out.println("No item");
            return;
        }

        String make = "";
        System.out.print("Enter manufacturers to search items: ");
        make = sc.nextLine().trim().toUpperCase();

        int isDeletedAll = 0;
        do {
            int isDeleted = 0;
            for (int i = 0; i < count; i++) {
                if (list[i].getMake().equals(make)) {
                    for (int j = i; j < count; j++) {
                        list[i] = list[i + 1];
                    }
                    isDeleted = 1;
                }
            }
            if (isDeleted == 1) {
                count = count - 1;
                isDeletedAll = 1;
            } else {
                break;
            }
        } while (count > 0);

        if (isDeletedAll == 1) {
            System.out.println("Deleted All Maker.");
        } else {
            System.out.println("Nothing deleted");
        }
    }

    void listSoftdrink() {
        if (count < 1) {
            System.out.println("No item");
            return;
        }

        this.sortSoftdrinkList();
        for (int i = 0; i < count; i++) {
            list[i].printSoftdrink();
        }
    }

    void sortSoftdrinkList() {
        for (int i = 0; i < count; i++) {
            for (int j = count - 1; j > i; j--) {
                String a = list[i].getMake();
                String b = list[j].getMake();
                float c = list[i].getPrice();
                float d = list[j].getPrice();
                if ((a.compareTo(b) > 0) || (a.compareTo(b) == 0 && c > d)) {
                    Softdrink obj = list[i];
                    list[i] = list[j];
                    list[j] = obj;
                }
            }
        }
    }
}
