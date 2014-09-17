package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.items.Media;

import java.util.List;

/**
 * Image Data Access Object
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class MediaDAO<M extends Media> extends ObjectDAO<M> {


    public MediaDAO(Class<M> clazz) {
        super(clazz);
    }

    /**
     * Returns a list of media items that are geographically near the specified coordinates
     * @param latitude
     * @param longitude
     * @param numImages
     * @return
     */
    public List<M> findNear(double latitude, double longitude, int numImages) {
        return getDatastore().find(clazz).field("location.coordinates").near(latitude, longitude).limit(numImages).asList();
    }
}
