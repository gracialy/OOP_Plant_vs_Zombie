package pvz.zombiefactory;

import pvz.main.Game;
import pvz.zombie.BucketHat;
import pvz.zombie.Zombie;

public class BucketFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new BucketHat(Game.getElapsedTime());
    }
}
