package pvz.plantfactory;

import pvz.plant.*;

public class WallnutFactory extends PlantFactory {
    public WallnutFactory() {
        super(20, 50);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Wallnut(invokeTime);
        } else
            throw new IllegalStateException("Cannot create Wallnut");
    }
}
