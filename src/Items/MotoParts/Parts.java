package Items.MotoParts;

import java.io.Serializable;

public abstract class Parts  implements Serializable {
    private final String name;
    private boolean destroyed;
    private final int cost;
    private final int repaircost;
    private final int lvl;

    public Parts(String name, int cost, int repaircost, int lvl) {
        this.name = name;
        this.cost = cost;
        this.repaircost = repaircost;
        this.lvl = lvl;
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

    public int getCost() {
        return cost;
    }

    public int getRepaircost() {
        return repaircost;
    }

    public int getLvl() {
        return lvl;
    }
}
