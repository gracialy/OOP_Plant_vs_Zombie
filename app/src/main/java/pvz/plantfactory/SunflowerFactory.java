package pvz.plantfactory;

import pvz.plant.*;

public class SunflowerFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Sunflower();
    }
}
