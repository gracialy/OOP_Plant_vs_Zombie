package pvz.zombie;

public class NormalZombie extends Zombie {
    public NormalZombie(int waktu) {
        super("Normal Zombie", 125, 100, 1, false, waktu);
        setInitial("NOZ");
    }
}
