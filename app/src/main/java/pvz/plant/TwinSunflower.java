package pvz.plant;

import pvz.sun.Sun;

public class TwinSunflower extends Plant {
    private static final int SUN_AMOUNT = 100;

    public TwinSunflower(long invokeTime) {
        super("Twin Sunflower", 300, 0, 0, 0, invokeTime);
        setInitial("TSP");
    }

    @Override
    public boolean isAttackTime(long currentTime) {
        return (currentTime - getLastAttackTime() >= 3) || (currentTime == getPlantTime());
    }

    public void produceSun(long currentTime) {
        Sun.addSun(SUN_AMOUNT);
        setLastAttackTime(currentTime);
        System.out.println("TwinSunflower produced 25 sun. Total Sun: " + Sun.getSunValue());
    }
}
