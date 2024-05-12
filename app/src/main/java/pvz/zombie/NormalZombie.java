package pvz.zombie;

public class NormalZombie extends Zombie {
    public NormalZombie() {
        super("Normal Zombie", 125, 100, 1, false);
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
