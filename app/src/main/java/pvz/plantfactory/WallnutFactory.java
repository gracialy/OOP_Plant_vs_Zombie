package pvz.plantfactory;

import pvz.plant.*;

public class WallnutFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Wallnut();
    }
}