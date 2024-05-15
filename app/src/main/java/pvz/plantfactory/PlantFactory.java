package pvz.plantfactory;

import pvz.plant.*;

public abstract class PlantFactory {
    private long lastInvokeTime;
    private long coolDownTime;

    public PlantFactory(long coolDownTime) {
        this.coolDownTime = coolDownTime;
        lastInvokeTime = -50000;
    }

    public boolean canInvoke(long invokeTime) throws IllegalStateException {
        if (invokeTime - lastInvokeTime >= coolDownTime) {
            lastInvokeTime = invokeTime;
            return true;
        }
        throw new IllegalStateException("Cannot invoke at this time.");
    }

    public abstract Plant createPlant(long invokeTime);
}
