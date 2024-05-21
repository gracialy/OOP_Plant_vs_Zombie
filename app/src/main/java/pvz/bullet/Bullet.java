package pvz.bullet;

import pvz.plant.*;

public class Bullet {
    private int damage;
    private int range;
    private boolean slowEffect;
    private int originX;
    private int originY;

    public Bullet(Plant plant, int originX, int originY) {
        this.damage = plant.getAttackDamage();
        this.range = plant.getRange();
        this.slowEffect = plant instanceof Snowpea;
        this.originX = originX;
        this.originY = originY;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public boolean hasSlowEffect() {
        return slowEffect;
    }

    public int getOriginX() {
        return originX;
    }

    public int getOriginY() {
        return originY;
    }
}
