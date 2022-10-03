package HW4;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/*
A class which contains an integer id, arrivalTime and a boolean
 */
public class Passenger {
    private int id;
    private int arrivalTime;
    private boolean isFirstClass;

    /*
    A default passenger constructor
     */

    public Passenger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }
}
