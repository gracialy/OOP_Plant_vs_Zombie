package pvz.Map;

import java.util.ArrayList;
import java.util.List;
import pvz.plant.Plant;
import pvz.zombie.Zombie;

public abstract class Tile {
    private Plant plant;
    private List<Zombie> zombies;

    public Tile() {
        zombies = new ArrayList<>();
    }

    public void addZombie(Zombie zombie) {
        zombies.add(zombie);
    }

    public void removeZombie(Zombie zombie) {
        zombies.remove(zombie);
    }

    public List<Zombie> getZombies() {
        return zombies;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        if (canPlant()) {
            this.plant = plant;
        }
    }

    public abstract boolean canPlant();
}
