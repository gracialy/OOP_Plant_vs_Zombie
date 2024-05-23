package pvz.zombie;

public abstract class Zombie {
    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean is_aquatic;
    private long speed = NORMAL_SPEED;
    private int waktuZomb;
    private boolean jump = false;
    private int lastAttackTime;
    private String initial;
    private int lastSlowed = -5;

    public static final int NORMAL_SPEED = 50000;
    // private boolean is_dead;

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, int waktuZomb) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.is_aquatic = is_aquatic;
        this.waktuZomb = waktuZomb;
        this.lastAttackTime = waktuZomb;
    }

    public int getLastSlowed() {
        return lastSlowed;
    }

    public void setLastSlowed(int lastSlowed) {
        this.lastSlowed = lastSlowed;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attack_damage;
    }

    public int getAttackSpeed() {
        return attack_speed;
    }

    public long getSpeed(int currentTime) {
        if (currentTime - lastSlowed > 3) {
            resetSpeed();
        }
        return speed;
    }

    public boolean isAquatic() {
        return is_aquatic;
    }

    public void takeDamage(int damage, boolean hasSlowEffect, int currentTime) {
        health -= damage;
        if (hasSlowEffect) {
            reduceSpeed(2);
            setLastSlowed(currentTime);
        }
    }

    public void reduceSpeed(long factor) {
        this.speed /= factor;
    }

    public void resetSpeed() {
        this.speed = NORMAL_SPEED;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public int getWaktuZomb() {
        return waktuZomb;
    }

    // Setter untuk waktuZomb
    public void setWaktuZomb(int waktuZomb) {
        this.waktuZomb = waktuZomb;
    }

    public boolean getJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public int getLastAttackTime() {
        return lastAttackTime;
    }

    public void setLastAttackTime(int lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Is Aquatic: " + is_aquatic);
    }

    public boolean isAttackTime(long currentTime) {
        return (currentTime - lastAttackTime >= attack_speed) || (lastAttackTime == waktuZomb);
    }

    public abstract void attack();
}
