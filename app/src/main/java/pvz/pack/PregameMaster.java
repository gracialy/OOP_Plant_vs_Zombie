package pvz.pack;

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
        PlantFactory plantFactory = inventory.opRemove(pos);
        deck.opAdd(plantFactory);
    }

    @Override
    public void removeFromDeck(int pos) {
        PlantFactory plantFactory = deck.opRemove(pos);
        inventory.opAdd(plantFactory);
    }
}
