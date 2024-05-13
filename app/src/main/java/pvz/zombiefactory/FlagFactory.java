package pvz.zombiefactory;

import pvz.zombie.FlagZombie;
import pvz.zombie.Zombie;

public class FlagFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new FlagZombie();
    }
}
