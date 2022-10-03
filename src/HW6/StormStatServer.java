package HW6;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is a Main class
 */
public class StormStatServer {
    // Store storm in hashmap
    private static HashMap<String,Storm> database;
    // Store scanner
    private static Scanner sc;


    /**
     * main method for this program
     */
    public static void main(String[] args) {
        database = new HashMap<>();
        System.out.println("Welcome to the StormStatServer, we may not be able to make it rain, but we sure can tell you when it happened!");
        loadFromFile();
        printMenu();
        sc = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.print("Please select an option: ");
            String input = sc.nextLine();
            switch (input.toUpperCase()) {
                case "A":
                    addStorm();
                    break;
                case "L":
                    lookUpStorm();
                    break;
                case "D":
                    deleteStorm();
                    break;
                case "E":
                    editStorm();
                    break;
                case "R":
                    try {
                        printStormSortedByRainfall();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "W":
                    try {
                        printStormSortedByWindSpeed();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "X":
                    saveAndQuit();
                    isExit = true;
                    break;
                case "Q":
                    System.out.println("Goodbye, it's hard to hold an (electric) candle in the cold November (and April!) rain!");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    /**
     * load file and initialize database at the beginning of the program
     */
    private static void loadFromFile()
    {
        try {
            FileInputStream file = new FileInputStream("hurricane.ser");
            ObjectInputStream inStream = new ObjectInputStream(file);
            database= (HashMap<String, Storm>) inStream.readObject();
            System.out.println("hurricane.ser was found and loaded.");
            inStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Something went wrong!");
        }

    }

    /**
     * Save all data into file (hurricane.ser)
     */
    private static void saveAndQuit() {
        try {
            FileOutputStream file = new FileOutputStream("hurricane.ser");
            ObjectOutputStream outStream = new ObjectOutputStream(file);
            outStream.writeObject(database);
            outStream.close();
            System.out.println("File saved to hurricane.ser; feel free to use the weather channel in the meantime.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    /**
     * Print storm, sorted by wind speed
     */
    private static void printStormSortedByWindSpeed() throws NumberFormatException{
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Name", "Windspeed", "Rainfall", "Date");
        System.out.println("----------------------------------------------------------");
        if (database == null)
            throw new NullPointerException("Database is null.");
        ArrayList<Storm> storms = new ArrayList<>(database.values());
        Collections.sort(storms, new WindSpeedComparator());
        for (Storm value : storms) {
            System.out.printf("%-15s %-15s %-15s %-15s%n", value.getName(), value.getWindspeed(), value.getPrecipitation(), value.getDate());
        }
    }

    /**
     * Print storm, sorted by Rainfall (Precipitation)
     */
    private static void printStormSortedByRainfall() throws NumberFormatException{
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Name", "Windspeed", "Rainfall", "Date");
        System.out.println("----------------------------------------------------------");
        if (database == null)
            throw new NullPointerException("Database is null");
        ArrayList<Storm> storms = new ArrayList<>(database.values());
        Collections.sort(storms, new PrecipitationComparator());
        for (Storm value : storms) {
            System.out.printf("%-15s %-15s %-15s %-15s%n", value.getName(), value.getWindspeed(), value.getPrecipitation(), value.getDate());
        }
    }

    /**
     * Edit given storm details
     */
    private static void editStorm() {
        System.out.print("Please enter name: ");
        String name = getStringInput().toUpperCase();
        if (!database.containsKey(name)) {
            System.out.println("Key not found.");
            return;
        }
        System.out.println("In Edit Mode, press enter without any input to leave data unchanged.");
        Storm storm = database.get(name);
        System.out.print("Please enter date: ");
        String date = sc.nextLine();
        if (!date.isBlank()) {
            if (!checkDateFormat(date)) {
                System.out.println("Invalid date format.");
                return;
            }
            storm.setDate(date);
        }

        System.out.print("Please enter precipitation (cm): ");
        String precTxt = sc.nextLine();
        if (!precTxt.isBlank()) {
            if (!checkValidDouble(precTxt)) {
                System.out.println("Invalid precipitation format.");
                return;
            }
            double precipitation = Double.parseDouble(precTxt);
            storm.setPrecipitation(precipitation);
        }

        System.out.print("Please enter windspeed (km/h): ");
        String windTxt = sc.nextLine();
        if (!windTxt.isBlank()) {
            if (!checkValidDouble(windTxt)) {
                System.out.println("Invalid windspeed format.");
                return;
            }
            double wind = Double.parseDouble(windTxt);
            storm.setWindspeed(wind);
        }
        System.out.println(name + " added.");
    }

    /**
     * check given string is valid double or not
     * @param txt given text
     * @return true if text is double otherwise return false
     */
    private static boolean checkValidDouble(String txt) {
        try {
            double v = Double.parseDouble(txt);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * check given string is valid date or not
     * @param txt given text
     * @return true if text is date otherwise return false
     */
    private static boolean checkDateFormat(String txt) {
        String DATE_FORMAT = "yyyy-MM-dd";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);

            df.parse(txt);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * delete given storm
     */
    private static void deleteStorm() {
        System.out.print("Please enter name: ");
        String name = getStringInput().toUpperCase();
        if (!database.containsKey(name)) {
            System.out.println("Storm " + name + " does not exist.");
            return;
        }
        database.remove(name);
        System.out.println("Storm " + name + " has been deleted.");
    }

    /**
     * look up storm by name
     */
    private static void lookUpStorm() {
        System.out.print("Please enter name: ");
        String input = getStringInput().toUpperCase();
        if (!database.containsKey(input)) {
            System.out.println("Key not found.");
            return;
        }

        Storm storm = database.get(input);
        System.out.println("Storm " + storm.getName() + ": Date " + storm.getDate() + ", " + storm.getWindspeed() + " km/h winds, " + storm.getPrecipitation() + " cm of rain");
    }

    /**
     * add new storm
     */
    private static void addStorm() {
        System.out.print("Please enter name: ");
        String name = getStringInput().toUpperCase();
        System.out.print("Please enter date: ");
        String date = getDateInput();
        System.out.print("Please enter precipitation (cm): ");
        double precipitation = getDoubleInput();
        System.out.print("Please enter windspeed (km/h): ");
        double windspeed = getDoubleInput();
        Storm storm = new Storm(name, precipitation, windspeed, date);
        if (date.contains(name)) {
            System.out.println("Can't add name already exist!");
            return;
        }
        database.put(storm.getName(), storm);
        System.out.println(name + " addedd.");
    }

    /**
     * get valid string input from user
     * @return user input
     */
    private static String getStringInput()
    {
        while (true)
        {
            String v = sc.nextLine();
            if (v.isBlank())
            {
                System.out.print("Invalid input please re enter: ");
                continue;
            }
            return v;
        }
    }

    /**
     * get valid date input from user
     * @return user input
     */
    private static String getDateInput() {
        while (true) {
            String v = sc.nextLine();
            if (!checkDateFormat(v)) {
                System.out.print("Invalid input please re enter: ");
                continue;
            }
            return v;
        }
    }

    /**
     * get valid double input from user
     * @return user input
     */
    private static double getDoubleInput()
    {
        while (true)
        {
            try {
                double v = sc.nextDouble();
                sc.nextLine();
                return v;
            }
            catch (InputMismatchException e)
            {
                sc.nextLine();
                System.out.print("Invalid input please re-enter: ");
            }

        }
    }

    /**
     * print all menu
     */
    private static void printMenu()
    {
        System.out.println("Menu:");
        System.out.println("\tA) Add A Storm");
        System.out.println("\tL) Look Up A Storm");
        System.out.println("\tD) Delete A Storm");
        System.out.println("\tE) Edit A Storm");
        System.out.println("\tR) Print Storms by Rainfall");
        System.out.println("\tW) W-Print Storms by Windspeed");
        System.out.println("\tX) Save and quit");
        System.out.println("\tQ) Quit and delete saved data");
    }
}
