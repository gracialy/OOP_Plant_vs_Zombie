package pvz.zombiefactory;

import pvz.zombie.*;

public abstract class ZombieFactory {
    public abstract Zombie createZombie(int currentTime);
}
