/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class ClockListUse {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("Add new clock");
        menu.addItem("Remove a clock");
        menu.addItem("Update a clock");
        menu.addItem("Print list");
        menu.addItem("Others: Quit");
        int choice;
        I_List list = new ClockList();
        do {
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    System.out.println();
                    break;
                case 2:
                    list.remove();
                    System.out.println();
                    break;
                case 3:
                    list.update();
                    System.out.println();
                    break;
                case 4:
                    list.sort();
                    list.output();
                    System.out.println();
                    break;
            }
        } while (choice >= 0 && choice <= 4);
    }
}
