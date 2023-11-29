package Body;

import java.io.Serializable;

public class Legs extends BodyPart implements Serializable {

    public Legs(int repairCost) {
        super("legs", repairCost);
    }
}
