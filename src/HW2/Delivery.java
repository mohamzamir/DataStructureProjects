package HW2;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * This is a class named "Deliver" which contains source, destination and instruction for delivery.
 * There are getter and setter method for this class.
 */

public class Delivery  {
    private String source;
    private String dest;
    private String instruction;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest){
        this.dest = dest;
    }

    public String getInstruction(){
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * This is a constructor used to create Delivery object
     * @param source
     * This collects the source of the delivery
     * @param dest
     * this collects the destination of the delivery
     * @param instruction
     * this collects the instruction for the delivery
     */

    public Delivery(String source, String dest, String instruction) {
        this.source = source;
        this.dest = dest;
        this.instruction = instruction;
    }

    /**
     * This a toString method which returns the data members representation of Delivery
     * @return
     */

    public String toString() {
        return "To: " + getDest() + " | " + "From: " + getSource() +"\n" + "Instruction: " + getInstruction();
    }
}
