package pvz.map;

import java.util.ArrayList;
import java.util.Collections;

import pvz.plant.*;
import pvz.zombie.Zombie;

public class Map {
    private ArrayList<ArrayList<Tile>> land;
    public static final int ROWS = 6;
    public static final int COLS = 11;
    private final int POOL_START_ROW = 2;
    private final int POOL_END_ROW = 3;
    private final int SAFE_AREA_COL = 0;
    private final int ZOMBIE_SPAWN_COL = COLS + 1;

    public Map() {
        land = new ArrayList<>();
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < ROWS; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < COLS; j++) {
                if (j == SAFE_AREA_COL) {
                    row.add(new SafeArea());
                } else if (j == ZOMBIE_SPAWN_COL) {
                    row.add(new ZombieArea());
                } else if (i >= POOL_START_ROW && i <= POOL_END_ROW) {
                    row.add(new PoolArea());
                } else {
                    row.add(new GrassArea());
                }
            }
            land.add(row);
        }
    }

    public void displayMap() {
        String border = "+------+";
        String rowSeparator = String.join("", Collections.nCopies(COLS, border));

        System.out.println(rowSeparator);
        for (int i = 0; i < ROWS; i++) {
            ArrayList<Tile> row = land.get(i);
            System.out.print("|");
            for (int j = 0; j < COLS; j++) {
                Tile tile = row.get(j);
                String display = " ";

                if (j == 0) {
                    display = "Safe";
                } else if (j == COLS - 1) {
                    if (tile.getZombies().size() != 0) {
                        for (Zombie zomb : tile.getZombies()) {
                            display += " " + zomb.getName();
                        }
                    } else {
                        display = "zombie";
                    }

                } else if (i >= POOL_START_ROW && i <= POOL_END_ROW) {
                    display = tile.getPlant() != null ? tile.getPlant().getName()
                            : (tile.canPlant() ? "Land" : "Water");
                } else {
                    display = tile.getPlant() != null ? tile.getPlant().getName() : "Grass";
                }

                System.out.print(" " + display + " |");
            }
            System.out.println("\n" + rowSeparator);
        }
    }

    public Tile getTile(int row, int col) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            return land.get(row).get(col);
        }
        return null;
    }

    public int setPlant(int row, int col, Plant plant) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Posisi di luar batas map.");
            return 1;
        }

        Tile tile = getTile(row, col);

        // check lilypad
        if (plant instanceof Lilypad && !(tile instanceof PoolArea)) {
            System.out.println("Tanaman lilypad hanya bisa ditanam di petak air.");
            return 1;
        }

        if (tile instanceof PoolArea && plant instanceof Lilypad) {
            if (((PoolArea) tile).isLilypadHere()) {
                System.out.println("Sudah ada lilypad di petak ini.");
                return 1;
            }
            ((PoolArea) tile).setLilypadHere(true);
            System.out.println(
                    "Tanaman " + plant.getClass().getSimpleName() + " berhasil diletakkan di (" + row + ", " + col
                            + ").");
            return 0;
        }
        if (!tile.canPlant()) {
            System.out.println("Tidak dapat menanam di petak ini.");
            return 1;
        }

        if (tile.getPlant() != null) {
            System.out.println("Sudah ada tanaman di petak ini.");
            return 1;
        }

        tile.setPlant(plant);
        System.out.println("Tanaman " + plant.getClass().getSimpleName() + " berhasil ditanam di (" + row + ", " + col
                + ").");
        return 0;
    }

    public void removePlant(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Posisi di luar batas map.");
            return;
        }

        Tile tile = getTile(row, col);
        if (tile == null) {
            System.out.println("Petak tidak ditemukan.");
            return;
        }

        if (tile.getPlant() == null) {
            System.out.println("Tidak ada tanaman di petak ini.");
            return;
        }

        tile.removePlant();
        System.out.println("Tanaman di (" + row + ", " + col + ") berhasil dihapus.");
    }

    public void zombie(int row, int col, Zombie zomb) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Posisi di luar batas map.");
            return;
        }

        Tile tile = getTile(row, col);
        try {
            tile.addZombie(zomb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Zombie  " + zomb.getName() + " muncul di (" + row + ", " + col
                + ").");
    }

    public int hitungZombie() {
        int jumlah = 0;
        for (int i = 0; i < land.size(); i++) {
            ArrayList<Tile> row = land.get(i);
            for (int j = 0; j < row.size(); j++) {
                Tile tile = row.get(j);
                jumlah += tile.getZombies().size();
            }
        }
        return jumlah;
    }
}