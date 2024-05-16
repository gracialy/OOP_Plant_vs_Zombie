package pvz.plant;

import java.util.Timer;
import java.util.TimerTask;

public class Snowpea extends Plant {
    private static final int SLOW_DURATION = 3000; // 3 seconds in milliseconds
    // private static final double SLOW_EFFECT = 0.5; // Slowing effect by 50%

    public Snowpea() {
        super("Snowpea", 175, 100, 25, 4, -1);
    }

    @Override
    public void attack() {
        // Zombie.reduceSpeed(SLOW_EFFECT); // Mengurangi kecepatan zombie
        // Timer untuk mengembalikan kecepatan zombie setelah 3 detik
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Zombie.resetSpeed();
            }
        }, SLOW_DURATION);
    }
}
