package pvz.zombiefactory;

import pvz.main.Game;
import pvz.zombie.DolphinRider;
import pvz.zombie.Zombie;

public class DolphinFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new DolphinRider(Game.getElapsedTime());
    }
}
