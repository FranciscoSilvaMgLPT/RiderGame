package Items;

import Items.MotoParts.Engine;
import Items.MotoParts.Parts;
import Items.MotoParts.Tires;

import java.util.ArrayList;
import java.util.Arrays;

public class Motorcycle {
    private ArrayList<Parts> parts = new ArrayList<>();
    private final String name;
    private int price;

    int power;
    private boolean destroyed;

    public Motorcycle(String name, int power, int price) {
        this.parts = new ArrayList<>(Arrays.asList(new Engine(500,200,1),new Tires(200,50,1)));
        this.name = name;
        this.price=price;
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
}
