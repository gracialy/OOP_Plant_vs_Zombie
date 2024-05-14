package pvz.map;

public class PoolArea extends Tile {
    private boolean lilypadHere = false;

    public void setLilypadHere(boolean lilypadHere) {
        this.lilypadHere = lilypadHere;
    }

    @Override
    public boolean canPlant() {
        return lilypadHere; // Bisa menanam jika ada Lilypad
    }
}