package pvz.plant;

public class Wallnut extends Plant {
    public Wallnut (long invokeTime) {
        super("Wallnut", 1000, 0, 0, 0, invokeTime);
    }

    @Override
    public void attack() {
        // Do nothing
    }
}
