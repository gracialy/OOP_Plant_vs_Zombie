package pvz.map;

public class SafeArea extends Tile {
    @Override
    public boolean canPlant() {
        return false; // Tidak bisa menanam di SafeArea
    }
}
