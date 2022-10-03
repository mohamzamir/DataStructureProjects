package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This class represent the 'F: Go to favorite/bookmark' command for the Safari app
 */
public class GoToBookmark implements Command {
    // store bookmark
    private String bookmark;

    /**
     * Constructor for GoToBookmark
     * @param scanner used to ask input from user
     */
    public GoToBookmark(Scanner scanner) {
        while (true) {
            System.out.print("Please enter bookmark name: ");
            bookmark = scanner.nextLine();
            if (bookmark.isBlank())
                System.out.println("Invalid, bookmark can't be empty");
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
        return "F:" + bookmark;
    }

    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    @Override
    public String toString() {
        return "Safari Home";
    }
}
