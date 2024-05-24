package pvz.plantfactory;

import pvz.plant.*;

public class PeashooterFactory extends PlantFactory {
    public PeashooterFactory() {
        super(10, 100);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Peashooter(invokeTime);
        } else
            throw new IllegalStateException("Cannot create Peashooter");
    }
}