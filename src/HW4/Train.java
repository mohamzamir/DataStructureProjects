package HW4;

import java.util.ArrayList;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * A class to simulate trains
 */

public class Train {

    private int firstCapacity;
    private int secondCapacity;
    private int timeUntilNextArrival;

    /*
    Store Station in Java built ArrayList
     */

    private ArrayList <Station> stationArrayList;

    public Train() {
        stationArrayList = new ArrayList<>();
    }

    /**
     * Update the data at each time stamps and record the passenger coming
     * to the stations and getting aboard on train
     */

    public void simulateTimeStep()
    {
        for (Station s: stationArrayList) {
            s.simulateTimeStep();
        }
    }

    /**
     * Get the first capacity
     */
    public int getFirstCapacity() {
        return firstCapacity;
    }

    /**
     * set the first capacity
     * @param firstCapacity reference
     */

    public void setFirstCapacity(int firstCapacity) {
        this.firstCapacity = firstCapacity;
    }

    /**
     * get the second Capacity
     */
    public int getSecondCapacity() {
        return secondCapacity;
    }

    /**
     * set the second capacity
     * @param secondCapacity reference
     */

    public void setSecondCapacity(int secondCapacity) {
        this.secondCapacity = secondCapacity;
    }

    /*8
    get the time until next arrival
     */

    public int getTimeUntilNextArrival() {
        return timeUntilNextArrival;
    }

    /**
     * Set the time until next arrival
     */

    public void setTimeUntilNextArrival(int timeUntilNextArrival) {
        this.timeUntilNextArrival = timeUntilNextArrival;
    }

    public ArrayList<Station> getStationArrayList() {
        return stationArrayList;
    }

    public void setStationArrayList(ArrayList<Station> stationArrayList) {
        this.stationArrayList = stationArrayList;
    }

}