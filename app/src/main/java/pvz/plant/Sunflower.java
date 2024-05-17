package pvz.plant;

import java.util.Timer;
import java.util.TimerTask;
import pvz.sun.Sun;

public class Sunflower extends Plant {
    private int SUN_AMOUNT = 25;
    private static final int PRODUCTION_INTERVAL = 3000;

    public Sunflower() {
        super("Sunflower", 100, 0, 0, 0);
        startProduction();
    }

    private void startProduction() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                produceSun();
            }
        }, 0, PRODUCTION_INTERVAL);
    }

    // Menghasilkan Sun dan menambahkannya ke value Sun pemain
    private void produceSun() {
        Sun.addSun(SUN_AMOUNT);
        System.out.println("Sunflower produced 25 sun. Total Sun: " + Sun.getSunValue());
    }

    @Override
    public void attack() {
        // Sunflower tidak menyerang
    }
}
