package pvz.zombie;

public class DolphinRider extends Zombie {

    public DolphinRider(int waktu) {
        super("Dolphin Rider Zombie", 175, 100, 1, true, waktu);
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
