package pvz.main;

import java.util.HashMap;
import java.util.Map;

public class Save {
    private static Save instance;

    private Map<String, Game> savedGames = new HashMap<>();

    private Save() {

    }

    public static Save getInstance() {
        if (instance == null) {
            instance = new Save();
        }
        return instance;
    }

    public static void addSaved(String name, Game game) {
        getInstance().savedGames.put(name, game);
    }

    public static Game getSaved(String name) {
        return getInstance().savedGames.get(name);
    }

    public static void removeSaved(String name) {
        getInstance().savedGames.remove(name);
    }

    public static int getSavedSize() {
        return getInstance().savedGames.size();
    }

    public static void printSaved() {
        System.out.println("Saved Games:");
        for (String name : getInstance().savedGames.keySet()) {
            System.out.println("- " + name);
        }
    }

    public static boolean isSaved(String name) {
        return getInstance().savedGames.containsKey(name);
    }
}
