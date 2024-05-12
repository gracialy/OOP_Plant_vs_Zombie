package pvz.zombie;

public class DolphinRider extends Zombie {
    private boolean has_jump;

    public DolphinRider() {
        super("Dolphin Rider Zombie", 175, 100, 1, true);
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
