package pvz.menu;

import pvz.plant.Chomper;
import pvz.plant.Jalapeno;
import pvz.plant.Lilypad;
import pvz.plant.Peashooter;
import pvz.plant.Plant; // Asumsi ada kelas Plant
import pvz.plant.Snowpea;
import pvz.plant.Spikeweed;
import pvz.plant.Sunflower;
import pvz.plant.Wallnut;
import pvz.plant.twinSunflower;

import java.util.ArrayList;
import java.util.List;

public class PlantsList implements Menu {
    private List<Plant> plants;

    public PlantsList() {
        this.plants = new ArrayList<>();
        initializePlants();
    }

    private void initializePlants() {
        plants.add(new Sunflower());
        plants.add(new Peashooter());
        plants.add(new Wallnut());
        plants.add(new Snowpea());
        plants.add(new Lilypad());
        plants.add(new Chomper());
        plants.add(new Jalapeno());
        plants.add(new Spikeweed());
        plants.add(new twinSunflower());

    }

    @Override
    public void select() {
        System.out.println("List of Plants :");
        int i = 1;
        for (Plant plant : plants) {

            System.out.println(i + "." + plant.getName());
            i++;

        }
    }
}
