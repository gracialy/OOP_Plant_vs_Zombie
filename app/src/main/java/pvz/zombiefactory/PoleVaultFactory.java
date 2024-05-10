package pvz.zombiefactory;

import pvz.zombie.*;

public class PoleVaultFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new PoleVault();
    }
}
