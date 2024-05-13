package pvz.plantfactory;

import pvz.plant.*;

public class PeashooterFactory implements PlantFactory {
    @Override
    public Plant createPlant() {
        return new Peashooter();
    }
}
