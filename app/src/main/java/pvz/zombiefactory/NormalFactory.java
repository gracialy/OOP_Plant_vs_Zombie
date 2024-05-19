package pvz.zombiefactory;

import pvz.main.Game;
import pvz.zombie.*;

public class NormalFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new NormalZombie(Game.getElapsedTime());
    }
}
