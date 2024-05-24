package pvz.zombie;

public class Newspaper extends Zombie {
    public Newspaper(int waktu) {
        super("Newspaper Zombie", 250, 420, 1, false, waktu);
        setInitial("NWZ");
    }

    @Override
    public void slowSpeed() {
        if (getHealth() > 210) setSpeed(NORMAL_SPEED * 2);
        else setSpeed(NORMAL_SPEED); 
    }

    @Override
    public void resetSpeed() {
        if (getHealth() > 210) setSpeed(NORMAL_SPEED);
        else setSpeed(NORMAL_SPEED / 2);
    }
}
