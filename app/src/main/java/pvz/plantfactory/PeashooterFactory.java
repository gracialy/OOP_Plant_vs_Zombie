package pvz.plantfactory;

import pvz.plant.*;

public class PeashooterFactory extends PlantFactory {
    public PeashooterFactory() {
        super(10000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Peashooter();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
