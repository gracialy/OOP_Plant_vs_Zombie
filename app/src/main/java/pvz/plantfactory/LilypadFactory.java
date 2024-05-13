package pvz.plantfactory;

import pvz.plant.Lilypad;
import pvz.plant.Plant;

public class LilypadFactory implements PlantFactory {
    public Plant createPlant() {
        return new Lilypad();
    }
}
