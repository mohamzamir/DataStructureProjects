package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This class represent the 'G: Google something' command for the Safari app
 */
public class GoogleSomething implements Command{
    // store query
    private String query;

    /**
     * Constructor for GoogleSomething
     * @param scanner used to ask input from user
     */
    public GoogleSomething (Scanner scanner) {
        while (true) {
            System.out.print("Please enter a query: ");
            query = scanner.nextLine();
            if (query.isBlank())
                System.out.println("Invalid, query can't be empty");
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
    public boolean validCommand(CommandStack stack) {

        return true;
    }

    /**
     * String representation of this Command in short form (for stack display)
     * @return Command in short form
     */
    @Override
    public String toShortString() {
        return "G:"+query;
    }
    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    @Override
    public String toString() {
        return "Google: "+query;
    }
}
