package gr.iti.mklab.simmo.core.morphia;

import gr.iti.mklab.simmo.core.annotations.Clustered;
import gr.iti.mklab.simmo.core.annotations.lowleveldescriptors.LocalDescriptors;
import gr.iti.mklab.simmo.core.items.Media;
import org.mongodb.morphia.query.Query;

import java.util.Date;
import java.util.List;

/**
 * Image Data Access Object
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class MediaDAO<M extends Media> extends ObjectDAO<M> {


    public MediaDAO(Class<M> clazz, String dbName) {
        super(clazz, dbName);
    }

    /**
     * Returns a list of media items that are geographically near the specified coordinates
     *
     * @param latitude
     * @param longitude
     * @param numImages
     * @return
     */
    public List<M> findNear(double latitude, double longitude, int numImages) {
        return getDatastore().find(clazz).field("location.coordinates").near(latitude, longitude).limit(numImages).asList();
    }

    /**
     * A search function
     *
     * @param date
     * @param width
     * @param height
     * @param count
     * @param offset
     * @return
     */
    public List<M> search(String datefield, Date date, int width, int height, int count, int offset) {
        return getDatastore().find(clazz).filter(datefield + " >", date).filter("width" + " >", width).
                filter("height" + " >", height).offset(offset).limit(count).asList();
    }

    public List<M> getNotVIndexed(int numImages) {
        //Disable validation because className is not a declared field
        return getDatastore().find(clazz).disableValidation().filter("annotations.className nin", LocalDescriptors.class.getName()).limit(numImages).asList();
    }

    public List<M> getIndexedNotClustered(int numImages) {
        //Disable validation because className is not a declared field
        return getDatastore().find(clazz).disableValidation().filter("annotations.className in", LocalDescriptors.class.getName()).
                filter("annotations.className nin", Clustered.class.getName()).limit(numImages).asList();
    }
}
