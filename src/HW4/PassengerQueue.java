package HW4;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.ArrayList;

/*
A class called PassengerQueue that has all the regular queue methods
 */

public class PassengerQueue {

    /*
    Store passenger in Java built ArrayList
     */
    public ArrayList <Passenger> passengers;

    public PassengerQueue() {
        passengers = new ArrayList<>();
    }

    /*
    Enqueues the passenger
     */

    public void enqueue(Passenger p) {
        passengers.add(p);
    }

    /**
     * enqueues the passenger in the Arrays
     * @return the removed passenger
     * @throws EmptyQueueException if the passenger is empty
     */

    public Passenger dequeue() throws EmptyQueueException {
        if (passengers.isEmpty())
            throw new EmptyQueueException("Passenger queue is Empty!");
        return passengers.remove(0);
    }

    /**
     * peek the passenger in the list
     * @return the passenger at that index
     * @throws EmptyQueueException if the passenger is empty
     */

    public Passenger peek() throws EmptyQueueException {
        if (passengers.isEmpty())
            throw new EmptyQueueException("Passenger queue is Empty!");
        return passengers.get(0);
    }

    /**
     * A toString method to print
     * @return the required string
     */

    public String toString() {
        if (isEmpty())
            return "[empty]";
        String res="[";//+passengers.get(0).getId();
        for (Passenger i: passengers)//int i = 0; i < passengers.size(); i++) {
            res += "P" + i.getId() + "@T" + i.getArrivalTime() + ", ";//+ passengers.get(i).getId() + "@T" + passengers.get(i).getArrivalTime();
        //}
        return res;
    }




    public boolean isEmpty() {
        return passengers.isEmpty();
    }
}
