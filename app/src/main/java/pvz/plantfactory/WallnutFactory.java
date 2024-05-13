package pvz.plantfactory;

import pvz.plant.*;

public class WallnutFactory implements PlantFactory {
    @Override
    public Plant createPlant() {
        return new Wallnut();
    }
}
