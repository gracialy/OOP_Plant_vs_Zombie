package pvz.main;

import java.util.Scanner;

public class Help implements Option {
    @Override
    public void select() {

        Scanner scanner = ScannerUtil.getScanner();

        System.out.println("Game Instructions: ");
        System.out.println("===============================");
        System.out.println("This is a game where you have to kill zombies with plants.");
        System.out.println("This is a game where you can plant plants to defend your house from zombies.");
        System.out.println("1. Tekan Tombol 'Start' untuk memulai Permainan ");
        System.out.println("2. Tekan Tombol 'Help' untuk meminta informasi permainan ");
        System.out.println("3. Tekan Tombol 'Plant List' untuk melihat daftar Tanaman yang dimiliki Michael");
        System.out.println("4. Tekan Tombol 'Zombie List' untuk melihat daftar Zombie yang dihadapi Michael");
        System.out.println("0. Tekan Tombol 'Exit' untuk keluar dari  Permainan ");
        System.out.println("===============================");
        System.out.println("Enter 0 to go back: ");
        int choice = Integer.parseInt(scanner.nextLine());
    }
}
