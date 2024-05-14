package pvz.main;

import java.util.Scanner;

public class ScannerUtil {
    private static Scanner scanner;

    private ScannerUtil() {
        // Private constructor to prevent instantiation
    }

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
