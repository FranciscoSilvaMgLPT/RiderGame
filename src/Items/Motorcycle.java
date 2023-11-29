package Items;

import Items.MotoParts.Engine;
import Items.MotoParts.Parts;
import Items.MotoParts.Tires;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Motorcycle implements Serializable {
    private final String name;
    private int price;
    int power;
    int safety;
    private Engine engine;
    private Tires tires;
    private boolean destroyed;

    public Motorcycle(String name, int power, int price) {
        this.name = name;
        this.price = price;
        this.engine = new Engine(500, 200, 1);
        this.tires = new Tires(200, 50, 1);
        this.safety = 0;
        this.power = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isDestroyed() {
        return destroyed;
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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }
}
