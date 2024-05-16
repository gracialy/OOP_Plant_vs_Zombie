package pvz.map;

import java.util.ArrayList;
import java.util.Collections;

import pvz.plant.Lilypad;
import pvz.plant.Plant;

public class Map {
    private ArrayList<ArrayList<Tile>> land;
    private final int ROWS = 6;
    private final int COLS = 11;
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
                    display = "Zombie";
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

    public void plant(int row, int col, Plant plant) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Posisi di luar batas map.");
            return;
        }

        Tile tile = getTile(row, col);
        if (tile instanceof PoolArea && plant instanceof Lilypad) {
            ((PoolArea) tile).setLilypadHere(true);
        }
        if (tile == null) {
            System.out.println("Petak tidak ditemukan.");
            return;
        }

        if (!tile.canPlant()) {
            System.out.println("Tidak dapat menanam di petak ini.");
            return;
        }
        if (tile.getPlant() != null) {
            System.out.println("Sudah ada tanaman di petak ini.");
            return;
        }

        try {
            tile.setPlant(plant);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Tanaman " + plant.getClass().getSimpleName() + " berhasil ditanam di (" + row + ", " + col
                + ").");
    }

}