package pvz.pack;

public interface PregameMediator {
    public void registerInventory(Inventory inventory);
    public void registerDeck(Deck deck);
    
    public void addToDeck(int pos);
    public void removeFromDeck(int pos);

    public void swapInventory(int pos1, int pos2);
    public void swapDeck(int pos1, int pos2);
}
