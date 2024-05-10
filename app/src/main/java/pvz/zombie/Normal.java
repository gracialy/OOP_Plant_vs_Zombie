package pvz.zombie;

public class Normal extends Zombie {
    public Normal() {
        super("Normal Zombie", 125, 100, 1, false);
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
