package pvz.pack;

import pvz.main.ToolsUtil;
import pvz.plantfactory.PlantFactory;

public class PregameMaster implements PregameMediator {
    private Inventory inventory;
    private Deck deck;

    @Override
    public void registerInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void registerDeck(Deck deck) {
        this.deck = deck;
    }
    
    @Override
    public void addToDeck(int pos) {
        try {
            if (deck.isFull()) {
                throw new IllegalStateException("Deck is full");
            }
            else {
                PlantFactory plantFactory = inventory.opRemove(pos);
                deck.opAdd(plantFactory);
            }
        }
        catch (Exception e) {
           System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
           ToolsUtil.delay(2);
        }
    }

    @Override
    public void removeFromDeck(int pos) {
        try {
            PlantFactory plantFactory = deck.opRemove(pos);
            inventory.opAdd(plantFactory);
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            ToolsUtil.delay(2);
        }
    }

    @Override
    public void swapInventory(int pos1, int pos2) {
        try {
            inventory.opSwap(pos1, pos2);
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            ToolsUtil.delay(2);
        }
    }

    @Override
    public void swapDeck(int pos1, int pos2) {
        try {
            deck.opSwap(pos1, pos2);
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            ToolsUtil.delay(2);
        }
    }
}
