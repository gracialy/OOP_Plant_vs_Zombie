package pvz.plant;

public class Peashooter extends Plant {
    public Peashooter(long invokeTime) {
        super("Peashooter", 100, 25, 4000, -1, invokeTime);
    }

    @Override
    public void attack() {
        // Shoot a pea
        // The pea disappears
    }
}