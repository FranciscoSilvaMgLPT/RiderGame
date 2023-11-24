package Items.Clothes;

public abstract class Equipment {
    int cost;
    String name;

    public Equipment(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
