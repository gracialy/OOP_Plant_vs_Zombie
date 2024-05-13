package pvz.plantfactory;

import pvz.plant.*;

public class ChomperFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Chomper();
    }
}
