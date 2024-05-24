package pvz.zombie;

public class BucketHat extends Zombie {
    public BucketHat(int waktu) {
        super("Normal Zombie", 300, 100, 1, false, waktu);
        setInitial("BHZ");
    }
}
