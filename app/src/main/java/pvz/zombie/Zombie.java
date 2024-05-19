package pvz.zombie;

public abstract class Zombie {
    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean is_aquatic;
    private long speed = NORMAL_SPEED;

    public static final int NORMAL_SPEED = 50000;
    // private boolean is_dead;

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.is_aquatic = is_aquatic;
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

    public long getSpeed() {
        return speed;
    }

    public boolean isAquatic() {
        return is_aquatic;
    }

    public void takeDamage(int damage, boolean hasSlowEffect) {
        health -= damage;
        if (hasSlowEffect) reduceSpeed(2);
    }

    public void reduceSpeed(long factor) {
        this.speed /= factor;
    }

    public void resetSpeed(long factor) {
        this.speed = NORMAL_SPEED;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Is Aquatic: " + is_aquatic);
    }

    public abstract void attack();
}
