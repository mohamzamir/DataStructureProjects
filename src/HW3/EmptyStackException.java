package HW3;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * This class is used for throw exception if stack is empty then throw the exception
 */
public class EmptyStackException extends Exception{
    public EmptyStackException (String m)
    {
        super(m);
    }
}
