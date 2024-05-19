package pvz.zombie;

public class PoleVault extends Zombie {
    private boolean has_jump;

    public PoleVault(int waktu) {
        super("Pole Vaulting Zombie", 175, 100, 1, false, waktu);
    }

    @Override
    public void attack() {
        // Attack the plant
    }

    public boolean hasJump() {
        return has_jump;
    }

    public void jump() {
        // Jump over 1 plant
        // The plant disappears
        has_jump = true;
    }
}
