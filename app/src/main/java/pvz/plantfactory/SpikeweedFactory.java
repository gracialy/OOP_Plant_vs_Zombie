package pvz.plantfactory;

import pvz.plant.*;

public class SpikeweedFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Spikeweed();
    }
}