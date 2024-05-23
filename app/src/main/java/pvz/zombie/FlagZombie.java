package pvz.zombie;

public class FlagZombie extends Zombie {
    public FlagZombie(int waktu) {
        super("Flag Zombie", 250, 200, 1, false, waktu);
        setInitial("FLZ");
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
