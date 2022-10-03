package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Stack;

/**
 * This class is used for store Command in stack
 */
public class CommandStack {
    // Store command in java prebuilt stack
    private Stack<Command> stack = new Stack<>();


    /**
     * Push command in stack
     * @param command New command reference
     * @throws InvalidCommandException if Command can't be place in stack then throw InvalidCommandException
     * @throws NullPointerException if Command is null then throw NullPointerException
     */
    public void push(Command command) throws InvalidCommandException, NullPointerException {
        if (command==null)
            throw new NullPointerException("Command is null");
        if (!command.validCommand(this)) {
            throw new InvalidCommandException("Can't push command on stack");
        }
        stack.push(command);
    }

    /**
     * Pop command in stack (remove Command from stack)
     * @return pop Command
     * @throws EmptyStackException if Command Stack is empty then throw the EmptyStackException
     */
    public Command pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Command stack is empty");
        return stack.pop();
    }

    /**
     * get top Command in stack without removing command
     * @return peek command
     * @throws EmptyStackException if Command Stack is empty then throw the EmptyStackException
     */
    public Command peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Command stack is empty");
        return stack.peek();
    }

    /**
     * get stack is empty or not
     * @return if stack is empty then return true else return false
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * get current screen command
     * @return current screen command
     * @throws EmptyStackException if stack is empty then return true else return false
     */
    public String getScreenCommand() throws EmptyStackException {
        return peek().toString();
    }

    /**
     * get Command stack in given format (for printing purpose)
     * @return command stack in given format
     */
    public String toString() {
        String text = "";
        for (Command command : stack) {
            text += "->" + command.toShortString();
        }
        return text;
    }
}
