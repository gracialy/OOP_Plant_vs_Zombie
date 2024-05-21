package pvz.main;

public class Time {
    private long startTime;
    private String cycle;

    public Time()
    {
        startTime = System.currentTimeMillis();
        cycle = "day";
    }

    public long getStartTime()
    {
        return startTime;
    }

    public long getElapsedTime()
    {
        return System.currentTimeMillis() - startTime;
    }

    public long getElapsedSeconds()
    {
        return getElapsedTime() / 1000;
    }

    public String getCycle()
    {
        return cycle;
    }

    public void setCycle(String cycle)
    {
        this.cycle = cycle;
    }

    // public void run()
    // {
    //     while (true) {
    //         try {
    //             Thread.sleep(1);
    //             milliseconds += 1;
    //         }
    //         catch (Exception err) {
    //         }
    //     }
    // }
}
