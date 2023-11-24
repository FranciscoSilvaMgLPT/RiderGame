package Body;

import Items.Clothes.Equipment;

public abstract class BodyParts {
    private final String name;
    private boolean healthy=true;
    private int repairCost;
    private Equipment equipment = null;

    public BodyParts(String name, Integer repairCost) {
        this.name = name;
        this.repairCost = repairCost;
    }

    public String getName() {
        return name;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
