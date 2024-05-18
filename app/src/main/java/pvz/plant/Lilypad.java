package pvz.plant;

public class Lilypad extends Plant {
    private Plant storePlant;

    public Lilypad(long invokeTime) {
        super("Lilypad", 100, 0, 0, 0, invokeTime);
    }

    // Menempatkan tanaman di Lilypad
    public void placePlant(Plant plant) {
        if (this.storePlant == null) { // Pastikan tidak ada tanaman lain yang sudah ditanam
            this.storePlant = plant;
            // Menambahkan health lilypad ke tanaman yang ditanam di atasnya
            plant.setHealth(plant.getHealth() + this.getHealth());
            System.out.println(plant.getName() + " placed on Lilypad with combined health of " + plant.getHealth());
        } else {
            System.out.println("Lilypad is already occupied.");
        }
    }

    @Override
    public void setHealth(int health) {
        int healthDiff = health - this.getHealth();
        super.setHealth(health);
        if (storePlant != null) {
            storePlant.setHealth(storePlant.getHealth() + healthDiff);
        }
    }

    @Override
    public void attack() {
        // Sunflower tidak menyerang
    }
}
