package pvz.plantfactory;

import pvz.plant.*;

public class SpikeweedFactory extends PlantFactory {
    public SpikeweedFactory() {
        super(20, 100);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Spikeweed(invokeTime);
        } else
            throw new IllegalStateException("Cannot create Spikeweed");
    }
}