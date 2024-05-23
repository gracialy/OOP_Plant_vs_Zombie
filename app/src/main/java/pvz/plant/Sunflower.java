package pvz.plant;

import pvz.sun.Sun;

public class Sunflower extends Plant {
    private int SUN_AMOUNT = 25;

    public Sunflower(long invokeTime) {
        super("Sunflower", 100, 0, 0, 0, invokeTime);
    }

    @Override
    public boolean isAttackTime(long currentTime) {
        return (currentTime - getLastAttackTime() >= 3) || (getLastAttackTime() == getPlantTime());
    }

    private void produceSun() {
        Sun.addSun(SUN_AMOUNT);
        System.out.println("Sunflower produced 25 sun. Total Sun: " + Sun.getSunValue());
    }

    @Override
    public void attack() {
    }
}
