package pvz.main;

import java.util.Scanner;

public class Help implements Option {
    @Override
    public void select() {

        Scanner scanner = ScannerUtil.getScanner();

        System.out.println("Game Instructions: ");
        System.out.println("===============================");
        System.out.println("This is a game where you have to kill Michael with Lalapan.");
        System.out.println("Choose 'Start' menu to begin the game.");
        System.out.println("Choose 'Help' menu to request game information");
        System.out.println("Choose 'Michael List' menu to view the list of Michaels.");
        System.out.println("Choose 'Lalapan List' menu to view the list of Lalapans.");
        System.out.println("Choose 'Exit' menu to exit the game.");
        System.out.println("===============================");
        System.out.println("Enter anything to go back: ");
        String choice = scanner.nextLine();
        return;
    }
}
