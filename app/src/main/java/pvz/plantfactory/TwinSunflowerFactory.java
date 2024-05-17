package pvz.plantfactory;

import pvz.plant.*;

public class TwinSunflowerFactory extends PlantFactory {
    public TwinSunflowerFactory() {
        super(20000, 125);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new TwinSunflower();
        }
        else throw new IllegalStateException("Cannot create TwinSunflower");
    }
}
