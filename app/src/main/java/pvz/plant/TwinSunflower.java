package pvz.plant;

import pvz.sun.Sun;

public class TwinSunflower extends Plant {
    private static final int SUN_AMOUNT = 100;

    public TwinSunflower() {
        super("Twin Sunflower", 300, 0, 0, 0);
    }

    // Menghasilkan Sun dan menambahkannya ke saldo Sun pemain
    private void produceSun() {
        Sun.addSun(SUN_AMOUNT);
        System.out.println("Sunflower produced 100 sun. Total Sun: " + Sun.getSunValue());
    }

    public void attack() {

    }
}
