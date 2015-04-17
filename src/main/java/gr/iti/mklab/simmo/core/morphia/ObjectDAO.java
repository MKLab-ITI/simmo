package gr.iti.mklab.simmo.core.morphia;

import gr.iti.mklab.simmo.core.Association;
import gr.iti.mklab.simmo.core.associations.Similarity;
import gr.iti.mklab.simmo.core.items.Image;
import org.mongodb.morphia.dao.BasicDAO;
import gr.iti.mklab.simmo.core.Object;
import org.mongodb.morphia.query.Query;

import java.util.Date;
import java.util.List;

/**
 * A generic Object DAO with helper methods available to all subclasses
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 17, 2014
 */
public class ObjectDAO<O extends Object> extends BasicDAO<O, String> {

    protected Class<O> clazz;

    public ObjectDAO(Class<O> clazz, String dbName) {
        super(clazz, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB(dbName).getName());
        this.clazz = clazz;
    }

    /**
     * A helper method used for paging
     * Example: for offset=5 and count=10, this method will return items 5 to 15
     *
     * @param count,  the number of items to retrieve
     * @param offset, the initial offset
     * @return
     */
    public List<O> getItems(int count, int offset) {
        return getDatastore().find(clazz).offset(offset).limit(count).asList();
    }

    /**
     * A private helper method that can be applied to "creationDate", "crawledDate", "lastModifiedDate".
     * For usage sample see the methods below
     *
     * @param dateField
     * @param start
     * @param end
     * @param numObjects
     * @param asc
     * @return
     */
    private List<O> findByDate(String dateField, Date start, Date end, int numObjects, boolean asc) {
        if (start == null)
            start = new Date(0);
        if (end == null)
            end = new Date();
        return getDatastore().find(clazz).filter(dateField + " >", start).filter(dateField + " <", end).order(asc ? dateField : '-' + dateField).limit(numObjects).asList();
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
     * @param numObjects
     * @return
     */
    public List<O> createdInPeriod(Date start, Date end, int numObjects) {
        return findByDate("creationDate", start, end, numObjects, true);
    }

    /**
     * Returns a list of objects that are similar to the specified object
     *
     * @param object
     * @param threshold
     * @return
     */
    public List<Similarity> similar(Image object, double threshold) {
        //return getDatastore().find(Similarity.class).field("firstObject").equal(object).order("similarityScore").asList();
        Query<Similarity> q = getDatastore().createQuery(Similarity.class);
        q.or(
                q.criteria("firstObject").equal(object),
                q.criteria("secondObject").equal(object)
        );
        return q.order("-similarityScore").filter("similarityScore >", threshold).asList();
    }

    public List<? extends Association> getAssociationsOfType(Object object, Class clazz) {
        Query<Association> q = getDatastore().createQuery(Association.class);
        q.and(
                q.criteria("one").equal(object.getId()),
                q.criteria("class").equal(clazz)
        );
        return q.asList();
    }

}
