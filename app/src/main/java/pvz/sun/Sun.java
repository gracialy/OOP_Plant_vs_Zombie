package pvz.sun;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Sun {
    private static int totalSun = 0;
    private final Random random = new Random();
    private final Timer timer = new Timer();

    public Sun(int value) {
        totalSun = value;
    }

    public static void addSun(int banyak) {
        totalSun += banyak;
    }

    public static int getTotalSun() {
        return totalSun;
    }

    public static void useSun() {
        totalSun--;
    }

    public void startMorningSunProduction() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Sun.addSun(25);
                    startMorningSunProduction();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000 * (5 + random.nextInt(6)));
    }

    public void stopProduction() {
        timer.cancel();
    }
}
