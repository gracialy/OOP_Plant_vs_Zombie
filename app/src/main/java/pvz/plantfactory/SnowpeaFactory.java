package pvz.plantfactory;

import pvz.plant.*;

public class SnowpeaFactory extends PlantFactory {
    public SnowpeaFactory() {
        super(10, 175);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Snowpea(invokeTime);
        } else
            throw new IllegalStateException("Cannot create Snowpea");
    }
}
