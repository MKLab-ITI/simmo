package gr.iti.mklab.simmo.core.morphia;

import gr.iti.mklab.simmo.core.UserAccount;
import gr.iti.mklab.simmo.core.annotations.Clustered;
import gr.iti.mklab.simmo.core.annotations.lowleveldescriptors.LocalDescriptors;
import gr.iti.mklab.simmo.core.items.Image;
import gr.iti.mklab.simmo.core.items.Media;
import org.mongodb.morphia.query.Query;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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

    @Override
    public List<M> getItems(int count, int offset) {
        return getDatastore().find(clazz).order("crawlDate").offset(offset).limit(count).asList();
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
    public List<M> search(String datefield, Date date, int width, int height, int count, int offset, UserAccount account, String query) {
        if (date == null)
            date = new Date(0);
        Query<M> q;
        if (query != null && account != null) {
            Pattern p = Pattern.compile("(.*)" + query + "(.*)", Pattern.CASE_INSENSITIVE);
            q = getDatastore().createQuery(clazz);
            q.and(
                    q.criteria(datefield).greaterThanOrEq(date),
                    q.criteria("width").greaterThanOrEq(width),
                    q.criteria("height").greaterThanOrEq(height),
                    q.criteria("contributor").equal(account),
                    q.or(
                            q.criteria("title").equal(p),
                            q.criteria("description").equal(p)
                    )
            );
        } else if (query == null && account != null) {
            q = getDatastore().createQuery(clazz);
            q.and(
                    q.criteria(datefield).greaterThanOrEq(date),
                    q.criteria("width").greaterThanOrEq(width),
                    q.criteria("height").greaterThanOrEq(height),
                    q.criteria("contributor").equal(account)
            );
        } else if (query != null && account == null) {
            Pattern p = Pattern.compile("(.*)" + query + "(.*)", Pattern.CASE_INSENSITIVE);
            q = getDatastore().createQuery(clazz);
            q.and(
                    q.criteria(datefield).greaterThanOrEq(date),
                    q.criteria("width").greaterThanOrEq(width),
                    q.criteria("height").greaterThanOrEq(height),
                    q.or(
                            q.criteria("title").equal(p),
                            q.criteria("description").equal(p)
                    )
            );
        } else {
            q = getDatastore().createQuery(clazz);
            q.and(
                    q.criteria(datefield).greaterThanOrEq(date),
                    q.criteria("width").greaterThanOrEq(width),
                    q.criteria("height").greaterThanOrEq(height)
            );
        }

        return q.order("crawlDate").offset(offset).limit(count).asList();
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
