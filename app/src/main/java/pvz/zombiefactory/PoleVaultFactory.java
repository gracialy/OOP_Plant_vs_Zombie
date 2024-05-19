package pvz.zombiefactory;

import pvz.main.Game;
import pvz.zombie.*;

public class PoleVaultFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new PoleVault(Game.getElapsedTime());
    }
}
