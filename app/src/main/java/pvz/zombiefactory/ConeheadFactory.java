package pvz.zombiefactory;

import pvz.zombie.*;

public class ConeheadFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new Conehead();
    }
}
