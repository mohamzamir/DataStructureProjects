package HW6;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Comparator;

/**
 * This class is used for sort Storm by WindSpeed
 */
public class WindSpeedComparator implements Comparator<Storm> {
    @Override
    public int compare(Storm left, Storm right) {
        if (left.getWindspeed() < right.getWindspeed())
            return -1;
        if (left.getWindspeed() == right.getWindspeed())
            return 0;
        return 1;
    }
}
