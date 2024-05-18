package pvz.plantfactory;

import pvz.plant.*;

public class SquashFactory extends PlantFactory {
    public SquashFactory() {
        super(20000, 50);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Squash(invokeTime);
        }
        else throw new IllegalStateException("Cannot create Squash");
    }
}
