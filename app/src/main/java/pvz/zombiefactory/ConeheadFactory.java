package pvz.zombiefactory;

import pvz.zombie.*;

public class ConeheadFactory extends ZombieFactory {
    @Override
    public Zombie createZombie(int currentTime) {
        return new Conehead(currentTime);
    }
}
