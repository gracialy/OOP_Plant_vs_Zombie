package pvz.main;

import java.util.Scanner;

public class Help implements Option {
    @Override
    public void select() {
        // give game description
        // give game instructions
        // give game commands
        Scanner scanner = ScannerUtil.getScanner();

        System.out.println("Game Instructions: ");
        System.out.println("===============================");
        // placeholder
        System.out.println("This is a game where you have to kill zombies with plants.");
        System.out.println("Tekan Tombol 'Start' untuk memulai Permainan ");
        System.out.println("Tekan Tombol 'Help' untuk meminta informasi permainan ");
        System.out.println("Tekan Tombol 'Plant List' untuk melihat daftar Tanaman yang dimiliki Michael");
        System.out.println("Tekan Tombol 'Zombie List' untuk melihat daftar Zombie yang dihadapi Michael");
        System.out.println("Tekan Tombol 'Exit' untuk keluar dari  Permainan ");
        System.out.println("===============================");
        System.out.println("Enter 0 to go back: ");
        int choice = Integer.parseInt(scanner.nextLine());
        // can handle exception maybe
    }
}
