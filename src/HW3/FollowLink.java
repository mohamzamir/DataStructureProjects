package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;
/**
 * This class represent the 'L: FollowLink' command for the Safari app
 */
public class FollowLink implements Command{
    // store link
    private String link;
    /**
     * Constructor for FollowLink
     * @param scanner used to ask input from user
     */
    public FollowLink (Scanner scanner)
    {
        while (true) {
            System.out.print("Please enter a link: ");
            link = scanner.nextLine();
            if (link.isBlank())
                System.out.println("Invalid, link can't be empty");
            else
                break;
        }

    }

    /**
     * get command can push in stack or not (if stack is empty can't be push into stack)
     * @param stack Command Stack reference
     * @return if command can push in stack then return true otherwise false
     */
    @Override
    public boolean validCommand(CommandStack stack) {
        return !stack.isEmpty();
    }

    /**
     * String representation of this Command in short form (for stack display)
     * @return Command in short form
     */
    @Override
    public String toShortString() {
        return "L:"+link;
    }

    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    @Override
    public String toString() {
        return link;
    }
}
