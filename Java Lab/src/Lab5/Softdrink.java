/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author Henry
 */
public class Softdrink {

    private String code;
    private String make;
    private int volume;
    private float price;

    public Softdrink(String code, String make, int volume, float price) {
        this.code = code;
        this.make = make;
        this.volume = volume;
        this.price = price;
    }

    public Softdrink() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void printSoftdrink() {
        System.out.println();
        System.out.println("Code: " + code);
        System.out.println("Make: " + make);
        System.out.println("Volume: " + volume);
        System.out.println("Price: " + price);
    }
}
