package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Scanner;

/**
 * This is an abstract class, it is a parent class of Maps and Safari
 * This class has CommandStack for store every command in Application
 */
public abstract class Application {
    // Store command in stack
    protected CommandStack stack = new CommandStack();

    /**
     * Read input from user and add command for input
     * @param scanner Reference of scanner class
     */
    public abstract void readCommand(Scanner scanner);

    /**
     * Go back from current screen (when user enter 'B')
     */
    public abstract void goBack();
}


