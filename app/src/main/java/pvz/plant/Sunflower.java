package pvz.plant;

import pvz.sun.Sun;

public class Sunflower extends Plant {
    private int SUN_AMOUNT = 25;

    public Sunflower(long invokeTime) {
        super("Sunflower", 100, 0, 0, 0, invokeTime);
        setInitial("SFP");
    }

    @Override
    public boolean isAttackTime(long currentTime) {
        return (currentTime - getLastAttackTime() >= 3) || (currentTime == getPlantTime());
    }

    public void produceSun(long currentTime) {
        Sun.addSun(SUN_AMOUNT);
        setLastAttackTime(currentTime);
        System.out.println("Sunflower produced 25 sun. Total Sun: " + Sun.getSunValue());
    }
}
