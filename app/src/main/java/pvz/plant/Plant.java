package pvz.plant;

public abstract class Plant {
    private String name;
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;

    // private boolean isAlive;

    public Plant(String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attackDamage;
        this.attack_speed = attackSpeed;
        this.range = range;
        this.cooldown = cooldown;
        // this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    // public boolean getIsAlive() {
    //     return isAlive;
    // }

    // public void setIsAlive(boolean isAlive) {
    //     this.isAlive = isAlive;
    // }

    public abstract void attack();

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            // isAlive = false;
            System.out.println(name + " is dead");
        }
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Cost: " + cost);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Range: " + range);
        System.out.println("Cooldown: " + cooldown);
    }
}
