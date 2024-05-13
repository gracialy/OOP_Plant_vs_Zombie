package pvz.pack;

public interface PregameMediator {
    public void registerInventory(Inventory inventory);
    public void registerDeck(Deck deck);
    
    public void addToDeck(int pos);
    public void removeFromDeck(int pos);
}
