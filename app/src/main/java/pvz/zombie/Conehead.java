package pvz.zombie;

public class Conehead extends Zombie {
    public Conehead(int waktu) {
        super("Conehead Zombie", 250, 100, 1, false, waktu);
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
