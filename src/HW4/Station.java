package HW4;

import java.util.Scanner;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * A documented class which simulates the station
 */
public class Station {

    private PassengerQueue firstClass;
    private PassengerQueue secondClass;
    private BooleanSource firstArrival;
    private BooleanSource secondArrival;

    /**
     * Default constructor
     */

    public Station() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter first class arrival probability: ");
        double f = sc.nextDouble();
        sc.nextLine();
        System.out.print("Please enter second class arrival probability: ");
        double s = sc.nextDouble();
        sc.nextLine();
        firstArrival = new BooleanSource(f);
        secondArrival = new BooleanSource(s);

    }


    /**
     * A method which handles the arrival of passengers
     */

    public void simulateTimeStep()
    {
        firstClass = new PassengerQueue();
        secondClass = new PassengerQueue();
        if (firstArrival.occurs()) {
            LIRRSimulator.passengerId++;

            System.out.println("First class passenger ID " + LIRRSimulator.passengerId + " arrives");
            Passenger passenger = new Passenger();
            passenger.setId(LIRRSimulator.passengerId);
            passenger.setFirstClass(true);
            passenger.setArrivalTime(LIRRSimulator.time);
            firstClass.enqueue(passenger);


        }
        else
        {
            System.out.println("No first class passenger arrives");
        }

        if (secondArrival.occurs()) {

            LIRRSimulator.passengerId++;
            System.out.println("Second class passenger ID "+ LIRRSimulator.passengerId +" arrives");
            Passenger passenger = new Passenger();
            passenger.setId(LIRRSimulator.passengerId);
            passenger.setArrivalTime(LIRRSimulator.time);
            secondClass.enqueue(passenger);

        }
        else
        {
            System.out.println("No second class passenger arrives");
        }
        System.out.println("Queues:\n"+ "First " + firstClass.toString()+"\n"+ "Second " + secondClass.toString());

    }

}
