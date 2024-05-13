package pvz.menu;

public class Help implements Menu {
    @Override
    public void select() {
        // give game description
        // give game instructions
        // give game commands
        System.out.println("This is a game where you can plant plants to defend your house from zombies.");
        System.out.println("1. Tekan Tombol 'Start' untuk memulai Permainan ");
        System.out.println("2. Tekan Tombol 'Help' untuk meminta informasi permainan ");
        System.out.println("3. Tekan Tombol 'Plant List' untuk melihat daftar Tanaman yang dimiliki Michael");
        System.out.println("4. Tekan Tombol 'Zombie List' untuk melihat daftar Zombie yang dihadapi Michael");
        System.out.println("5. Tekan Tombol 'Exit' untuk keluar dari  Permainan ");
    }
}
