package pvz.zombie;

public class DiggerZombie extends Zombie {

    public DiggerZombie(int waktu) {
        super("Digger  Zombie", 250, 840, 1, false, waktu);
        setInitial("DGZ");
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
