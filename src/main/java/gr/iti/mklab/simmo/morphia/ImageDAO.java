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

    /**
     * Returns a list of images crawled before the specified date
     * @param end
     * @return
     */
    public List<Image> crawledBefore(Date end, int numImages){
       return getDatastore().find(Image.class).field("crawlDate").lessThanOrEq(end).limit(numImages).asList();
    }

    /**
     * Returns a list of images crawled after the specified date
     * @param start
     * @return
     */
    public List<Image> crawledAfter(Date start, int numImages){
        return getDatastore().find(Image.class).field("crawlDate").greaterThanOrEq(start).limit(numImages).asList();
    }

    public List<Image> findNear(double longitude, double latitude, int numImages){
        return getDatastore().find(Image.class).field("location.coordinates").near(longitude, latitude).limit(numImages).asList();
    }

    public static void main(String[] args) throws Exception {
        MorphiaManager.setup("morphia");
        ImageDAO dao = new ImageDAO();
        dao.save(MockObjectFactory.getImage("today2"));
        // Create a calendar object with today date. Calendar is in java.util pakage.
        //Calendar calendar = Calendar.getInstance();
        // Move calendar to yesterday
        //calendar.add(Calendar.DATE, -1);
        //List<Image> images = dao.crawledAfter(calendar.getTime(),1);
        List<Image> images = dao.findNear(45.67,34.87,10);
        for(Image i:images){
            System.out.println(i.getId()+" "+i.getCrawlDate());
        }
        MorphiaManager.tearDown();
    }
}
