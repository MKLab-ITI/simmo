package gr.iti.mklab.simmo.core.util;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.utils.IndexDirection;

/**
 * A Location utility class
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
@Embedded
public class Location {

    /**
     * IMPORTANT: Do not change this or split the array into two doubles, longitude and latitude.
     * It is necessary for morphia to do GEO indexing.
     */
    @Indexed(IndexDirection.GEO2D)
    @Property
    private double[] coordinates = new double[2];

    private String country;

    private String city;

    private String address;

    private double radius;

    private double[][] bbox;

    private boolean inferred;

    public Location(){

    }

    public Location(double latitude, double longitude){

        coordinates[0] = latitude;
        coordinates[1] = longitude;
    }

    public double[] getCoordinates(){
        return coordinates;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double[][] getBbox() {
        return bbox;
    }

    public void setBbox(double[][] bbox) {
        this.bbox = bbox;
    }

    public boolean isInferred() {
        return inferred;
    }

    public void setInferred(boolean inferred) {
        this.inferred = inferred;
    }
}
