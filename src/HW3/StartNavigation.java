package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * This class represent the 'N: Start Navigation' command for the Maps app
 */
public class StartNavigation implements Command{
    // store source
    private String source;
    // store destination
    private String destination;

    /**
     * Constructor for PlanRoute
     * @param stack reference for command stack
     */
    public StartNavigation(CommandStack stack) {
        if (!stack.isEmpty()) {
            try {
                if (stack.peek() instanceof FindPlace) {
                    destination = ((FindPlace) stack.peek()).getDestination();
                } else if (stack.peek() instanceof PlanRoute) {
                    source = ((PlanRoute) stack.peek()).getSource();
                    destination = ((PlanRoute) stack.peek()).getDestination();
                }
                stack.push(this);
            } catch (EmptyStackException e) {
                System.out.println("Command Stack is empty");
            } catch (InvalidCommandException e) {
                System.out.println("Invalid Command");
            }
        } else {
            System.out.println("No route or destination!");
        }
    }


    /**
     * get command can push in stack or not (if stack is empty or last screen is StartNavigation then can't be push into stack)
     * @param stack Command Stack reference
     * @return if command can push in stack then return true otherwise false
     */
    @Override
    public boolean validCommand(CommandStack stack) {
        try {
            if (stack.isEmpty())
                return false;
            if (stack.peek() instanceof StartNavigation)
                return false;
        }catch (NullPointerException e)
        {
            System.out.println("Stack is null");
        }catch (EmptyStackException e)
        {
            System.out.println("Stack is empty");
        }

        return true;
    }

    /**
     * String representation of this Command in short form (for stack display)
     * @return Command in short form
     */
    @Override
    public String toShortString() {

        if (source!=null&&destination!=null)
        {
            return  "N:"+source+"-"+destination;
        }
        else if (source!=null)
        {
            return  "N:"+source;
        }
        else if (destination!=null)
        {
            return  "N:"+destination;
        }
        return "";
    }
    /**
     * String representation of this Command in long form (for current screen display)
     * @return Command in long form
     */
    @Override
    public String toString() {
        if (source!=null&&destination!=null)
        {
            return  "Navigating from "+source+" to "+destination;
        }
        return "Navigating to "+destination;
    }
}
