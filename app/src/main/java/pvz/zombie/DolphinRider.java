package pvz.zombie;

public class DolphinRider extends Zombie {
    private boolean has_jump;

    public DolphinRider(int waktu) {
        super("Dolphin Rider Zombie", 175, 100, 1, true, waktu);
        has_jump = false;
    }

    public boolean hasJump() {
        return has_jump;
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
