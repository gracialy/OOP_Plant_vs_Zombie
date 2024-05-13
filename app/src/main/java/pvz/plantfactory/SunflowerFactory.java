package pvz.plantfactory;

import pvz.plant.*;

public class SunflowerFactory extends PlantFactory {
    public SunflowerFactory() {
        super(10000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Sunflower();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
