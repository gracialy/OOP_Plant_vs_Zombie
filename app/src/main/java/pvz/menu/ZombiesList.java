package pvz.menu;

import java.util.ArrayList;
import java.util.List;

import pvz.zombie.BucketHat;
import pvz.zombie.Conehead;
import pvz.zombie.DiggerZombie;
import pvz.zombie.DolphinRider;
import pvz.zombie.DuckyTube;
import pvz.zombie.FlagZombie;
import pvz.zombie.LadderZombie;
import pvz.zombie.Newspaper;
import pvz.zombie.NormalZombie;
import pvz.zombie.PoleVault;
import pvz.zombie.Zombie;

public class ZombiesList implements Menu {
    private List<Zombie> zombies;

    public ZombiesList() {
        this.zombies = new ArrayList<>();
        initializeZombies();
    }

    private void initializeZombies() {
        zombies.add(new NormalZombie());
        zombies.add(new Conehead());
        zombies.add(new PoleVault());
        zombies.add(new BucketHat());
        zombies.add(new DuckyTube());
        zombies.add(new DolphinRider());
        zombies.add(new FlagZombie());
        zombies.add(new DiggerZombie());
        zombies.add(new LadderZombie());
        zombies.add(new Newspaper());

    }

    @Override
    public void select() {
        System.out.println("List of zombies :");
        int i = 1;
        for (Zombie zombie : zombies) {

            System.out.println(i + "." + zombie.getName());
            i++;

        }
    }

}
