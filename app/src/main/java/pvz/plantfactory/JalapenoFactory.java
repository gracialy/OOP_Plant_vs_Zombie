package pvz.plantfactory;

import pvz.plant.*;

public class JalapenoFactory extends PlantFactory {
    public JalapenoFactory() {
        super(2, 125);
    }

    @Override
    public Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException {
        if (canInvoke(invokeTime, sunValue)) {
            setLastInvokeTime(invokeTime);
            return new Jalapeno(invokeTime);
        } else
            throw new IllegalStateException("Cannot create Jalapeno");
    }
}
