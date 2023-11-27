public class Rider extends Human {

    int trains;
    int training;

    public Rider(String name, int cash) {
        super(name, cash);
        this.training=0;
    }

    public boolean canRide() {
        for (int i = 0; i < 4; i++) {
            if (!this.getBody().get(i).isHealthy()) {
                System.out.println("You cant ride! Your " + this.getBody().get(i).getName() + " doesnt look good!");
                return false;
            }
        }
        for (int i = 0; i < this.getMotorcycle().getParts().size(); i++) {
            if (this.getMotorcycle().getParts().get(i).isDestroyed()) {
                System.out.println("You cant ride! Your " + this.getMotorcycle().getParts().get(i).getName() + " doesnt look good!");
                return false;
            }
        }
        return true;
    }

    public int getTrains() {
        return trains;
    }

    public void setTrains(int trains) {
        this.trains = trains;
    }
}
