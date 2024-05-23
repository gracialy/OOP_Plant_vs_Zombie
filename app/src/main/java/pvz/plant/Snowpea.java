package pvz.plant;

public class Snowpea extends Plant {
    // private static final double SLOW_EFFECT = 0.5; // Slowing effect by 50%

    public Snowpea(long invokeTime) {
        super("Snowpea", 100, 25, 4, -1, invokeTime);
        setInitial("SNP");
    }
}
