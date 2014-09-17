package gr.iti.mklab.simmo.morphia;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import gr.iti.mklab.simmo.Object;

import java.util.Date;
import java.util.List;

/**
 * A generic Object DAO with helper methods available to all subclasses
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 17, 2014
 */
public class ObjectDAO<O extends Object> extends BasicDAO<O, ObjectId> {

    protected Class<O> clazz;

    public ObjectDAO(Class<O> clazz) {
        super(clazz, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB().getName());
        this.clazz = clazz;
    }

    /**
     * A private helper method that can be applied to "creationDate", "crawledDate", "lastModifiedDate".
     * For usage sample see the methods below
     *
     * @param dateField
     * @param start
     * @param end
     * @param numImages
     * @param asc
     * @return
     */
    private List<O> findByDate(String dateField, Date start, Date end, int numImages, boolean asc) {
        if (start == null)
            start = new Date(0);
        if (end == null)
            end = new Date();
        return getDatastore().find(clazz).filter(dateField + " >", start).filter(dateField + " <", end).limit(numImages).order(asc ? dateField : '-' + dateField).asList();
    }

    /**
     * Returns a list of images crawled before the specified date
     * It returns by default the first 100 images in ascending order
     *
     * @param end
     * @return
     */
    public List<O> crawledBefore(Date end) {
        return findByDate("crawlDate", null, end, 100, true);
    }

    /**
     * Returns a list of images crawled after the specified date
     * It returns by default the first 100 images in ascending order
     *
     * @param start
     * @return
     */
    public List<O> crawledAfter(Date start) {
        return findByDate("crawlDate", start, null, 100, true);
    }

    /**
     * Returns a list of images created in the time period specified by start and end
     *
     * @param start
     * @param end
     * @param numImages
     * @return
     */
    public List<O> createdInPeriod(Date start, Date end, int numImages){
        return findByDate("creationDate", start, end, numImages, true);
    }

}
