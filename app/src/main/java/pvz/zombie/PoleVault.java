package pvz.zombie;

public class PoleVault extends Zombie {
    public PoleVault(int waktu) {
        super("Pole Vaulting Zombie", 175, 100, 1, false, waktu);
        setInitial("PVZ");
    }
}
