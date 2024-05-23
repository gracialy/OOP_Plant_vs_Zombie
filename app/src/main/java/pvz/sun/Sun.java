package pvz.sun;

public class Sun {
    private static final int SUN_VALUE = 100; // TODO: harusnya 50
    private static final int SUN_PRODUCE = 25;
    private static Sun instance;
    private int value;
    private long lastInvoke;

    private Sun() {
        value = SUN_VALUE;
        lastInvoke = 0;
    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }

    public static int getSunValue() {
        return getInstance().value;
    }

    public static long getLastInvoke() {
        return getInstance().lastInvoke;
    }

    public static void useSun(int nilai) {
        getInstance().value -= nilai;
    }

    public static void produceSun(long invokeTime) {
        if (onInvokeTime(invokeTime)) {
            getInstance().value += SUN_PRODUCE;
            getInstance().lastInvoke = invokeTime;
        }
    }

    public static void addSun(int amount) {
        getInstance().value += amount;
    }

    public static boolean onInvokeTime(long elapsedTime) {
        if (elapsedTime - getLastInvoke() >= 5 && elapsedTime - getLastInvoke() <= 9) {
            return Math.random() < 0.5 ? true : false;
        } else if (elapsedTime - getLastInvoke() > 9) {
            return true;
        } else
            return false;
    }
}
