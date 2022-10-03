package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This is the driver class for this application
 */
public class iCatchUp {
    // Store maps reference
    private static Application maps;
    // Store safari reference
    private static Application safari;

    /**
     * start the application
     */
    public static void main(String[] args) {
        maps = new Maps();
        safari = new Safari();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the iPhony pocket telegraph simulator. You are on the home screen.");
        while (true) {
            printMenu();
            System.out.print("Please select an option: ");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("s")) {
                safari.readCommand(scanner);
            } else if (line.equalsIgnoreCase("m")) {
                maps.readCommand(scanner);
            } else if (line.equalsIgnoreCase("q")) {
                break;
            } else {
                System.out.println("Invalid input please try again!");
            }
        }
        System.out.println("Sorry to see you go, tell the iPod I said hi!");
    }

    /**
     * Switch maps screen from safari screen
     * @param scanner scanner reference
     */
    public static void switchToMap(Scanner scanner)
    {
        maps.readCommand(scanner);
    }

    /**
     * Switch safari screen from maps screen
     * @param scanner scanner reference
     */
    public static void switchToSafari(Scanner scanner)
    {
        safari.readCommand(scanner);
    }

    /**
     * Print the menu
     */
    private static void printMenu()
    {
        System.out.println("Home Options:");
        System.out.println("\tS) Safari");
        System.out.println("\tM) Maps");
        System.out.println("\tQ) Quit");
    }
}
