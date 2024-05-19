package pvz.zombiefactory;

import pvz.main.Game;
import pvz.zombie.Newspaper;
import pvz.zombie.Zombie;

public class NewspaperFactory extends ZombieFactory {
    @Override
    public Zombie createZombie() {
        return new Newspaper(Game.getElapsedTime());
    }
}
