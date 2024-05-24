package pvz.zombiefactory;

import pvz.zombie.BucketHat;
import pvz.zombie.Zombie;

public class BucketFactory extends ZombieFactory {
    @Override
    public Zombie createZombie(int currentTime) {
        return new BucketHat(currentTime);
    }
}
