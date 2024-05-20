package pvz.main;

import java.util.Scanner;

import pvz.pack.*;

public class Pregame {
    private Inventory inventory;
    private Deck deck;
    private PregameMaster mediator;

    public Pregame() {
        PregameMaster mediator = new PregameMaster();

        inventory = new Inventory(mediator);
        deck = new Deck(mediator);

        mediator.registerInventory(inventory);
        mediator.registerDeck(deck);
    }

    public Deck getDeck() {
        return deck;
    }

    public int init() throws IllegalArgumentException {
        Scanner scanner = ScannerUtil.getScanner();

        int choice = -1, choice1, choice2;

        do {
            ToolsUtil.clearScreen();
            System.out.println("Setting Deck: ");
            System.out.println("===============================");
            System.out.println("Inventory: " + inventory.getInfo());
            System.out.println("Deck: " + deck.getInfo());
            System.out.println("===============================");
            System.out.println("1. Add to Deck");
            System.out.println("2. Remove from Deck");
            System.out.println("3. Swap Cards in Inventory");
            System.out.println("4. Swap Cards in Deck");
            if (deck.isFull())
                System.out.println("5. Use Deck");
            System.out.println("0. Go Back");
            System.out.println("===============================");
            System.out.println("Enter your choice [0.." + (deck.isFull() ? "5" : "4") + "]:");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                // ToolsUtil.delay(1);
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Choose card to add to deck: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    inventory.addToDeck(choice);
                    break;
                case 2:
                    System.out.println("Choose card to remove from deck: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    inventory.removeFromDeck(choice);
                    break;
                case 3:
                    System.out.println("Choose card to swap in inventory: ");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Choose card to swap with in inventory: ");
                    choice2 = Integer.parseInt(scanner.nextLine());
                    inventory.swapInventory(choice1, choice2);
                    break;
                case 4:
                    System.out.println("Choose card to swap in deck: ");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Choose card to swap with in deck: ");
                    choice2 = Integer.parseInt(scanner.nextLine());
                    deck.swapDeck(choice1, choice2);
                    break;
                case 5:
                    try {
                        if (deck.isFull()) {
                            ToolsUtil.clearScreen();
                            System.out.println("Deck: " + deck.getInfo());
                            System.out.println("===============================");
                            System.out.printf("Finalizing Deck");
                            for (int i = 0; i < 3; i++) {
                                System.out.printf(" .");
                                // ToolsUtil.delay(1);
                            }
                            ToolsUtil.clearScreen();
                            return 0;
                        } else
                            throw new IllegalArgumentException("Deck must have 6 cards to use.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    // return 1;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    // ToolsUtil.delay(1);
                    break;
            }

        } while (choice != 0);
        return 1;
    }
}
