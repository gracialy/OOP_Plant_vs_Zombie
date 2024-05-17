package pvz.plantfactory;

import pvz.plant.*;

public abstract class PlantFactory {
    private long lastInvokeTime;
    private long coolDownTime;
    private int cost;

    public PlantFactory(long coolDownTime, int cost) {
        this.coolDownTime = coolDownTime;
        this.cost = cost;
        lastInvokeTime = -1;
    }

    public boolean canInvoke(long invokeTime, int sunValue) {
        if (lastInvokeTime == -1 || (invokeTime - lastInvokeTime >= coolDownTime)) {
            if (sunValue >= cost) return true;
        }
        return false;
    }

    public long getLastInvokeTime() {
        return lastInvokeTime;
    }

    public long getCoolDownTime() {
        return coolDownTime;
    }

    public int getCost() {
        return cost;
    }

    public void setLastInvokeTime(long lastInvokeTime) {
        this.lastInvokeTime = lastInvokeTime;
    }

    public abstract Plant createPlant(long invokeTime, int sunValue) throws IllegalStateException;
}