package pvz.plantfactory;

import pvz.plant.Plant;
import pvz.plant.twinSunflower;

public class twinSunflowerFactory implements PlantFactory {
    public Plant createPlant() {
        return new twinSunflower();
    }
}
