package Items.Clothes;

import java.io.Serializable;

public abstract class Equipment  implements Serializable {
    int cost;
    String name;

    public Equipment(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
