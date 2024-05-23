package pvz.plantfactory;

import pvz.plant.*;

public class ChomperFactory extends PlantFactory {
    public ChomperFactory() {
        super(2, 150);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Chomper(invokeTime); // Changed from Wallnut to Chomper
        } else
            throw new IllegalStateException("Cannot create Chomper"); // Changed from Wallnut to Chomper
    }
}
