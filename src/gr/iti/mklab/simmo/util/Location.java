package gr.iti.mklab.simmo.util;

/**
 * A Location utility class
 *
 * @author kandreadou
 * @version 1.0.0
 * @since July 3, 2014
 */
public class Location {

    private long latitude;

    private long longitude;

    private String country;

    private String city;

    private String adress;

    private double radius;

    private double[][] bbox;

    private boolean inferred;

    public Location(long longitude, long latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
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
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
