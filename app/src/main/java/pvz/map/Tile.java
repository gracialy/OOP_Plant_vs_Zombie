package pvz.map;

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

    public void removeZombie() {
        zombies.removeIf(z -> z.getHealth() <= 0);
    }

    public void removeZombie(Zombie z) {
        zombies.remove(z);
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

    public void removePlant() {
        this.plant = null;
    }

    public abstract boolean canPlant();
}
