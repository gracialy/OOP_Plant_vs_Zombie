package pvz.plantfactory;

import pvz.plant.*;

public class PeashooterFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Peashooter();
    }
}
