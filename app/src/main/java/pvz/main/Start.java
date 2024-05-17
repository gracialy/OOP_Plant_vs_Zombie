package pvz.main;

import pvz.pack.*;

public class Start implements Option {
    @Override
    public void select() {
        Pregame pregame;
        Deck deck;
        
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
        System.out.printf("Loading Game");
        for (int i = 0; i < 3; i++) {
            System.out.printf(" .");
            ToolsUtil.delay(1);
        }
        ToolsUtil.clearScreen();

        Thread gameThread = new Thread(new Game(deck));
        System.out.println("Game loaded successfully!");
        ToolsUtil.delay(2);
        ToolsUtil.clearScreen();
        gameThread.start();

        try {
            gameThread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Game interrupted!");
        }

    }
}
