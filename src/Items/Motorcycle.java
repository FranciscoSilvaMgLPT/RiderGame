package Items;

import Items.MotoParts.Engine;
import Items.MotoParts.Parts;
import Items.MotoParts.Tires;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Motorcycle implements Serializable {
    private ArrayList<Parts> parts = new ArrayList<>();
    private final String name;
    private int price;
    int power;
    int safety;
    private boolean destroyed;

    public Motorcycle(String name, int power, int price) {
        this.parts = new ArrayList<>(Arrays.asList(new Engine(500,200,1),new Tires(200,50,1)));
        this.name = name;
        this.price=price;
        this.safety=0;
        this.power=0;
    }
    public String getName() {
        return name;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public ArrayList<Parts> getParts() {
        return parts;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
    }
}
