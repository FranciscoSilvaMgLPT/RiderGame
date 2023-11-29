import Body.*;
import Items.Motorcycle;

import java.io.Serializable;
import java.util.ArrayList;

public class Rider extends Human implements Serializable {

    int trains;
    int training;

    public Rider(String name, int cash) {
        super(name, cash);
        this.training = 0;
        this.setMotorcycle(new Motorcycle("FAMEL", 0, 0));
    }

    public boolean canRide() {
        for (int i = 0; i < 4; i++) {
            if (!this.getBody().get(i).isHealthy()) {
                System.out.println("You cant ride! Your " + this.getBody().get(i).getName() + " doesnt look good!");
                return false;
            }
        }
        if (this.getMotorcycle().getTires().isDestroyed() || this.getMotorcycle().getEngine().isDestroyed()) {
            System.out.println("You cant ride! Your doesnt look good!");
            return false;

        }
        return true;
    }

    public int getTrains() {
        return trains;
    }

    public void setTrains(int trains) {
        this.trains = trains;
    }

    @Override
    public ArrayList<BodyPart> getBody() {
        return super.getBody();
    }

    @Override
    public Head getHead() {
        return super.getHead();
    }

    @Override
    public Feets getFeet() {
        return super.getFeet();
    }

    @Override
    public Torso getTorso() {
        return super.getTorso();
    }

    @Override
    public Legs getLegs() {
        return super.getLegs();
    }
}
