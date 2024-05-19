package pvz.zombie;

public class LadderZombie extends Zombie {
    public LadderZombie(int waktu) {
        super("Ladder Zombie", 250, 840, 1, false, waktu);
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
