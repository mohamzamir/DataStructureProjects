package HW4;

import java.util.*;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * a class which list stations and the ones currently on the line and some global variables for number of passengers served and other statistics
 */

public class LIRRSimulator {
    public static int passengerId = 0;
    public static int time = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly");
        System.out.println("Mineola:");
        Station mineola = new Station();
        System.out.println("Hicksville:");
        Station hicksville = new Station();
        System.out.println("Syosset:");
        Station syosset = new Station();
        System.out.println("Huntington:");
        Station huntington = new Station();

        System.out.print("Please enter first class capacity: ");
        int firstClassCapacity = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter second class capacity: ");
        int secondClassCapacity = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter number of trains: ");
        int noOfTrain = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter last arrival time of passengers: ");
        time = sc.nextInt();
        System.out.println("Begin Simulation:\n" +
                "---------------------------------------------");
        Train[] train = new Train[noOfTrain];

        /**
         * simulates the program
         */

        String[] stat = new String[]{"Mineola:","Hicksville:","Syosset:","Huntington:"};
        for (int k = 0; k < stat.length  ; k++) {
            System.out.println("Time " + k +":");
            System.out.println("Station overview:\n"+ stat[k]);

            for (int i = 0; i < noOfTrain; i++) {
                train[i] = new Train();
                train[i].setFirstCapacity(firstClassCapacity);
                train[i].setSecondCapacity(secondClassCapacity); //= secondClassCapacity;
                ArrayList <Station> stationArrayList = new ArrayList<>();
                stationArrayList.add(mineola);
                stationArrayList.add(hicksville);
                stationArrayList.add(syosset);
                stationArrayList.add(huntington);
                train[i].setStationArrayList(stationArrayList);
                train[i].simulateTimeStep();
            }
            time = time/5;
        }


    }
}
