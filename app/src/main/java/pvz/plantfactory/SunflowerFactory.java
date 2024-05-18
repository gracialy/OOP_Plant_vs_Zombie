package pvz.plantfactory;

import pvz.plant.*;

public class SunflowerFactory extends PlantFactory {
    public SunflowerFactory() {
        super(10000, 50);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Sunflower(invokeTime); 
        }
        else throw new IllegalStateException("Cannot create Sunflower"); 
    }
}
