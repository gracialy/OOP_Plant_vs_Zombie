package pvz.plant;

import java.util.Timer;
import java.util.TimerTask;

public class Snowpea extends Plant {
    private static final int SLOW_DURATION = 3000; // 3 seconds in milliseconds
    // private static final double SLOW_EFFECT = 0.5; // Slowing effect by 50%

    public Snowpea(long invokeTime) {
        super("Snowpea", 100, 25, 4, -1, invokeTime);
        setInitial("SNP");
    }
}
