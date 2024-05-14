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
        System.out.println("===============================");
        System.out.println("Enter 0 to go back: ");
        int choice = Integer.parseInt(scanner.nextLine());
        // can handle exception maybe
    }
}
