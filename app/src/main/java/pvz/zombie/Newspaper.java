package pvz.zombie;

public class Newspaper extends Zombie {
    public Newspaper(int waktu) {
        super("Newspaper Zombie", 250, 420, 1, false, waktu);
        setInitial("NWZ");
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
