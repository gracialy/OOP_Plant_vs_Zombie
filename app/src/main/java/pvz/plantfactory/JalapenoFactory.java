package pvz.plantfactory;

import pvz.plant.Jalapeno;
import pvz.plant.Plant;

public class JalapenoFactory implements PlantFactory {
    public Plant createPlant() {
        return new Jalapeno();
    }
}
