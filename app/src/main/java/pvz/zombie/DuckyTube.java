package pvz.zombie;

public class DuckyTube extends Zombie {
    public DuckyTube(int waktu) {
        super("Ducky Tube Zombie", 100, 100, 1, true, waktu);
        setInitial("DTZ");
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
