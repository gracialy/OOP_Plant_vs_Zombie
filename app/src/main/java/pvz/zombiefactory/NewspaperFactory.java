package pvz.zombiefactory;

import pvz.zombie.Newspaper;
import pvz.zombie.Zombie;

public class NewspaperFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new Newspaper();
    }
}
