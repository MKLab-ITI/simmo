package gr.iti.mklab.simmo.morphia;

import gr.iti.mklab.simmo.items.Image;
import gr.iti.mklab.simmo.mocks.MockObjectFactory;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Image Data Access Object
 *
 * @author kandreadou
 * @version 1.0.0
 * @since September 12, 2014
 */
public class ImageDAO extends BasicDAO<Image, ObjectId> {

    public ImageDAO() {
        super(Image.class, MorphiaManager.getMongoClient(), MorphiaManager.getMorphia(), MorphiaManager.getDB().getName());
    }

    private List<Image> findByDate(String dateField, Date start, Date end, int numImages, boolean asc) {
        if(start==null)
            start = new Date(0);
        if(end==null)
            end = new Date();
        return getDatastore().find(Image.class).filter(dateField + " >", start).filter(dateField + " <", end).limit(numImages).order(asc ? dateField : '-' + dateField).asList();
    }

    /**
     * Returns a list of images crawled before the specified date
     * It returns by default the first 100 images in ascending order
     *
     * @param end
     * @return
     */
    public List<Image> crawledBefore(Date end){
        return findByDate("crawlDate", null, end, 100, true);
    }

    /**
     * Returns a list of images crawled after the specified date
     * It returns by default the first 100 images in ascending order
     *
     * @param start
     * @return
     */
    public List<Image> crawledAfter(Date start) {
        return findByDate("crawlDate", start, null, 100, true);
    }

    public List<Image> findNear(double longitude, double latitude, int numImages) {
        return getDatastore().find(Image.class).field("location.coordinates").near(longitude, latitude).limit(numImages).asList();
    }

    public static void main(String[] args) throws Exception {
        MorphiaManager.setup("morphia");
        ImageDAO dao = new ImageDAO();
        dao.save(MockObjectFactory.getImage("today2"));

        List<Image> images = dao.findNear(45.67, 34.87, 10);
        for (Image i : images) {
            System.out.println(i.getId() + " " + i.getCrawlDate());
        }
        MorphiaManager.tearDown();
    }
}
