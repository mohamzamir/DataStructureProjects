package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This class represent the 'F: Find a place' command for the Maps app
 */
public class FindPlace implements Command{
    // store destination name
    private String destination;

    /**
     * Constructor for FindPlace
     * @param scanner used to ask input from user
     */
    public FindPlace(Scanner scanner) {
        while (true) {
            System.out.print("Please enter a location: ");
            destination = scanner.nextLine();
            if (destination.isBlank())
                System.out.println("Invalid, destination can't be empty");
            else
                break;
        }
    }

    /**
     * get command can push in stack or not
     * @param stack Command Stack reference
     * @return if command can push in stack then return true otherwise false
     */
    @Override
    public boolean validCommand(CommandStack stack)  {
             return true;
    }

    /**
     * accessors method for destination
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * String representation of this Command in short form (for stack display)
     * @return Command in short form
     */
    @Override
    public String toShortString() {
        return "F: "+destination;
    }

    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    @Override
    public String toString() {
        return "Showing results for "+destination;
    }
}
