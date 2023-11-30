package Buildings;
import Items.Clothes.*;
import Items.MotoParts.Engine;
import Items.MotoParts.Parts;
import Items.MotoParts.Tires;
import Items.Motorcycle;
import java.util.ArrayList;
import java.util.Arrays;

public class MotorcycleStore {
    private ArrayList<Parts> parts;
    private ArrayList<Motorcycle> motorcycles;
    private ArrayList<Equipment> equipment;

    public MotorcycleStore() {
        this.parts = new ArrayList<>(Arrays.asList(new Engine(200, 100, 2), new Engine(400, 200, 4), new Engine(600,300,8),
                new Tires(100, 50, 2), new Tires(400, 200, 4), new Tires(600,300,7)));

        this.motorcycles = new ArrayList<>(Arrays.asList(new Motorcycle("Yamaha", 800),
                new Motorcycle("Honda", 700), new Motorcycle("Suzuki", 600),
                new Motorcycle("Kawasaki", 700), new Motorcycle("Ducati", 700),
                new Motorcycle("Saschs", 500)));

        this.equipment= new ArrayList<>(Arrays.asList(new Jacket(400), new Helmet(600), new Sneakers(400), new Pants(400)));
    }

    public ArrayList<Parts> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Parts> parts) {
        this.parts = parts;
    }

    public ArrayList<Motorcycle> getMotorcycles() {
        return motorcycles;
    }

    public void setMotorcycles(ArrayList<Motorcycle> motorcycles) {
        this.motorcycles = motorcycles;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }
}
