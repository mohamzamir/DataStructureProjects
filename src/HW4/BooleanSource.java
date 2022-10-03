package HW4;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * A class where a probability of p between 0 and 1 and then the method return p*100% of the time
 */

public class BooleanSource {
    private double probability;

    public BooleanSource(double p) {
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException();
        this.probability = p;
    }

    public boolean occurs() {
        return (Math.random()<probability);
    }
}
