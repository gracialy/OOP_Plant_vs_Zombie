package pvz.Map;

public class SafeArea extends Tile {
    @Override
    public boolean canPlant() {
        return false; // Tidak bisa menanam di SafeArea
    }
}
