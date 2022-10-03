package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * This class is used for throw exception if command can't push in stack then throw the exception
 */
public class InvalidCommandException extends Exception{
    public InvalidCommandException (String m)
    {
        super(m);
    }
}
