package pvz.zombiefactory;

import pvz.zombie.LadderZombie;
import pvz.zombie.Zombie;

public class LadderFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new LadderZombie();
    }
}
