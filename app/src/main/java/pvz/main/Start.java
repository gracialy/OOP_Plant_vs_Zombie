package pvz.main;

import pvz.pack.*;

public class Start implements Option {
    @Override
    public void select() {
        final Pregame pregame;
        final Deck deck;

        // pregame
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

        System.out.printf("Loading Game");
        for (int i = 0; i < 3; i++) {
            System.out.printf(" .");
            ToolsUtil.delay(1);
        }
        ToolsUtil.clearScreen();
    }
}
