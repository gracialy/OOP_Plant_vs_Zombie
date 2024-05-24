package pvz.zombiefactory;

import pvz.zombie.*;

public class NormalFactory extends ZombieFactory {
    @Override
    public Zombie createZombie(int currentTime) {
        return new NormalZombie(currentTime);
    }
}
