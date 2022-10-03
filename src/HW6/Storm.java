package HW6;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.io.Serializable;

/**
 * This class represent the Storm
 */
public class Storm implements Serializable {
    // Store storm name
    private String name;
    // Store storm precipitation (rain)
    private double precipitation;
    // Store storm windspeed
    private double windspeed;
    // Store storm date
    private String date;

    /**
     * Constructor for initialize fields
     * @param name storm name
     * @param precipitation storm precipitation
     * @param windspeed storm windspeed
     * @param date storm date
     */
    public Storm(String name, double precipitation, double windspeed, String date) {
        this.name = name;
        this.precipitation = precipitation;
        this.windspeed = windspeed;
        this.date = date;
    }

    /**
     * get method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for name
     * @param name storm name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get method for precipitation
     * @return precipitation
     */
    public double getPrecipitation() {
        return precipitation;
    }

    /**
     * set method for precipitation
     * @param precipitation storm precipitation
     */
    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * get method for windspeed
     * @return windspeed
     */
    public double getWindspeed() {
        return windspeed;
    }

    /**
     * set method for windspeed
     * @param windspeed storm wind speed
     */
    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    /**
     * get method for date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * set method for date
     * @param date storm date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
