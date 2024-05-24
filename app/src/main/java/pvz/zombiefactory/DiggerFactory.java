package pvz.zombiefactory;

import pvz.zombie.DiggerZombie;
import pvz.zombie.Zombie;

public class DiggerFactory extends ZombieFactory {
    @Override
    public Zombie createZombie(int currentTime) {
        return new DiggerZombie(currentTime);
    }
}
