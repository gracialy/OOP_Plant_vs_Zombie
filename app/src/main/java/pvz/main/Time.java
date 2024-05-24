package pvz.main;

public class Time {
    private long startTime;
    private String cycle;

    public Time()
    {
        startTime = System.currentTimeMillis();
        cycle = "day";
    }

    public Time(int elapsedTime) {
        startTime = System.currentTimeMillis() - elapsedTime * 1000;
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
        if (getElapsedSeconds() > 100)
        {
            setCycle("night");
        }
        return cycle;
    }

    public void setCycle(String cycle)
    {
        this.cycle = cycle;
    }
}
