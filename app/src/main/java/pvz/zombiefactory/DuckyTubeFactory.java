package pvz.zombiefactory;

import pvz.main.Game;
import pvz.zombie.DuckyTube;
import pvz.zombie.Zombie;

public class DuckyTubeFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new DuckyTube(Game.getElapsedTime());
    }
}
