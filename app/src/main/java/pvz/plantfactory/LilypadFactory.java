package pvz.plantfactory;

import pvz.plant.*;

public class LilypadFactory extends PlantFactory {
    public LilypadFactory() {
        super(10, 25);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Lilypad(invokeTime);
        } else
            throw new IllegalStateException("Cannot create Lilypad");
    }
}
