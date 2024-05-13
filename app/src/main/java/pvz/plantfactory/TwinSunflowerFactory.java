package pvz.plantfactory;

import pvz.plant.*;

public class TwinSunflowerFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new TwinSunflower();
    }
}
