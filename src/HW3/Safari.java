package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This class represent the Safari screen (Safari Application)
 */
public class Safari extends Application {

    /**
     * read input from user
     * @param scanner Reference of scanner class
     */
    @Override
    public void readCommand(Scanner scanner) {
        // loop until user like to go main screen
        while (true)
        {
            System.out.println("Stack Debug:");
            System.out.print("[Home->SafariHome"+stack+"\n");
            try {
                if (stack.isEmpty())
                    System.out.println("Current Screen: Safari Home");
                else
                    System.out.println("Current Screen: "+stack.peek());
            } catch (EmptyStackException e) {

            }
            printMenu();
            System.out.print("Please select an option: ");
            String line = scanner.nextLine();
            try {
                if (line.equalsIgnoreCase("g")) {
                    stack.push(new GoogleSomething(scanner));
                } else if (line.equalsIgnoreCase("f")) {
                    stack.push(new GoToBookmark(scanner));
                } else if (line.equalsIgnoreCase("l")) {
                    stack.push(new FollowLink(scanner));
                } else if (line.equalsIgnoreCase("h")) {
                    break;
                } else if (line.equalsIgnoreCase("s")) {
                    iCatchUp.switchToMap(scanner);
                    break;
                } else if (line.equalsIgnoreCase("b")) {
                    if (stack.isEmpty())
                        break;
                    goBack();
                }
                else {
                    System.out.println("Invalid input please try again!");
                    continue;
                }

            } catch (InvalidCommandException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Print the menu
     */
    private void printMenu() {
        System.out.println("Safari Options:");
        System.out.println("\tG) Google Something");
        System.out.println("\tF) Go to a favorite (bookmark)");
        System.out.println("\tL) Follow a link");
        System.out.println("\tH) Home Screen");
        System.out.println("\tS) Switch to Maps");
        System.out.println("\tB) Back");
    }

    /**
     * go back from current screen
     */
    @Override
    public void goBack() {
        try {
            stack.pop();
        } catch (EmptyStackException e) {

        }
    }
}
