package pvz.plantfactory;

import pvz.plant.*;

public class TwinSunflowerFactory extends PlantFactory {
    public TwinSunflowerFactory() {
        super(20000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new TwinSunflower();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
