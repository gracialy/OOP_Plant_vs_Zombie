package pvz.zombie;

public class BucketHat extends Zombie {
    private boolean has_bucket;

    public BucketHat(int waktu) {
        super("Normal Zombie", 300, 100, 1, false, waktu);
        setInitial("BHZ");
    }

    public boolean hasBucket() {
        return has_bucket;
    }

    @Override
    public void attack() {
        // Attack the plant
    }
}
