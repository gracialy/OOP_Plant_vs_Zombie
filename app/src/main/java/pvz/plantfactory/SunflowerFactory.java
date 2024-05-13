package pvz.plantfactory;

import pvz.plant.Plant;
import pvz.plant.Sunflower;

public class SunflowerFactory implements PlantFactory {
    public Plant createPlant() {
        return new Sunflower();
    }
}
