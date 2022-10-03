package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * Command to represent each command entered on the phone app
 */
public interface Command {
    /**
     * Check command can be place on the stack
     * @param stack Command Stack reference
     * @return if command can place in stack then return true otherwise return false
     */
    boolean validCommand(CommandStack stack);

    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    String toString();

    /**
     * String representation of this Command in short form (for stack display)
     * @return Command in short form
     */
    String toShortString();
}
