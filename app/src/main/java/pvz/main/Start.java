package pvz.main;
import pvz.pack.*;

public class Start implements Option {
    Pregame pregame;
    Deck deck;
    int choice = -1;

    @Override
    public void select() {
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.println("Enter your choice [0..2]: ");
        try {
            choice = Integer.parseInt(ScannerUtil.getScanner().nextLine());
        } catch (Exception e) {
            System.out.println("Invalid choice. Please try again.");
            ToolsUtil.delay(1);

        }
        
        switch (choice) {
            case (1):
                newGame();
                break;
            case (2):
                loadGame();
                break;
            default:
                break;
        }
    }

    public void newGame() {
        // =============================== PREGAME ===============================
        System.out.printf("Loading Inventory and Deck");
        for (int i = 0; i < 3; i++) {
            System.out.printf(" .");
            ToolsUtil.delay(1);
        }

        pregame = new Pregame();

        if (pregame.init() == 1) {
            System.out.println("Failed to load Inventory and Deck!");
            ToolsUtil.delay(2);
            ToolsUtil.clearScreen();
            return;
        }

        deck = pregame.getDeck();
        System.out.println("Inventory and Deck loaded successfully!");
        ToolsUtil.delay(2);
        ToolsUtil.clearScreen();


        // =============================== GAME ===============================
        displayGame();

        Game game = new Game(deck);

        game.start();
        
        while (game.getRunning())
        {
            try {
                if (!game.getInputDelay())
                {
                    int choice = Integer.parseInt(game.scanner.nextLine());
                    game.setChoice(choice);
                    game.setInputDelay(true);
                }
            } catch (Exception e) {
                if (game.getRunning()) System.out.println("Invalid input!");
                ToolsUtil.delay(1);
                ToolsUtil.clearScreen();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadGame() {
        if (Save.getSavedSize() == 0) {
            System.out.println("No saved games found!");
            ToolsUtil.delay(1);
            ToolsUtil.clearScreen();
            return;
        }

        Save.printSaved();
        System.out.println("===============================");
        System.out.println("Enter the game you want to load: ");
        String name = ScannerUtil.getScanner().nextLine();
        while (!Save.isSaved(name)) {
            System.out.println("Game not found. Please try again.");
            name = ScannerUtil.getScanner().nextLine();
        }

        // =============================== GAME ===============================
        displayGame();

        Game cachedGame = Save.getSaved(name);
        Game game = new Game(name, cachedGame.getDeck(), cachedGame.getMap(), cachedGame.getElapsedTime());

        game.start();

        while (game.getRunning()) {
            try {
                if (!game.getInputDelay())
                {
                    int choice = Integer.parseInt(game.scanner.nextLine());
                    game.setChoice(choice);
                    game.setInputDelay(true);
                }
            } catch (Exception e) {
                if (game.getRunning()) {
                    System.out.println("Invalid input!");
                    game.setNewUpdate(true);
                }
                ToolsUtil.delay(1);
                ToolsUtil.clearScreen();
            }

            try {
                Thread.sleep(1);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayGame() {
        System.out.printf("Loading Game");
        for (int i = 0; i < 3; i++) {
            System.out.printf(" .");
            ToolsUtil.delay(1);
        }
        ToolsUtil.clearScreen();
    }
}