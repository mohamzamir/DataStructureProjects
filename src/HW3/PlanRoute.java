package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;
/**
 * This class represent the 'P: Plan a route' command for the Maps app
 */
public class PlanRoute implements Command {
    // store source
    private String source;
    // store destination
    private String destination;

    /**
     * Constructor for PlanRoute
     * @param scanner used to ask input from user
     */
    public PlanRoute(Scanner scanner) {
        while (true) {
            System.out.print("Please enter a source: ");
            source = scanner.nextLine();
            if (source.isBlank())
                System.out.println("Invalid, source can't be empty");
            else
                break;
        }

        while (true) {
            System.out.print("Please enter a destination: ");
            destination = scanner.nextLine();
            if (destination.isBlank())
                System.out.println("Invalid, destination can't be empty");
            else
                break;
        }
    }

    /**
     * accessors method for source
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * accessors method for destination
     * @return destination
     */
    public String getDestination() {
        return destination;
    }
    /**
     * get command can push in stack or not
     * @param stack Command Stack reference
     * @return if command can push in stack then return true otherwise false
     */
    @Override
    public boolean validCommand(CommandStack stack) {
        //if (stack.peek() instanceof StartNavigation)
        //  return false;
        //else
        return true;
    }

    /**
     * String representation of this Command in short form (for stack display)
     * @return Command in short form
     */
    @Override
    public String toShortString() {
        return "P:" + source + "-" + destination;
    }

    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    @Override
    public String toString() {
        return "Planning route from " + source + " to " + destination;
    }
}
