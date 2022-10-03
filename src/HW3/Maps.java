package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This class represent the Maps screen (Maps Application)
 */
public class Maps extends Application{

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
            System.out.print("[Home->MapsHome"+stack+"\n");
            try {
                if (stack.isEmpty())
                    System.out.println("Current Screen: Maps Home");
                else
                    System.out.println("Current Screen: "+stack.peek());
            } catch (EmptyStackException e) {

            }
            printMenu();
            System.out.print("Please select an option: ");
            String line = scanner.nextLine();
            try {
                if (line.equalsIgnoreCase("f")) {
                    stack.push(new FindPlace(scanner));
                } else if (line.equalsIgnoreCase("p")) {
                    stack.push(new PlanRoute(scanner));
                } else if (line.equalsIgnoreCase("n")) {
                    new StartNavigation(stack);
                } else if (line.equalsIgnoreCase("h")) {
                    break;
                } else if (line.equalsIgnoreCase("s")) {
                    iCatchUp.switchToSafari(scanner);
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
        System.out.println("Maps Options:");
        System.out.println("\tF) Find a place");
        System.out.println("\tP) Plan a route");
        System.out.println("\tN) Start Navigation");
        System.out.println("\tH) Home Screen");
        System.out.println("\tS) Switch to Safari");
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
