package Body;

import java.io.Serializable;

public class Torso extends BodyPart implements Serializable {
    public Torso(int repairCost) {
        super("torso", repairCost);
    }
}
