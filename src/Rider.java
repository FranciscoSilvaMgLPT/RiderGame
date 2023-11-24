public class Rider extends Human {

    public Rider(String name, int cash) {
        super(name, cash);
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
}
