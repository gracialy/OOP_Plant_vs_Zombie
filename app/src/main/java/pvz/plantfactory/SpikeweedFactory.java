package pvz.plantfactory;

import pvz.plant.Plant;
import pvz.plant.Spikeweed;

public class SpikeweedFactory implements PlantFactory {
    public Plant createPlant() {
        return new Spikeweed();
    }
}
