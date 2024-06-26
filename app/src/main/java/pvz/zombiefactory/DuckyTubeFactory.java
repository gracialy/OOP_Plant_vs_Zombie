package pvz.zombiefactory;

import pvz.zombie.DuckyTube;
import pvz.zombie.Zombie;

public class DuckyTubeFactory extends ZombieFactory {
    @Override
    public Zombie createZombie(int currentTime) {
        return new DuckyTube(currentTime);
    }
}
