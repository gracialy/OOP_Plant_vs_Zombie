package pvz.plantfactory;

import pvz.plant.*;

public class JalapenoFactory extends PlantFactory {
    public JalapenoFactory() {
        super(20000, 125);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Jalapeno();
        }
        else throw new IllegalStateException("Cannot create Jalapeno");
    }
}
