package pvz.sun;

public class Sun {
    // private static final int CONST_SUN = 25;
    private static int totalSun = 0;

    public Sun() {
        totalSun++;
    }

    // start game sun

    // morning sun

    public static int getTotalSun() {
        return totalSun;
    }

    public static void useSun() {
        totalSun--;
    }
}