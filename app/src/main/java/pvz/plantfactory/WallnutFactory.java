package pvz.plantfactory;

import pvz.plant.*;

public class WallnutFactory extends PlantFactory {
    public WallnutFactory() {
        super(20000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Wallnut();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
