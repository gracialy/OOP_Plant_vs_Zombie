package pvz.plant;

public abstract class Plant {
    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private long plantTime;
    private long lastAttackTime;

    public Plant(String name, int health, int attackDamage, int attackSpeed, int range, long plantTime) {
        this.name = name;
        this.health = health;
        this.attack_damage = attackDamage;
        this.attack_speed = attackSpeed;
        this.range = range;
        this.plantTime = plantTime;
        this.lastAttackTime = plantTime;
        // this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attack_damage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attack_damage = attackDamage;
    }

    public int getAttackSpeed() {
        return attack_speed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attack_speed = attackSpeed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public long getPlantTime() {
        return plantTime;
    }

    public void setPlantTime(long plantTime) {
        this.plantTime = plantTime;
    }

    public long getLastAttackTime() {
        return lastAttackTime;
    }

    public void setLastAttackTime(long lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public boolean isAlive() {
        return health != 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAttackTime(long currentTime) {
        return (currentTime - lastAttackTime >= attack_speed) || (lastAttackTime == plantTime);
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Range: " + range);
    }

    public abstract void attack();
}
