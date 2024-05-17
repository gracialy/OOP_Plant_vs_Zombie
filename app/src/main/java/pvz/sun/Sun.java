package pvz.sun;

public class Sun {
    private static final int SUN_VALUE = 500;
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

    public static void useSun() {
        getInstance().value--;
    }

    public static void produceSun(long invokeTime) {
        if (onInvokeTime(invokeTime)) {
            getInstance().value += SUN_VALUE;
            getInstance().lastInvoke = invokeTime;
            System.out.println("Sun produced!");
        }
    }

    public static void addSun(int amount) {
        getInstance().value += amount;
    }

    public static boolean onInvokeTime(long elapsedTime) {
        if (elapsedTime - getLastInvoke() >= 5000 && elapsedTime - getLastInvoke() <= 9000) {
            return Math.random() < 0.5 ? true : false;
        } else if (elapsedTime - getLastInvoke() == 10000) {
            return true;
        } else
            return false;
    }
}
