package pvz.plantfactory;

import pvz.plant.Chomper;
import pvz.plant.Plant;

public class ChomperFactory implements PlantFactory {
    public Plant createPlant() {
        return new Chomper();
    }
}
