import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * S. Azra Banu - shared input validation used by every menu.
 */
public class InputHelper {
    private static final Scanner SCANNER = new Scanner(System.in);

    /** Keeps asking until the user enters a whole number between min and max. */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line;
            try {
                line = SCANNER.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.println("\nInput closed. Exiting.");
                System.exit(0);
                return 0;
            }
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("  ! Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  ! Invalid input. Please enter a whole number.");
            }
        }
    }

    public static int readInt(String prompt) {
        return readInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
