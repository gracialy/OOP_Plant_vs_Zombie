package pvz.zombiefactory;

import pvz.zombie.*;

public class PoleVaultFactory extends ZombieFactory {
    @Override
    public Zombie createZombie(int currentTime) {
        return new PoleVault(currentTime);
    }
}
